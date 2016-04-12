package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainCountOnes {
	public static void main (String[] args) {

	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	        	countOneBit(Integer.parseInt(line));
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}

	private static void countOneBit(int inputNumber) {
		int count=0;
		int remainder;
		while(inputNumber != 0){
			remainder = inputNumber % 2;
			inputNumber = inputNumber/2;
			if (remainder == 1) count++;
		}
		System.out.println(count);
	}
}

