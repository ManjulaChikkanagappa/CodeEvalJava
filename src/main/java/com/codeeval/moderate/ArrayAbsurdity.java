package com.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ArrayAbsurdity {

	public static void main (String[] args) {
	    try {
	        File file = new File("input.txt");
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	        	findDuplicate(line.trim().split(";"));
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}

	private static void findDuplicate(String[] inputArr) {
		int counter=0;
		String [] elementArr = inputArr[1].split(",");
		Set<String> storeData = new HashSet<>();
		while(counter < elementArr.length && storeData.add(elementArr[counter++])) ;
		System.out.println(elementArr[counter-1]);
	}
	
}
