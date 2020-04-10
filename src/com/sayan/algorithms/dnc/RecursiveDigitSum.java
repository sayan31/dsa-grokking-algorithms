package com.sayan.algorithms.dnc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RecursiveDigitSum {
	static int superDigit(String n, int k) {
        long stringSum = getSumOfStringDigits(n)*k;
        long digitSumFromStringSum = getSumOfIntDigits(stringSum);
        while (digitSumFromStringSum/10!=0){
            digitSumFromStringSum=getSumOfIntDigits(digitSumFromStringSum);
        }
        return (int)digitSumFromStringSum;
    }

    static long getSumOfStringDigits(String n){
        //Extract the 
        int noOfDigits = n.length();
        int currentDigit = n.charAt(noOfDigits-1)-'0';
        if(noOfDigits<=1){
            return currentDigit;
        }else{
            return currentDigit + getSumOfStringDigits(n.substring(0,noOfDigits-1));
        }    
    }

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
