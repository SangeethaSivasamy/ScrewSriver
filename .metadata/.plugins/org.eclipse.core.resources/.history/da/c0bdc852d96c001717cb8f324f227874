package com.practiceprograms;

public class PalindromeFinder {
public static void main(String args[]) {
System.out.println("Is NOON palindrome?"+isPalindrome("NOON"));
System.out.println("Is DOG palindrome?"+isPalindrome("DOG"));
System.out.println("Is LEvel palindrome?"+isPalindrome("LEvel"));
System.out.println("Is Pen palindrome?"+isPalindrome("Pen"));
}

public static  boolean isPalindrome(String str) {
	boolean isPalindrome = true;
	String reversestr = "";
	for(int i=str.length()-1;i>=0;i--) {
		reversestr=reversestr+str.charAt(i);
	}
	if(!str.equalsIgnoreCase(reversestr)) isPalindrome=false;
	return isPalindrome;
}
}
