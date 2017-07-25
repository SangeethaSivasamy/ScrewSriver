package com.jsonlearn.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONPractice {
	public static void main(String args[]) {
		//Method 1 : Create Gson object
		Gson gson = new Gson();
		
		//Method 2 : Create Gson object
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson2 = gsonBuilder.create();
		
		
		

	}
}
