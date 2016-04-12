package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainTextDollar {

	public static Map<Integer, String> store = new HashMap<>();

	public static void main(String[] args) {
		try {
			addWords();
			File file = new File("input.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				printTextDollar(line);
			}
	        in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

	public static void printTextDollar(String line) {
		int count = 0;
		Long value = Long.valueOf(line);
		StringBuilder textValue = new StringBuilder("Dollars");
		int prev = -1;
		while (value != 0) {
			int remainder = (int) (value % 10);
			value = value / 10;
			String currentValue = null;
			String remove = null;

			switch (count++) {
			case 0:
				if (remainder != 0) {
					currentValue = store.get(remainder);
				}
				prev = remainder;
				break;
			case 1:
				if (remainder != 0) {
					if (prev != 0 && remainder == 1) {
						currentValue = store.get(remainder * 10 + prev);
						remove = store.get(prev);
					} else {
						currentValue = store.get(remainder * 10);
					}
				}
				prev = remainder;
				break;
			case 2:
				if (remainder != 0) {
					currentValue = store.get(remainder) + "Hundred";
				}
				prev = remainder;
				break;
			case 3:
				if (remainder != 0) {
					currentValue = store.get(remainder) + "Thousand";
				}
				prev = remainder;
				break;
			case 4:
				if (remainder != 0) {
					if (prev != 0 && remainder == 1) {
						currentValue = store.get(remainder * 10 + prev);
						remove = store.get(prev);
					} else if (prev != 0 && remainder > 1) {
						currentValue = store.get(remainder * 10);
					} else{
						currentValue = store.get(remainder * 10) + "Thousand";
					}
				}
				prev = remainder;
				break;
			case 5:
				if (remainder != 0) {
					currentValue = store.get(remainder) + "Lakh";
				}
				prev = remainder;
				break;
			case 6:
				if (remainder != 0) {
					if (prev != 0 && remainder == 1) {
						currentValue = store.get(remainder * 10 + prev);
						remove = store.get(prev)+ "Lakh";
					} else if (prev != 0 && remainder > 1) {
						currentValue = store.get(remainder * 10);
					} else{
						currentValue = store.get(remainder) + "Million";
					}
				}
				prev = remainder;
				break;
		case 7:
			if (remainder != 0) {
				currentValue = store.get(remainder) + "Crore";
				//remove = store.get(prev) + "Lakh";
			}
			prev = remainder;
			break;
		case 8:
			if (remainder != 0) {
				if (prev != 0 && remainder == 1) {
					currentValue = store.get(remainder * 10 + prev);
					remove = store.get(prev);
				} else if (prev != 0 && remainder > 1) {
					currentValue = store.get(remainder * 10);
				} else{
					currentValue = store.get(remainder * 10) + "Crore";
				}
			}
			prev = remainder;
			break;	
		case 9:
			if (remainder != 0) {
				currentValue = store.get(remainder) + "Billion";
			}
			prev = remainder;
			break;
		}
			if (currentValue != null) {
				if (remove != null) {
					textValue.replace(0, remove.length(), "");
				}
				textValue.insert(0, currentValue);
			}
		}
		System.out.println(textValue.toString());
	}

	public static void addWords() {
		store.put(1, "One");
		store.put(2, "Two");
		store.put(3, "Three");
		store.put(4, "Four");
		store.put(5, "Five");
		store.put(6, "Six");
		store.put(7, "Seven");
		store.put(8, "Eight");
		store.put(9, "Nine");
		store.put(10, "Ten");
		store.put(11, "Eleven");
		store.put(12, "Twelve");
		store.put(13, "Thirteen");
		store.put(14, "Fourteen");
		store.put(15, "Fifteen");
		store.put(16, "Sixteen");
		store.put(17, "Seventeen");
		store.put(18, "Eighteen");
		store.put(19, "Nineteen");
		store.put(20, "Twenty");
		store.put(30, "Thirty");
		store.put(40, "Forty");
		store.put(50, "Fifty");
		store.put(60, "Sixty");
		store.put(70, "Seventy");
		store.put(80, "Eighty");
		store.put(90, "Ninety");
	}
}
