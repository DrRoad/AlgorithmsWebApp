package com.ajbradley.AlgorithmsWebApp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SortServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response) 
		throws ServletException, IOException {

		String message = "Sort doGet called";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/sort.jsp").forward(request, response);
	}
}