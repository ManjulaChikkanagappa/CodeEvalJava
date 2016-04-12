package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MainBatsChallenge {
	public static final int MIN_DISTANCE_BUILDING = 6;
	public static void main (String[] args) {
	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	        	extractParams(line.trim().split(" "));
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}
	
	private static void extractParams(String[] input){
 		  int length_of_wire = Integer.parseInt(input[0]);
		  int distance_bats = Integer.parseInt(input[1]);
		  int existing_bats = Integer.parseInt(input[2]);
		  
		  int[] batIndexList = new int[existing_bats];
		  for (int batIndex = 0; batIndex < existing_bats ; batIndex++ )
			  batIndexList[batIndex] = Integer.parseInt(input[3+ batIndex]);
		  countMaxBats(length_of_wire, distance_bats, existing_bats, batIndexList);
	}

	private static void countMaxBats(int length_of_wire, int distance_bats, int existing_bats, int[] batIndexList) {
		int batCount = 0;
		int firstIndex = MIN_DISTANCE_BUILDING;
		int lastIndex = length_of_wire - MIN_DISTANCE_BUILDING;
		int indexSize = batIndexList.length -1;
	
		Arrays.sort(batIndexList);
		if (existing_bats == 0) {
			batCount = getBatCount(firstIndex, lastIndex, distance_bats) + 1;			
		}
		else {
			batCount += getBatCount(firstIndex, batIndexList[0], distance_bats);
			batCount += getBatCount(batIndexList[indexSize], lastIndex, distance_bats);
			for (int i= 0; i<indexSize; i++){
				if (batIndexList[i+1] - batIndexList[i] - 1 > 0)
				batCount += getBatCount(batIndexList[i], batIndexList[i+1], distance_bats)-1;
			}
		}
		System.out.println(batCount);
	}
	
	private static int getBatCount(int start, int end, int distance_bats){
		return ((end-start)/distance_bats);
	}
}
