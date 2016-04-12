package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class MainSort {
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				sortTime(line.split(" "));
			}
	        in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

	private static void sortTime(String[] timeStamps) {
		Arrays.sort(timeStamps, new CustomSort());
		for (String ts : timeStamps){
			System.out.print(ts+" ");
		}
		System.out.println();
	}
}

class CustomSort implements Comparator<String> {

	private static final int TIME_PARTS = 3;

	@Override
	public int compare(String ts1, String ts2) {
		int TIME_INDEX = -1;
		Integer[] time1 = getIntegerArray(ts1);
		Integer[] time2 = getIntegerArray(ts2);

		int result = 0;
		while (++TIME_INDEX < TIME_PARTS) {
			result = time2[TIME_INDEX].compareTo(time1[TIME_INDEX]);
			if (result != 0) {
				return result;
			}
		}
		return result;
	}

	private Integer[] getIntegerArray(Object ts) {
		String[] time = ((String) ts).split(":");
		Integer[] timeInt = new Integer[time.length];

		for (int i = 0; i < time.length; i++) {
			timeInt[i] = Integer.valueOf(time[i]);
		}
		return timeInt;
	}
}
