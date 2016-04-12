package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainSpiralOrder {
	public static void main(String[] args) {

		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				printSpiralOrder(line);
			}
	        in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

	private static void printSpiralOrder(String line) {
		String[] inputStr = line.split(";");
		int row = Integer.valueOf(inputStr[0]);
		int col = Integer.valueOf(inputStr[1]);
		
		if (row <=0 && col<=0){
			System.out.println();
			return;
		}
		
		String[] elements = inputStr[2].split(" ");
		int count = 0;
		String[][] arr = new String[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = elements[count++];
			}
		}
		
		int rowBegin = 0, rowEnd = (row-1), i;
		int colBegin = 0, colEnd = (col-1);

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			for (i = colBegin; i <= colEnd; i++) {
				System.out.print(arr[rowBegin][i] + " ");
			}
			for (i = (rowBegin + 1); i <= (rowEnd -1); i++) {
				System.out.print(arr[i][colEnd]+" ");
			}
			if (rowBegin != rowEnd){
				for (i = colEnd; i >=colBegin; i--) {
					System.out.print(arr[rowEnd][i]+" ");
				}
			}
			if (colBegin != colEnd){
				
				for (i = (rowEnd -1); i >= (rowBegin +1); i--) {
					System.out.print(arr[i][colBegin]+" ");
				}
			}
			colBegin++;colEnd--;
			rowBegin++;rowEnd--;
		}
		System.out.println();
	}
}
