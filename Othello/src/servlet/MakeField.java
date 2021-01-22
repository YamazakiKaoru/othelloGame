package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Field.Field;

@WebServlet("/MakeField")
public class MakeField extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MakeField() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext application = this.getServletContext();
		Field field = (Field)application.getAttribute("Field");

		if(field == null) {
			field = new Field("誰でも歓迎！！","");
		}


		//フォワードパスの設定
		String fowardPath = "/WEB-INF/RoginResult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(fowardPath);
		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}

}
