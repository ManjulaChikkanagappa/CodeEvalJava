package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainGlueShreddedPieces {
	public static void main (String[] args) {

	    try {
	        File file = new File("input.txt");
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	        	gluePieces(line.split("\\|"));
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}

	private static void gluePieces(String[] textPieces) {
		for(int index=0;index<textPieces.length;index++){
			System.out.println(textPieces[index]);
		}
		
	}
}
