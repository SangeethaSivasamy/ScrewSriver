package com.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {

	public static void main(String args[]) {
		int[] arr= {1,2,3,4,5,6,7};
		int start=0;
		int end=arr.length-1;
		reverseArray(arr,start,end);
		for(int i:arr) {
			System.out.println(i);
		}
	}
	
	public static void reverseArray(int[] arr,int start,int end) {
		if(start >=end) 
			return;
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			reverseArray(arr, start+1, end-1);
			
	}
}