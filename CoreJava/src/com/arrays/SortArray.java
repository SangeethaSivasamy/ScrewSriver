package com.arrays;

import java.util.Arrays;

public class SortArray {
public static void main(String args[]) {
	
	/*To sort an array*/
	int[] arr = {1,2,3,3,2,3,1,1};
	Arrays.sort(arr);
	for(int i:arr) {
		//System.out.println(i);
	}
	
	/*There is an array with 10,000 elements filled with only 1,2 and 3. 
	 * they are randomely present in array. 
	 * Can we short this array in O(n) time complexity?*/
	
	int [] arr1 = {1,1,1,1,2,3,2,3,3,3,3,1,2,3,3,1};
	int count1 = 0;
	int count2 = 0;
	int count3 = 0;
	
	for(int i:arr1) {
		if(i == 1) count1+=1;
		if(i == 2) count2+=1;
		if(i == 3) count3+=1;
	}
	System.out.println(count1+"-"+count2+"-"+count3);
	
	for(int j = 0; j<count1;j++) {
		arr1[j] = 1;
	}
for(int j = count1; j<count1+count2;j++) {
		arr1[j] = 2;
	}
	for(int j = count1+count2; j<count1+count2+count3;j++) {
		arr1[j] = 3;
	}
	
	for(int i:arr1) {
		System.out.println(i);
	}
	
}
}
