package com.variables;


/*
 * 1. Local variable - scope within the block. Cannot be static
 * 2. Instance variables - Not static. Each object will have fresh own copy
 * 3. Static variables - All onjects share same copy. Accessed using classname
 */
public class VariablesDifference {
	public static int k = 2;
	int j = 10;//instance variable
	
	public static void main(String args[]) {
		int i;//local variable
		i=5;
		System.out.println("Local variable-->"+i);
		System.out.println("");
		VariablesDifference variablesDifference1 = new VariablesDifference();
		System.out.println("Instance variable accessed using obj1(fresh copy)-->"+variablesDifference1.j);
		variablesDifference1.j=15;
		System.out.println("Instance variable of object1-->"+variablesDifference1.j);
		
		VariablesDifference variablesDifference2 = new VariablesDifference();
		System.out.println("Instance variable accessed using obj2(fresh copy)-->"+variablesDifference2.j);
		variablesDifference2.j=20;
		System.out.println("Instance variable of object2-->"+variablesDifference2.j);
		
		VariablesDifference variablesDifference3 = new VariablesDifference();
		System.out.println("Instance variable accessed using obj3(fresh copy)-->"+variablesDifference3.j);
		variablesDifference3.j=25;
		System.out.println("Instance variable of object3-->"+variablesDifference3.j);
		
		
		System.out.println("Instance variable of object1-->"+variablesDifference1.j);
		System.out.println("Instance variable of object2-->"+variablesDifference2.j);
		System.out.println("Instance variable of object3-->"+variablesDifference3.j);
		System.out.println("");
		
		variablesDifference1.k = 4;
		System.out.println(variablesDifference1.k);
		System.out.println(k);
		
		variablesDifference2.k = 8;
		System.out.println(variablesDifference2.k);
		System.out.println(k);
		
		k = 16;
		System.out.println(variablesDifference3.k);
		
		
		
	}
}