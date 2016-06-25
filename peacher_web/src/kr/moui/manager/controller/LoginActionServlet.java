package kr.moui.manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.moui.manager.db.DatabaseManager;
import kr.moui.manager.db.ManagerInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.action")
public class LoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginActionServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = request.getParameter("id");
		String result = null;
		ManagerInfo mi = DatabaseManager.getInstance().selectManagerInfoByUserId(userId);
		if( mi == null ) {
			result = "1";
			session.invalidate();
		} else if (!mi.getUserPw().equals(request.getParameter("pw"))) {
			session.invalidate();
			result = "2";
		} else {
			result = "0";
			session.setAttribute("id", mi.getUserId());
		}
		response.getWriter().append(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
