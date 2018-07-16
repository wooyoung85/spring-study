package com.wooyoung.toby_vol2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleGetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		response.getWriter().print("<html><body>");
		response.getWriter().print("Hello " + name);
		response.getWriter().print("</body></html>");
	}
}
