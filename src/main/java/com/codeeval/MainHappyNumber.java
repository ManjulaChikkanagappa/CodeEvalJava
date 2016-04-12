package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainHappyNumber {
	public static void main(String[] args) {

		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				checkHappyNumber(line);
			}
	        in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

	private static void checkHappyNumber(String inputString) {
		List<Long> store = new ArrayList<>();
		long result = sumOfSquares(Long.valueOf(inputString));
		while (result != 1) {
			store.add(result);
			result = sumOfSquares(result);
			if (store.contains(result)){
				System.out.println("0");
				break;
			}
		}
		if (result == 1) {
			System.out.println("1");
		}
	}

	private static long sumOfSquares(long input) {
		long sum = 0;
		do {
			long remainder = input % 10;
			sum = sum + (remainder * remainder);
			input = input / 10;
		} while (input != 0);
		return sum;
	}
}
