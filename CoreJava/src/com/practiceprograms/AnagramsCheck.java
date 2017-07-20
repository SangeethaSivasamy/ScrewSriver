package com.practiceprograms;

import java.util.Arrays;

public class AnagramsCheck {
public static void main(String args[]) {
	System.out.println("Is sangee sankar Anagram? "+isAnagram("sangee","sankar"));
	System.out.println("Is sangee eegnsa Anagram? "+isAnagram("sangee","eegnsa"));
}

public static boolean isAnagram(String str1,String str2) {
	char[] charArray1 = str1.toCharArray();
	char[] charArray2 = str2.toCharArray();
	
	Arrays.sort(charArray1);
	Arrays.sort(charArray2);
	System.out.println(charArray1);
	System.out.println(charArray2);
	if(Arrays.equals(charArray1, charArray2)) return true;
	
	return false;
}
}
