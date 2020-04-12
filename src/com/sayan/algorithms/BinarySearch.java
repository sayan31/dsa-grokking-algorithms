package com.sayan.algorithms;

import java.util.Scanner;

class BinarySearch {
	/**
	 * @param nums (a SORTED array)
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
        //Define the section of the array to search
        int start=0, end=nums.length-1;
        //Create a loop which runs until the no. of items to search is reduced to 1
        while(start<=end){
            //Choose the number in the middle of the section of the array to search
            int middle=(start+end)/2;
            /* Conditionals to check if 
             * target is less than, greater than
             * or equal to the number in the middle of array section
             */            
            if(target==nums[middle]){
                //Return the middle index if target = no. in the middle
                return middle;
            }else if (target>nums[middle]){
                //Increment the start index to the middle+1 position & repeat loop
                start=middle+1;
            }else{
                //Decrement the end index to the middle-1 position & repeat loop
                end=middle-1;
            }
        }
        //Return -1 if target is not found in the array
        return -1;
    }
	
	public int recursiveSearch(int[] nums, int target, int start, int end) {
		if(start<=end) {
			int middle = start+((end-start)/2);
			
			if (target==nums[middle]) {
				return middle;			
			}else if(target>nums[middle]) {
				return recursiveSearch(nums,target,middle+1,end);
			}else {
				return recursiveSearch(nums,target,start,middle-1);
			}			
		}
		return -1;
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BinarySearch bSearch = new BinarySearch();
		
		int noOfTestCases = in.nextInt();
		System.out.println("The number of test cases: "+noOfTestCases);
		
		for(int counter=0;counter<noOfTestCases;counter++) {
			int noOfElements = in.nextInt();
			System.out.println("The number of elements to be searched: "+noOfElements);
			int noToSearch = in.nextInt();
			System.out.println("The number to find: "+noToSearch);
			
			int inputArray[] = new int[noOfElements];
			
			System.out.println("-------Creating Array--------");
			for(int arrayCounter=0;arrayCounter<noOfElements;arrayCounter++) {
				inputArray[arrayCounter]=in.nextInt();
			}
			System.out.println("-------Array creation done--------");
			
			int finalIndex= bSearch.search(inputArray, noToSearch);		
			int finalRecursiveIndex = bSearch.recursiveSearch(inputArray, noToSearch, 0, inputArray.length-1);
			
			String outputMessage1 = finalIndex==-1?"Number not found":"Number found at index "+finalIndex;
			String outputMessage2 = finalIndex==-1?"Number not found":"Number found at index "+finalRecursiveIndex;
			
			System.out.println(outputMessage1);
			System.out.println(outputMessage2);
		}
		in.close();		
	}

}
