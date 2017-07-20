package com.arrays;

import java.util.Arrays;

public class TestArray1 {
public static void main(String args[]) {

	//1.not throw error only datatype is checked. not size
	int[] a = new int[10];
	int[] b = new int[100];
	a=b;
	
	//2.compare two arrays
	int[] c = {1,2,3,4,5};
	int[] d = {7,8,9,10};
	int[] e = {1,2,3,4,5};
	System.out.println(Arrays.equals(c, d));
	System.out.println(Arrays.equals(c, e));
	
	//3.Largest,Smallest value in array
	int[] f = {1,2,3,4,5};
	
	int largeValue = f[0];
	int smallValue = f[0];
	
	for(int i:f) {
		if(i>largeValue) largeValue = i;
		if(i<smallValue) smallValue = i;
	}
	System.out.println("largeValue:"+largeValue+"-smallValue:"+smallValue);
	
	
	
	
	
}
}
