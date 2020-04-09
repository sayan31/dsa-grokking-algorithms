package com.sayan.algorithms.dnc;

import java.util.Scanner;

public class SumOfArray {
	
	int sumOfArray(int inputArray[], int noOfElements) {		
		if(noOfElements<=0) {
			return 0;
		}else {
			return inputArray[noOfElements-1]+sumOfArray(inputArray,noOfElements-1);
		} 
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		SumOfArray sumOfArray = new SumOfArray();
		
		int noOfTestCases = in.nextInt();
		System.out.println("The number of test cases: "+noOfTestCases);
		
		while(noOfTestCases>0) {
			int noOfElements = in.nextInt();
			System.out.println("The number of array elements: "+noOfElements);
			
			int inputArray[]=new int[noOfElements];
			
			for(int counter=0;counter<noOfElements;counter++) {
				inputArray[counter]=in.nextInt();
			}
			
			System.out.println(sumOfArray.sumOfArray(inputArray, noOfElements));
			
			
			noOfTestCases--;
		}
		in.close();
	}

}
