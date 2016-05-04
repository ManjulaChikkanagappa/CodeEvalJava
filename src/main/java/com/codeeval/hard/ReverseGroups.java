package com.codeeval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseGroups {

	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				reverseGroup(line.split(";"));
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

	private static void reverseGroup(String[] split) {
		List<String> list = new ArrayList<String>(Arrays.asList(split[0].split(",")));
		Integer count = Integer.valueOf(split[1]);

		int numOfIteration = list.size() / count;
		int index=0;
		for (int j = 0; j < numOfIteration; j++) {
			Collections.reverse(list.subList(index, index+=count));
		}
		for (int i = 0; i < list.size()-1; i++) {
			System.out.print(list.get(i)+",");
		}
		System.out.println(list.get(list.size()-1));
	}

}

