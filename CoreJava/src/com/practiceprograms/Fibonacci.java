package com.practiceprograms;

public class Fibonacci {
	public static void main(String args[]) {
		int[] a = new int[10];
		for(int i=0;i<10;i++) {
			System.out.println(i);
			if(i==0) {
				a[i]=0;
			} else if(i==1) {
				a[i]=1;
			} else {
				a[i]=a[i-1]+a[i-2];
			}
		}

		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}


}
