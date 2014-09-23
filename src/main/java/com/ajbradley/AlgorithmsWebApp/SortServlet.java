package com.ajbradley.AlgorithmsWebApp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.simple.JSONObject;

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
			int[] numsToSort;
			String alg;
			String numShots;
			double[] timeElapsed;


			try{
				numInts = Integer.parseInt(request.getParameter("numInts"));
			} catch(java.lang.NullPointerException e) {
				//Add more catch statements for non-ints
				numInts = 10;
			}
			try{
				numShots = request.getParameter("numShots");
			} catch(java.lang.NullPointerException e) {
				//Add more catch statements for non-ints
				numShots = "range";
			}
			try{
				alg = request.getParameter("algorithm");
			} catch(java.lang.NullPointerException e) {
				//Add some logic to make sure submitted algorithm matches one of the those below
				alg = "inPlaceInsertionSort";
			}

			if("single".equals(numShots)) {
				numsToSort = new int[1];
				timeElapsed = new double[1];
				numsToSort[0] = numInts;
			} else if("range".equals(numShots)) {
				numsToSort = new int[10];
				timeElapsed = new double[10];
				for(int i=1; i<=10; i++) {
					int n = Math.round(numInts*i/10);
					numsToSort[i-1] = n;
				}
			} else {
				//Sort 10 ints in case this value is left out of the post attribute list
				numsToSort = new int[1];
				timeElapsed = new double[1];
				numsToSort[0] = 10;
			}
			
			
			if(alg.equals("inPlaceInsertionSort") ) {
				for(int i=0; i<numsToSort.length; i++) {
					InPlaceInsertionSort sort = new InPlaceInsertionSort(numsToSort[i]);
					timeElapsed[i] = sort.startSort();
				}
			} else if(alg.equals("insertionSort") ) {
				for(int i=0; i<numsToSort.length; i++) {
					InsertionSort sort = new InsertionSort(numsToSort[i]);
					timeElapsed[i] = sort.startSort();
				}
			} else if(alg.equals("modifiedQuickSort") ) {
				for(int i=0; i<numsToSort.length; i++) {
					ModifiedQuickSort sort = new ModifiedQuickSort(numsToSort[i]);
					timeElapsed[i] = sort.startSort();
				}
			}
			else {
				for(int i=0; i<numsToSort.length; i++) {
					InsertionSort sort = new InsertionSort(numsToSort[i]);
					timeElapsed[i] = sort.startSort();
				}
			}
			

				//Respond to ajax POST
				response.setContentType("application/json");
				JSONObject outputJObject = new JSONObject();
				for(int j=0; j<timeElapsed.length; j++) {
					outputJObject.put(String.valueOf(numsToSort[j]), String.valueOf(timeElapsed[j]));
				}
				PrintWriter out = response.getWriter();
				out.print(outputJObject);
				out.flush();
			

			//else {
			//	request.getRequestDispatcher("/sort.jsp").forward(request, response);
			//}
		
	}
}