package com.sayan.algorithms.dnc;

import java.io.*;
import java.util.*;

class MaximumNumber {
	
	//private static final Scanner scanner = new Scanner(System.in);
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	/**
	 * @param inputArray
	 * @param currentIndex
	 * @param endIndex
	 * @return the maximum number in the input array
	 */
	static int findMax(int inputArray[],int currentIndex,int endIndex) {
		/* The base case.
		 * currentIndex is initially 0, i.e. the first array element.
		 * The condition implies that all the elements in the array have been checked.
		 */
		if(currentIndex>=endIndex) {
			return inputArray[currentIndex];
		}
		/* The recursive calls.
		 * Return the greater of the value at currentIndex and the remaining elements 
		 * of the array.
		 */
		else {
			return Math.max(inputArray[currentIndex], findMax(inputArray, ++currentIndex, endIndex));
		}
	} 

	public static void main(String[] args) {
		try {
			int[] inputArray = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int maxNumber = findMax(inputArray,0,inputArray.length-1);
			
			System.out.println("The maximum number is: "+maxNumber);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
	}

}
