package model.Board;

import model.Board.Piece.Direction;

public class Board {

	/** コマ */
	Piece[][] board = new Piece[8][8];

	/**
	 * 白か黒かのターン情報を持つ
	 */
	private String turnState;

	/**
	 * コンストラクタ
	 */
	public Board() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				final Piece piece = new Piece(j, i);
				piece.setBoard(this);
				board[i][j] = piece;
			}
		}

		getPiece(3, 3).setState(Piece.KURO);
		getPiece(3, 4).setState(Piece.SIRO);
		getPiece(4, 3).setState(Piece.SIRO);
		getPiece(4, 4).setState(Piece.KURO);
	}

	/**
	 * 座標を指定してコマを取得する
	 * @param x x座標
	 * @param y y座標
	 * @return コマ
	 */
	public Piece getPiece(int x, int y) {
		if (x < 0 || y < 0 || x > 7 || y > 7) {
			return new Piece(-1, -1);
		} else {
			return board[y][x];
		}
	}

	/**
	 * 方向を指定してピースの取得
	 * @param direction　方向
	 * @param piece　与えられた駒
	 * @return　与えられた駒の方向にある駒
	 */
	public Piece getAround(Direction direction, Piece piece) {
		switch (direction) {
		case UP:
			return getPiece(piece.getX(), piece.getY() - 1);
		case UP_RIGHT:
			return getPiece(piece.getX() + 1, piece.getY() - 1);
		case RIGHT:
			return getPiece(piece.getX() + 1, piece.getY());
		case DOWN_RIGHT:
			return getPiece(piece.getX() + 1, piece.getY() + 1);
		case DOWN:
			return getPiece(piece.getX(), piece.getY() + 1);
		case DOWN_LEFT:
			return getPiece(piece.getX() - 1, piece.getY() + 1);
		case LEFT:
			return getPiece(piece.getX() - 1, piece.getY());
		case UP_LEFT:
			return getPiece(piece.getX() - 1, piece.getY() - 1);
		default:
			return new Piece(-1, -1);
		}
	}

	/**
	 * 与えられた駒が相手の駒かどうか
	 * @param piece　駒
	 * @return　駒が相手の駒かどうか
	 */
	public boolean isOpponents(Piece piece) {

		if (piece.getState().equals(Piece.EMP)) {
			return false;
		} else if(!piece.getState().equals(turnState) ){
			return true;
		}
		return false;
	}

	/**
	 * 与えられた駒が自分のものかどうか
	 * @param piece　駒
	 * @return　駒が自分のものかどうか
	 */
	public boolean isMine(Piece piece) {
		if(piece.getState().equals(turnState)) {
			return true;
		}
		return false;
	}

	//以下getter,setter
	public String getTurnState() {
		return turnState;
	}

	public void setTurnState(String turnState) {
		this.turnState = turnState;
	}


	public String getPieceState(int x,int y) {
		return board[x][y].getState();
	}

}
