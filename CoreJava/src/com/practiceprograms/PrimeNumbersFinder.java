package com.practiceprograms;

public class PrimeNumbersFinder {
	public static void main(String args[]) {
		for(int i=2; i<=10; i++) {
			if(isPrimeNumber(i)) System.out.println(i);
		}
	}

	public static boolean isPrimeNumber(int n) {
		boolean isPrime = true;
		for(int i=2;i<n;i++) {
			if(n%i==0)
			{
				isPrime = false;
			}
		}
		return isPrime;
	}
}