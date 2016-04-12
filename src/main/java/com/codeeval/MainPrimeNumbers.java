package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainPrimeNumbers {
	public static void main(String[] args) {

		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				findPrimeNumber(Long.getLong(line));
			}
	        in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}
	
	private static void findPrimeNumber(Long inputNumber) {
		System.out.print("2");
		Long start = 3L;
		while (start < inputNumber){
			if (isPrime(start)){
				System.out.print(","+start);
			}
			start+=2;
		}
		System.out.println();
	}

	private static boolean isPrime(Long currentNumber) {
		Integer sqrt = (int) Math.ceil(Math.sqrt(currentNumber));
			for (int i= 3; i <= sqrt; i++){
				if (currentNumber % i == 0){
					return false;
				}
			}
		return true;
	}
}
