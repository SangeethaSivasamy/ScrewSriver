package com.jsonlearn.json.jsonsimple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFromFile {
public static void main(String args[]) throws IOException, ParseException {
	JSONParser jsonParser = new JSONParser();
	JSONObject jsonObject = new JSONObject();
	
	String filename ="myjson.json";
	File file = new File(System.getProperty("user.home")+File.separator+"Documents"+File.separator+"Projects"+File.separator+"JsonProject"+File.separator+filename);
	try {
		FileReader fileReader = new FileReader(file);
		Object object = jsonParser.parse(fileReader);
		jsonObject = (JSONObject)object;
		System.out.println();
		String name = (String) jsonObject.get("name");
		System.out.println("name:"+name);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
