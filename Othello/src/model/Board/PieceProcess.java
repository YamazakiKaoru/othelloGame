/**
 * ピースの処理を行うクラス
 * 主に反転処理
 */

package model.Board;

import java.util.ArrayList;
import java.util.List;

import model.Board.Piece.Direction;



public class PieceProcess {
	Board board = new Board();


	/**
	 *　指定した駒が置けるかどうか
	 * @param board　ボード情報
	 * @param target　指定した駒
	 * @return　駒が置けるかどうか
	 */
	public  boolean canTurnOver(Board board,Piece target) {
		this.board = board;

		/** 各方向で置けるかのbooleanをもつ*/
		List<Boolean> results = new ArrayList<Boolean>();

		/** 全方向に対して再帰を行う */
		for(Direction s : Direction.values()) {
			Piece nextTarget = board.getAround(s, target);
			results.add(checkTurnOver(s,nextTarget,0));
		}

		/**  一つの方向でも置けるところがあったらtrueを返す*/
		for(boolean a: results) {
			if(a)return a;
		}
		return false;

	}


	/**
	 * 与えられた方向に対して反転処理が出来るかどうか
	 * @param direction　方向
	 * @param target　駒
	 * @param count　再帰回数
	 * @return　与えられた方向に対して反転処理が出来るかどうか
	 */
	private boolean checkTurnOver(Direction direction,Piece target ,int count) {
		boolean result = false;

		if(board.isOpponents(target)){
			count++;
			final Piece nextTarget = board.getAround(direction, target);
			result = checkTurnOver(direction,nextTarget,count);

			if(result) {
				target.setState(board.getTurnState());
			}
			return result;

		}else {
			return canTurnOverThisDirection(target, count);
		}
	}

    private boolean canTurnOverThisDirection(Piece target, int count) {
        /** 最後尾のコマが自分のものだった場合 */
        if (board.isMine(target)) {
            return count > 0; // 呼び出し元に、この方向のコマをひっくり返していいかどうかを返す。道中に相手のコマがあったらtrue。道中でひとつも相手のコマがなかったらfalse。

        /** 最後尾のコマがなかった場合 */
        } else {
            return false; // 途中で相手のコマがあったかどうかにかかわらずfalseを返す。
        }
    }




}

