package com.codeeval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AlphabetBlocks {

	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				findWord(line.split("\\|"));
			}
			in.close();
		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

	private static void findWord(String[] split) {
		List<String> wordOrg = new ArrayList<String>(Arrays.asList(split[1].trim().split("")));
		Set<String> word  = new HashSet<String>(wordOrg);
		String[] blocks = split[2].trim().split("\\s+");
		List<String> lettersFound = new ArrayList<String>();
		for (int i = 0; i < blocks.length; i++) {
			StringBuilder builder = new StringBuilder();
			Iterator<String> iterator = word.iterator();
				while(iterator.hasNext()){
					String temp = new String(iterator.next());
					if (blocks[i].indexOf(temp) != -1) {
						builder.append(temp);
					}
				}
				if (builder.length() == 1){
					wordOrg.remove(builder.toString());
				} else{
					lettersFound.add(builder.toString());
				}
				
				}

		if(lettersFound.size() > 0){
			Collections.sort(lettersFound);
			List<String> index = new ArrayList<String>();
			for(int i=0; i<wordOrg.size();i++){
				for(int j=0; j<lettersFound.size();j++){
					String temp =lettersFound.get(j);
					if(temp.contains(wordOrg.get(i))){
						index.add(wordOrg.get(i));
					}
				}
			}
			wordOrg.removeAll(index);
		}
		String result = wordOrg.size()==0 ? "True" : "False";
		System.out.println(result);
	}
}
