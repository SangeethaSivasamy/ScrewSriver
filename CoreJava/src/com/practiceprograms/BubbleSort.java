package com.practiceprograms;

public class BubbleSort {
	public static void main(String args[]) {
		int[] a = {1,9,8,7,6,3,2,5,4};
		int n=a.length;

		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}


		for(int x=0;x<n;x++) {
			System.out.println(a[x]);
		}
	}
}
