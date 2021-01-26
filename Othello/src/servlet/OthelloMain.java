package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Board.Board;
import model.Board.Piece;
import model.Board.PieceProcess;
import model.Field.Field;

@WebServlet("/OthelloMain")
public class OthelloMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OthelloMain() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** アプリケーションスコープに保存されたボード情報を取得 */
		ServletContext application = this.getServletContext();
		Field field = (Field) application.getAttribute("Field");

		field.setNumber(field.getNumber()+1);

		/** リクエストパラメータの取得 */
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String state = request.getParameter("state");

		/** 存在しないとき作成（初回リクエスト時） */
		if(field.getBoard() == null) {
			field.setBoard(new Board());
		}else if(id !=null){//オセロに何かを置こうとしたとき

			String[] ids = id.split("_",0);
			/**置きたいピースを生成 */
			Piece target = field.getBoard().getPiece(Integer.valueOf(ids[0]),Integer.valueOf(ids[1]));

			/** 置く駒の状態（白か黒）を設定 */
			if(state.equals("kuro")) {
				target.setState(Piece.KURO);
				field.getBoard().setTurnState(Piece.KURO);
			}else if(state.equals("siro")) {
				target.setState(Piece.SIRO);
				field.getBoard().setTurnState(Piece.SIRO);
			}

			/** ひっくりかえせたかどうか */
			PieceProcess pieceProcess = new PieceProcess();
			boolean a =pieceProcess.canTurnOver(field.getBoard(), target);

			if(!a) {//ひっくりかえせなかったら
				target.setState(Piece.EMP);
			}
		}

		/** アプリケーションスコープにボードの情報を保存 */
		application.setAttribute("Field", field);

		/** フォワード先の指定 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/OthelloBoard.jsp");
		dispatcher.forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
