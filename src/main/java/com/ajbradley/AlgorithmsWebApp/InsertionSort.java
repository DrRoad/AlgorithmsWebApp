package com.ajbradley.AlgorithmsWebApp;

import java.util.Random;
import java.lang.System.*;


public class InsertionSort {

	private int[] arrayToSort;
	private int[] sortedArray;
	
	public InsertionSort(int n) {

		arrayToSort = new int[n];
		sortedArray = new int[n];
		Random rand = new Random();
		for(int i=0; i<n; i++) {
			arrayToSort[i] = rand.nextInt(1000);
		}
		
	}
	
	public double startSort() {
		
		long time0 = System.nanoTime();
		sortedArray[0] = arrayToSort[0];
		for(int key=1; key<arrayToSort.length; key++) {
			sortedArray[key] = arrayToSort[key];
			for(int j=key; j>0; j--) {
				if(sortedArray[j] < sortedArray[j-1]) {
					int temp = sortedArray[j-1];
					sortedArray[j-1] = sortedArray[j];
					sortedArray[j] = temp;
				}
			}
		}
		long time1 = System.nanoTime();
		double timeElapsed = (time1 - time0) * 1E-9;

		return timeElapsed;

	}
	
}
