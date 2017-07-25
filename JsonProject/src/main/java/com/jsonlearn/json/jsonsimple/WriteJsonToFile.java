package com.jsonlearn.json.jsonsimple;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJsonToFile {
public static void main(String args[]) {
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("name", "Sangeetha");
	jsonObject.put("rollNo", 1234);
	
	
	JSONObject jsonObjectloc = new JSONObject();
	jsonObjectloc.put("buildingno", "101");
	jsonObjectloc.put("street", "DogSt");
	jsonObjectloc.put("city", "DogCity");
	jsonObjectloc.put("state", "DogState");
	jsonObject.put("location", jsonObjectloc);
	
	JSONArray jsonArray = new JSONArray();
	jsonArray.add("English");
	jsonArray.add("Maths");
	jsonArray.add("Computer Science");
	jsonArray.add("History");
	jsonArray.add("Geography");
	jsonObject.put("subjects", jsonArray);

	System.out.println(jsonObject);
	
	String filename ="myjson.json";
	try {
		FileWriter fileWriter = new FileWriter(System.getProperty("user.home")+File.separator+"Documents"+File.separator+"Projects"+File.separator+"JsonProject"+File.separator+filename);
		fileWriter.write(jsonObject.toJSONString());
		fileWriter.flush();
		fileWriter.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
