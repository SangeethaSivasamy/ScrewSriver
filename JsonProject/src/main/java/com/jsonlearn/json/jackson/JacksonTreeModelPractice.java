package com.jsonlearn.json.jackson;

import java.nio.MappedByteBuffer;
import java.util.Iterator;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTreeModelPractice {
public static void main(String args[]) {
	ObjectMapper objectMapper = new ObjectMapper();

	String jsonString = "{\"name\":\"Sangeetha\",\"rollNo\":\"1234\", \"age\":21, \"subjects\":[\"English\",\"Computer Science\"], \"location\":{\"buildingno\":\"101\",\"city\":\"DogCity\"}}";
	
	try {
	JsonNode rootNode;
	rootNode = objectMapper.readTree(jsonString);//or
	rootNode = objectMapper.readValue(jsonString, JsonNode.class);
	
	/** String**/
	JsonNode nameNode = rootNode.get("name");
	String name = nameNode.asText();
	System.out.println(name);
	
	/**Number**/
	JsonNode rollNoNode = rootNode.get("rollNo");
	int rollNo = rollNoNode.asInt();
	System.out.println(rollNo);
	
	/**String**/
	JsonNode ageNode = rootNode.get("age");
	String age = ageNode.asText();
	System.out.println(age);
	
	/**Array**/
	JsonNode arrsubjectsNode = rootNode.get("subjects");
	Iterator<JsonNode> subjectsNode1 = arrsubjectsNode.elements();
	while(subjectsNode1.hasNext())
	{
		JsonNode subjectsNode = subjectsNode1.next();
		String subject = subjectsNode.asText();
		System.out.print(subject+" ");
	}
	System.out.println();
	/**Object**/
	JsonNode locationNode = rootNode.get("location");
	JsonNode buildingNoNode = locationNode.get("buildingno");
	String buildingno = buildingNoNode.asText();
	System.out.println(buildingno);
	JsonNode cityNode = locationNode.get("city");
	String city = cityNode.asText();
	System.out.println(city);
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
}
}
