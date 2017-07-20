package com.practiceprograms;

public class FactorialFinder {
public static void main(String args[]) {
	int n = 7;
	
	FactorialFinder factorialFinder = new FactorialFinder();
	System.out.println(factorialFinder.computeFactorialUsingRecursion(n));
	System.out.println(factorialFinder.computeFactorialUsingWhileLoop(n));
	System.out.println(factorialFinder.computeFactorialUsingForLoop(n));
}

public int computeFactorialUsingRecursion(int n) {
	int factorialValue=1;
	if(n>1) {
	factorialValue = n*computeFactorialUsingRecursion(n-1);
	} else {
		factorialValue = 1;
	}
	return factorialValue;
}

public int computeFactorialUsingWhileLoop(int n) {
	int factorialValue=1;
	while(n>=1) {
		factorialValue =factorialValue *n;
		n=n-1;
	}
	return factorialValue;
}


public int computeFactorialUsingForLoop(int n) {
	int factorialValue=1;
	for(int i=1;i<=n;i++) {
		factorialValue = factorialValue*i;
	}
	return factorialValue;
}
	
}
