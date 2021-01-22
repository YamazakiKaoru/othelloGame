package model.Board;

import java.util.ArrayList;
import java.util.List;

import model.Board.Piece.Direction;



public class PieceProcess {
	Board board = new Board();


	public boolean canTurnOver(Board board,Piece target) {
		this.board = board;

		List<Boolean> results = new ArrayList<Boolean>();

		//
		for(Direction s : Direction.values()) {
			Piece nextTarget = board.getAround(s, target);
			results.add(checkTurnOver(s,nextTarget,0));
		}

		for(boolean a: results) {
			if(a)return a;
		}
		return false;

	}



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
        // 最後尾のコマが自分のものだった場合
        if (board.isMine(target)) {
            return count > 0; // 呼び出し元に、この方向のコマをひっくり返していいかどうかを返す。道中に相手のコマがあったらtrue。道中でひとつも相手のコマがなかったらfalse。

        // 最後尾のコマがなかった場合
        } else {
            return false; // 途中で相手のコマがあったかどうかにかかわらずfalseを返す。
        }
    }




}

