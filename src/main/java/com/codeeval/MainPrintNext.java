package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainPrintNext {
	public static void main(String[] args) {

		try {
			File file = new File("input.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				findNextNumber(line);
			}
	        in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

	public static void findNextNumber(String line) {
		
		List<String> holdList = new ArrayList<>();
		holdList.add(line);
		String dummy = line.replaceAll("0", "");
		char[] temp = dummy.toCharArray();
		Arrays.sort(temp);
		
		holdList.add(new String(new String(temp)));
		for (int i = (dummy.length() - 1); i > 0; i--) {
			char hold = temp[i-1];  
			temp[i-1] = temp[i];
			temp[i] = hold;
			holdList.add(new String(temp));
		}
		Collections.sort(holdList);
		
		int size = holdList.size();
		for (int i =0;i< size ; i++){
			StringBuilder builder = new StringBuilder(holdList.get(i));
			builder.insert(1, "0");
			holdList.add(builder.toString());
		}
		Collections.sort(holdList);
		int index = holdList.indexOf(line);
		if (index != -1 && (index+1) < holdList.size()){
			while (holdList.get(index) == holdList.get(index+1)){
				index++;
			}
			System.out.println(holdList.get(index+1));
		} 
	}
}