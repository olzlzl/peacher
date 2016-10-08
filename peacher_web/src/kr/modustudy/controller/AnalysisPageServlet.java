package kr.modustudy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.modustudy.analysis.TestAnalyzer;


/**
 * Servlet implementation class AnalysisPageServlet
 */
@WebServlet("/analysis.html")
public class AnalysisPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalysisPageServlet() {
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
        String grade = request.getParameter("grade");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String incorrectNumber = request.getParameter("incorrect_number");

        TestAnalyzer ta = new TestAnalyzer();
        if(ta.checkTestInfo(grade, year, month)) {
        	ta.setIncorrectNumberList(incorrectNumber);
        	ta.setAnalysisData();

        	request.setAttribute("ta", ta);
            String targetPath = "/jsp/analysis.jsp"; 
            RequestDispatcher rd = sc.getRequestDispatcher(targetPath);
            rd.forward(request, response);
        } else {
            String targetPath = "/jsp/error.jsp"; 
            RequestDispatcher rd = sc.getRequestDispatcher(targetPath);
            rd.forward(request, response);
        }
        
	}


}
