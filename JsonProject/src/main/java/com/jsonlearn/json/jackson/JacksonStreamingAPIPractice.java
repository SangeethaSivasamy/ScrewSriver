package com.jsonlearn.json.jackson;

import java.io.File;
import java.io.IOException;


import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JacksonStreamingAPIPractice {
public static void main(String args[]) {
	JsonFactory jsonFactory = new JsonFactory();
	
	String filename = "student_"+System.currentTimeMillis()+".json";
	File resultFile = new File(System.getProperty("user.home")+File.separator+"Documents"+File.separator+"Projects"+File.separator+"JsonProject"+File.separator+filename);

	try {
		JsonGenerator jsonGenerator = jsonFactory.createGenerator(resultFile, JsonEncoding.UTF8);
		jsonGenerator.useDefaultPrettyPrinter();
		
		jsonGenerator.writeStartObject();
		
		jsonGenerator.writeStringField("name", "Sangeetha");
		
		jsonGenerator.writeNumberField("rollNo", 1234);
		
		jsonGenerator.writeStringField("age", "21");
		
		jsonGenerator.writeFieldName("subjects");
		jsonGenerator.writeStartArray();
		jsonGenerator.writeString("English");
		jsonGenerator.writeString("ComputerScience");
		jsonGenerator.writeEndArray();
		
		jsonGenerator.writeFieldName("location");
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("buildingno", "101");
		jsonGenerator.writeStringField("city", "DogCity");
		jsonGenerator.writeEndObject();
		
		jsonGenerator.writeEndObject();
		
		jsonGenerator.close();
		
		
		
		
		String fname = "student_1500706112182.json";
		File file = new File(System.getProperty("user.home")+File.separator+"Documents"+File.separator+"Projects"+File.separator+"JsonProject"+File.separator+filename);

		JsonParser jsonParser = jsonFactory.createParser(file);
		while(jsonParser.nextToken()!=JsonToken.END_OBJECT) {
			String fieldname = jsonParser.getCurrentName();
			
			if("name".equals(fieldname)) {
				jsonParser.nextToken();
				System.out.println(jsonParser.getText());
			}
			if("rollNo".equals(fieldname)) {
				jsonParser.nextToken();
				System.out.println(jsonParser.getNumberValue());
			}
			if("age".equals(fieldname)) {
				jsonParser.nextToken();
				System.out.println(jsonParser.getText());
			}
			if("subjects".equals(fieldname)) {
				jsonParser.nextToken();
				while(jsonParser.nextToken()!=JsonToken.END_ARRAY) {
					System.out.println(jsonParser.getText());
				}
			}
			if("location".equals(fieldname)) {
				jsonParser.nextToken();
				while(jsonParser.nextToken()!=JsonToken.END_OBJECT) {
					String innerfiledname = jsonParser.getCurrentName();
					if(innerfiledname.equals("buildingno")) {
					jsonParser.nextToken();
					System.out.println(jsonParser.getText());
					}
					if(innerfiledname.equals("city")) {
						jsonParser.nextToken();
						System.out.println(jsonParser.getText());
					}
				}
			}
			
			
			
		}
		
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
