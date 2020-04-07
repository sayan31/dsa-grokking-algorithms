package com.sayan.algorithms;

import java.util.Scanner;

class SelectionSort {
	
	/**
	 * @param inputArray
	 */
	void selectionSort(int inputArray[]) {
		for(int index=inputArray.length-1;index>=0;index--) {
			int indexCurrentLargest = select(inputArray,index);
			
			int temp = inputArray[index];
			inputArray[index]=inputArray[indexCurrentLargest];
			inputArray[indexCurrentLargest]=temp;
		}
	}
	

	/*
	 * Selects the largest number in the section of the list currently being sorted
	 *
	 * @param arr (input array to be sorted)
	 * 
	 * @param i (Index of the currently largest number)
	 * 
	 * @return the index of the number larger than arr[i]
	 */
	int select(int arr[], int i) {

		int current = i;// stores the index of the currently largest number
		// Run a loop from the second last element in the list to the start
		for (int counter = current - 1; counter >= 0; counter--) {
			/*
			 * Check if the current number is greater than the currently largest number. If
			 * yes, set the value of current as the index of the current number. Then return
			 * the current variable value to the calling routine. The calling routine will
			 * swap the two numbers, so that the ascending order is maintained. If the
			 * current number is smaller than the currently largest number, no processing is
			 * required as the ascending order is maintained.
			 */
			if (arr[counter] > arr[current]) {
				current = counter;
			}
		}
		return current;
	}
	
	void printArray(int arr[]) {
		for(int value:arr) {
			System.out.print(value+" ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SelectionSort sSort = new SelectionSort();
		
		int noOfTestCases = in.nextInt();
		System.out.println("The number of test cases: "+noOfTestCases);
		
		while(noOfTestCases>0) {
			int noOfElements = in.nextInt();
			System.out.println("The number of elements to be sorted: "+noOfElements);
			
			int inputArray[]=new int[noOfElements];
			
			for(int counter=0;counter<noOfElements;counter++) {
				inputArray[counter]=in.nextInt();
			}
			
			sSort.selectionSort(inputArray);
			sSort.printArray(inputArray);
			
			noOfTestCases--;
		}
		in.close();
		
	}
}
