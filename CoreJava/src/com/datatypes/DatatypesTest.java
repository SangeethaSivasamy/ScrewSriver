package com.datatypes;

/* primitive to wrapper, wrapper to primitive*/
public class DatatypesTest {
	public static void main(String args[]) {
		
		int i = 12;
		Integer a = new Integer(12);
		System.out.println(a);
		
		Integer b = Integer.valueOf(i);
		System.out.println(b);
		
		Integer c = new Integer(7);
		int j = c.intValue();
		System.out.println(j);
	}
}