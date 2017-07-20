package com.practiceprograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class CheckDuplicateCharsInString {
	public static void main(String args[]) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		String str = "hippopotamus";
		str = str.toLowerCase();
		System.out.println(str);
		for(int i =0;i<str.length();i++) {
			int count = 0;
			String s = String.valueOf(str.charAt(i));
			if(!hashMap.containsKey(s)) {
				count = 1;
				hashMap.put(s,count);
			} else {
				count = hashMap.get(s);
				hashMap.put(s, count+1);
			}
		}

		Set set = hashMap.keySet();
		Object[] strarr = set.toArray();
		for(Object s:strarr) {
			if(hashMap.get(s)>1) System.out.println(s+" is duplicated "+hashMap.get(s)+" times.");
		}

	}
}
