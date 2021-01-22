package model.Board;

public class Piece {
	
    /** コマの状態を表す定数 */
    public static final String EMP = "  ";
    public static final String SIRO = "○ ";
    public static final String KURO = "● ";

    /** コマの方向を表す列挙型 */
    public enum Direction {
        UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT, UP_LEFT;
    }

    /**
     * コンストラクタ
     * @param x x座標
     * @param y y座標
     */
    public Piece(int x, int y) {
        setX(x);
        setY(y);
        setState(EMP);
    }
	//座標
	private int x;
	private int y;
	//状態
	private String state;

	private Board getBoard;

	public Board getBoard() {
		return getBoard;
	}
	public void setBoard(Board getBoard) {
		this.getBoard = getBoard;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}



}
