package com.practiceprograms;

import java.util.ArrayList;
import java.util.HashMap;

class AnagramsPair{
	static HashMap<Integer, ArrayList<String>> anagramMap = new HashMap<>();
	public static void main(String args[]) {
		String[] str = {"sweets","tweets","keep","peek","race","Care"};

		for(String s:str) {
			s = s.toLowerCase();
			int hash = computeHash(s);
			if(anagramMap.get(hash) == null) {
				anagramMap.put(hash, new ArrayList<String>());
			}
			anagramMap.get(hash).add(s);
		}

		for(ArrayList<String> strList : anagramMap.values()) {
			System.out.println(strList);
		}
	}

	public static int computeHash(String s) {
		int hash = 0;
		for(int i=0;i<s.length();i++) {
			hash += s.charAt(i);
		}
		return hash;
	}
}