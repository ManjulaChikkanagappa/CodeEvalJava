package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainLongestSubstring {
	public static void main (String[] args) {

	    try {
	        File file = new File("input.txt");
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	        	findLongestSubstring(line);
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}

	private static void findLongestSubstring(String inputString) {
		String longestSubString="";
		int length = inputString.length();
		for (int i =0 ;i < length; i++){
			for (int j=i;j< length; j++){
				String temp = inputString.substring(j);
				String sub = inputString.substring(i, j);
				if (temp.contains(sub)){
					if (sub != null && sub.length() > longestSubString.length())
					longestSubString = sub;
				}
			}
		}
		if (longestSubString.trim().isEmpty()){
			System.out.println("NONE");
		} else{
			System.out.println(longestSubString);
		}
	}
}
