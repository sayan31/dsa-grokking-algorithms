package com.sayan.algorithms.dnc;

import java.io.IOException;
import java.util.Scanner;

public class RecursiveDigitSum {
	/**
	 * @param n - a number expressed as a string
	 * @param k - repeating factor i.e. the digits repeat k number of times
	 * @return - the super digit i.e. the repeating digit sum of all the digits
	 */
	static int superDigit(String n, int k) {
        long stringSum = getSumOfStringDigits(n)*k;
        long digitSumFromStringSum = getSumOfIntDigits(stringSum);
        while (digitSumFromStringSum/10!=0){
            digitSumFromStringSum=getSumOfIntDigits(digitSumFromStringSum);
        }
        return (int)digitSumFromStringSum;
    }

    /**
     * @param n - the original number with digits repeated k times
     * @return - the digit sum
     */
    static long getSumOfStringDigits(String n){
        //Extract the length of the string
        int noOfDigits = n.length();
        //store the digit (in int form) at the last position
        int currentDigit = n.charAt(noOfDigits-1)-'0';
        /* Base case
         * If the length of the string is only 1, return the digit as the super digit.
         */
        if(noOfDigits<=1){
            return currentDigit;
        }else{
        	/* Recursive case
        	 * Return the sum of the current digit and the super digit of the 
        	 * remaining digits in the input.
        	 */
            return currentDigit + getSumOfStringDigits(n.substring(0,noOfDigits-1));
        }    
    }

    /**
     * @param stringSum - sum of digits of original input
     * @return digit sum of stringSum
     */
    static long getSumOfIntDigits(long stringSum){
        if(stringSum/10!=0){
            return (stringSum%10)+getSumOfIntDigits(stringSum/10);
        }
        return stringSum%10;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);
        
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
