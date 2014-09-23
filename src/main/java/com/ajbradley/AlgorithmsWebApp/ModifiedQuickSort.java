package com.ajbradley.AlgorithmsWebApp;

import java.util.Random;
import java.lang.System.*;
import java.util.Arrays;

public class ModifiedQuickSort {

	private int[] arrayToSort;
	private int[] sortedArray;
	
	public ModifiedQuickSort(int n) {

		arrayToSort = new int[n];
		sortedArray = new int[n];
		Random rand = new Random();
		for(int i=0; i<n; i++) {
			arrayToSort[i] = rand.nextInt(1000);
		}
		
	}
	
	public double startSort() {
		
		long time0 = System.nanoTime();
		Arrays.sort(arrayToSort);
		long time1 = System.nanoTime();
		double timeElapsed = (time1 - time0) * 1E-9;

		return timeElapsed;

	}
	
}
