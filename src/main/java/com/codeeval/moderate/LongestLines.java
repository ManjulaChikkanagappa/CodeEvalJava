package com.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestLines {

	static List<String> lineHolder;
	static int numOfLines;
	public static int FIRST = 0;

	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			numOfLines = Integer.valueOf(in.readLine());
			lineHolder = new ArrayList<String>(numOfLines);
			while ((line = in.readLine()) != null) {
				findLongLine(line);
			}
			Collections.sort(lineHolder, Collections.reverseOrder(new Compare()));
			lineHolder.stream().forEach(System.out::println);
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

	private static void findLongLine(String line) {
		if (lineHolder.size() < numOfLines) {
			lineHolder.add(line);
		} else {
			Collections.sort(lineHolder, new Compare());
			if (line.length() > lineHolder.get(FIRST).length()) {
				lineHolder.remove(FIRST);
				lineHolder.add(line);
			} else if (line.length() > lineHolder.get(lineHolder.size() - 1).length()) {
				lineHolder.remove(lineHolder.size() - 1);
				lineHolder.add(line);
			}
		}
	}
}

class Compare implements Comparator<String> {

	@Override
	public int compare(String first, String second) {
		return new Integer(first.length()).compareTo(second.length());
	}
}