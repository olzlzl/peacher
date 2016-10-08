package kr.moui.manager.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Login {
	
	public static String getIdFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
	    String id = null;
	    if(session != null && session.getAttribute("id") != null) {
	    	id = (String)session.getAttribute("id");
	    } else {
	    	id = null;
	    }
	    
	    return id;
	}
	
	public static String getTargetPath(String id, String path) {
		if(id==null) {
			return "/jsp/login.jsp";
		} else {
			return path;
		}
	}
}
