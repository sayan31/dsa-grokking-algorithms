package com.sayan.algorithms.dnc;

import java.io.*;
import java.util.*;

class MaximumNumber {
	
	//private static final Scanner scanner = new Scanner(System.in);
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	static int findMax(int inputArray[],int currentIndex,int endIndex) {
		
		if(currentIndex>=endIndex) {
			return inputArray[currentIndex];
		}else {
			return Math.max(inputArray[currentIndex], findMax(inputArray, ++currentIndex, endIndex));
		}
	} 

	public static void main(String[] args) {
		try {
			int[] inputArray = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			int currentIndex=0;
			int maxNumber = findMax(inputArray,currentIndex,inputArray.length-1);
			
			System.out.println("The maximum number is: "+maxNumber);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
	}

}
