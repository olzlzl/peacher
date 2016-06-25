package kr.moui.manager.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.moui.manager.db.DatabaseManager;
import kr.moui.manager.db.StudentInfo;

/**
 * Servlet implementation class SearchActionServlet
 */
@WebServlet("/search.action")
public class SearchActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("q");
		List<StudentInfo> siList = DatabaseManager.getInstance().searchStudentInfoList(query);
		String result = "";
		
		if(siList != null) {
			StringBuffer buffer = new StringBuffer();
			for(StudentInfo si : siList) {
				buffer.append(si.getStudentName() + "<br />");
			}
			response.getWriter().append(URLEncoder.encode(buffer.toString(), "UTF-8"));
		} else {
			response.getWriter().append(URLEncoder.encode("寃��깋寃곌낵媛� �뾾�뒿�땲�떎.", "UTF-8"));
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
