package com.practiceprograms;

/*
 * An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. 
 * For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371.
 */
public class ArmstrongNumberCheck {
	public static void main(String args[]) {
		System.out.println("Is 371 Amstrong Number?  "+checkAmstrongNumber(371));
		System.out.println("Is 111 Amstrong Number?  "+checkAmstrongNumber(111));
	}
	public static boolean checkAmstrongNumber(int inNumber) {
		boolean isAmstrongNumber = false;
		int copyNumber = inNumber;
		int length = String.valueOf(inNumber).length();
		double sum=0;

		while(inNumber>0) {
			int individualValue = (inNumber%10);
			sum = sum+Math.pow(individualValue,length);
			inNumber = inNumber/10;
			System.out.println(inNumber);
		}
		if(sum==copyNumber) {
			isAmstrongNumber = true;
			System.out.println("Amstrong Number");
		}
		return isAmstrongNumber;
	}
}
