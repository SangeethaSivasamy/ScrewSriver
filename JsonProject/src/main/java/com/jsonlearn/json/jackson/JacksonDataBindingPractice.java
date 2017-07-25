package com.jsonlearn.json.jackson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDataBindingPractice {
public static void main(String args[]) {
	
	try {
	ObjectMapper objectMapper = new ObjectMapper();
	
	Student student = new Student();
	student.setName("Sangeetha");
	student.setRollNo("1234");
	student.setAge(21);
	
	ArrayList<String> subjects = new ArrayList<String>();
	subjects.add("English");
	subjects.add("Computer Science");
	student.setSubjects(subjects);
	
	HashMap<String, String> location = new HashMap<String, String>();
	location.put("buildingno", "101");
	location.put("street", "DogSt");
	location.put("city", "DogCity");
	location.put("state", "DogState");
	student.setLocation(location);
	
	String filename = "student_"+System.currentTimeMillis()+".json";
	File resultFile = new File(System.getProperty("user.home")+File.separator+"Documents"+File.separator+"Projects"+File.separator+"JsonProject"+File.separator+filename);
	objectMapper.writeValue(resultFile, student);
	
	Student student2 = new Student();
	student2 = objectMapper.readValue(resultFile, Student.class);
	System.out.println(student2.getName());
	System.out.println(student2.getRollNo());
	System.out.println(student2.getAge());
	System.out.println(student2.getSubjects());
	System.out.println(student2.getLocation());
	
	}catch (Exception e) {
		System.out.println(e);
	}
}
}
