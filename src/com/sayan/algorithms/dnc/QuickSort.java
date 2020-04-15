package com.sayan.algorithms.dnc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
	
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		//int[] inputArray = new int[] {5, 10, 2, 2, 6, 15, 18, 27, 26, 89};
		int[] inputArray;
		try {
			inputArray = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			
			quickSort(inputArray, 0, inputArray.length - 1);

			System.out.println("Sorted Array is: ");
			printArray(inputArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * @param inputArray
	 * @param startIndex
	 * @param endIndex
	 * Sorting an array in ascending order.
	 */
	private static void quickSort(int[] inputArray, int startIndex, int endIndex) {
		/* This is the base case.
		 * If the array is empty, or has only one element,
		 * there is no need to call the sorting function.
		 * Hence, return the single element array.
		 */
		if(inputArray.length<2) {
			return;
		}else {
			/* This is the recursive call section.
			 * First, partition the array on the basis of a pivot element.
			 * In this implementation, the pivot element is the element in the middle.
			 */
			int partitionIndex=partition(inputArray,startIndex,endIndex);
			/* Recursively call quickSort left call stack (for each recursive call).
			 * Stop once the partitionIndex-1 crosses the startIndex
			 * i.e. there are no more elements to sort to the left.
			 */
			if (startIndex<partitionIndex - 1) {
				quickSort(inputArray, startIndex, partitionIndex - 1);
			}
			/* Recursively call quickSort right call stack (for each recursive call).
			 * Stop once the partitionIndex crosses the endIndex
			 * i.e. there are no more elements to sort to the right.
			 */
			if (partitionIndex<endIndex) {
				quickSort(inputArray, partitionIndex, endIndex);
			}
		}		
	}

	/**
	 * @param inputArray
	 * @param startIndex
	 * @param endIndex
	 * @return 
	 */
	private static int partition(int[] inputArray, int startIndex, int endIndex) {
		// get the value of the element at the pivot point
		int pivotValue = inputArray[startIndex+((endIndex-startIndex)/2)];
		
		/*repeat some steps until the endIndex crosses over the startIndex
		 *i.e. all the elements in the array are covered
		 */
		while(startIndex<=endIndex) {
			/*Check if the value at position startIndex is less than the pivot value.
			 *If yes, then increment the startIndex value,
			 *i.e. keep that element to the left of the pivot value  
			 *& check the next value to the right
			 */
			while(inputArray[startIndex]<pivotValue) {
				startIndex++;
			}
			/*Check if the value at position endIndex is 
			 *greater than or equal to the pivot value.
			 *If no, then decrement the endIndex value,
			 *i.e. keep that element to the right of the pivot value
			 *& check the next value to the left 
			 */
			while(inputArray[endIndex]>pivotValue) {
				endIndex--;
			}
			/*When this step is reached, element at position startIndex
			 *is greater than pivot & element at position endIndex
			 *is less than pivot.
			 *If the startIndex & endIndex have not overlapped, then
			 *swap the elements currently at these two indices.
			 *Post that, move both the indices to the next positions. 
			 */
			if(startIndex<=endIndex) {
				swap(inputArray,startIndex,endIndex);
				startIndex++;endIndex--;
			}
		}
		
		/* Return the startIndex as the index for the partitioning
		 * of the original array.
		 */
		return startIndex;
	}

	/**
	 * @param inputArray
	 * @param startIndex
	 * @param endIndex
	 * Swap elements at startIndex & endIndex
	 */
	private static void swap(int[] inputArray, int startIndex, int endIndex) {
		int temp = inputArray[startIndex];
		inputArray[startIndex] = inputArray[endIndex];
		inputArray[endIndex] = temp;		
	}

	/**
	 * @param inputArray
	 * Print any array.
	 */
	private static void printArray(int[] inputArray) {
		int n = inputArray.length;
		for (int i = 0; i < n; ++i)
			System.out.print(inputArray[i] + " ");
		System.out.println();
	}

}
