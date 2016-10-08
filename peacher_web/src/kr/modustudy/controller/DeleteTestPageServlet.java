package kr.modustudy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.modustudy.db.DatabaseManager;
import kr.modustudy.db.TestInfo;


/**
 * Servlet implementation class AnalysisPageServlet
 */
@WebServlet("/delete_test.html")
public class DeleteTestPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTestPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAll(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAll(request, response);
	}
	
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        
        String testId = request.getParameter("test_id");

        String selectGrade = request.getParameter("s_grade");
        String selectYear = request.getParameter("s_year");

        DatabaseManager.getInstance().deleteTestInfo(testId);
        List<TestInfo> tiList = DatabaseManager.getInstance().selectTestInfo(selectGrade, selectYear);
        
        request.setAttribute("tiList", tiList);
        
        String targetPath = "/jsp/insert_test.jsp"; 
        RequestDispatcher rd = sc.getRequestDispatcher(targetPath);
        rd.forward(request, response);
	}

}
