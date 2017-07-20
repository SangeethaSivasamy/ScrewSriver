package com.arrays;
/*You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in list. 
 * One of the integers is missing in the list. Write an efficient code to find the missing integer.*/
public class FindMissingValue {

	public static void main(String args[]) {
	int [] arr = {1,2,3,4,5,6,7,9,10};
	
	int missingNumber = findMissingNumber(arr,10);
	System.out.println(missingNumber);
	
	
}
	
	public static int findMissingNumber(int[] arr, int count) {
		int actualSum = 0;
		int sum = 0;
		int missingNumber;
		
		 sum = (count*(count+1))/2;
		System.out.println("Sum-->"+sum);
		
		for(int n:arr)
			actualSum +=n;
		
		System.out.println("Actual Sum-->"+actualSum);
		
		missingNumber = sum-actualSum;
		return missingNumber;
		
		
	}
}
