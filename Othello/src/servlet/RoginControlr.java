package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Rogin.RoginCheck;
import model.Rogin.User;

@WebServlet("/RoginControlr")
public class RoginControlr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RoginControlr() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** リクエストパラメーターを取得 */
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");


		/** 登録処理を実行 */
		String fowardPath = "/Othello/MakeField";
		User user = new User(name,pass);
		RoginCheck roginCheck = new RoginCheck();

		/** ログイン出来るかのチェック */
		if(roginCheck.check(user)) {
			/** セッションの取得 */
			HttpSession session = request.getSession();
			session.setAttribute("User", user);
		}else {
			fowardPath = "/Othello/";
		}


		/** フォワードパスの設定 */
		response.sendRedirect(fowardPath);
	}

}
