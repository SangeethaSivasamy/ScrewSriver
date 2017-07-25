package com.jsonlearn.json.jackson;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
private String name;
private String rollNo;
private int age;
private ArrayList<String> subjects;
private HashMap<String, String> location;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRollNo() {
	return rollNo;
}
public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public ArrayList<String> getSubjects() {
	return subjects;
}
public void setSubjects(ArrayList<String> subjects) {
	this.subjects = subjects;
}
public HashMap<String, String> getLocation() {
	return location;
}
public void setLocation(HashMap<String, String> location) {
	this.location = location;
}
}
