package com.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SwapNumbers {
	public static int FIRST = 0;
	public static void main (String[] args) {
	    try {
	        File file = new File("input.txt");
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	        	swapNumbers(line.trim().split(" "));
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}

	private static void swapNumbers(String[] splitWords) {
		StringBuilder builder;
		for(int i =0;i<splitWords.length;i++){
			builder = new StringBuilder(splitWords[i]);
			char ch = builder.charAt(FIRST);
			builder.setCharAt(FIRST, builder.charAt(splitWords[i].length()-1));
			builder.setCharAt((splitWords[i].length()-1), ch);
			System.out.print(builder.toString()+" ");
		}
		System.out.println();
	}

}
