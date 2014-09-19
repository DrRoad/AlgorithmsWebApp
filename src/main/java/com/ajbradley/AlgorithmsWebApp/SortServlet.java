package com.ajbradley.AlgorithmsWebApp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SortServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response) 
		throws ServletException, IOException {
		request.getRequestDispatcher("/sort.jsp").forward(request, response);
			
	}

	public void doPost(HttpServletRequest request, 
					  HttpServletResponse response) 
		throws ServletException, IOException {
			
			int numInts;
			String alg;
			
			
				numInts = Integer.parseInt(request.getParameter("numInts"));	
			

			try{
				alg = request.getParameter("algorithm");
			} catch(java.lang.NullPointerException e) {
				alg = "inPlaceInsertionSort";
			} 
			
		
		if(alg.equals("inPlaceInsertionSort") ) {
			InsertionSort sort = new InsertionSort(numInts);
			double timeElapsed = sort.startSort();

			//Respond to ajax POST
			response.setContentType("text/plain");
			response.getWriter().write(String.valueOf(timeElapsed));

			//request.setAttribute("n", numInts);
			//request.setAttribute("timeElapsed", timeElapsed);
			//request.getRequestDispatcher("/sort.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/sort.jsp").forward(request, response);
		}
		
	}
}