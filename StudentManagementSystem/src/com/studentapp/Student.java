package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	

	private String name;
	private int age;
	private String studentId;
	private List <String> courses;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	//Instance variables need validate check
	
	public Student(String name, int age, String studentid) {
		super();
		if(!validateAge(age) || !validateName(name) || !validateStudentid(studentid) || !validateStudentid(studentid)) {
			throw new IllegalArgumentException("Invalid student data");
			}
			this.name = name;
			this.age = age;
			this.studentId = studentid;
			courses = new ArrayList<String>(); //Initialize the courses
		
	}
	
	private boolean validateStudentid(String studentId) {
		//S-123
		//Start with S - and repeat any digit between 0 to 9. And ends with a digit
		String studentIdRegex = "S-[0-9]+$";
		//String studentIdRegex = "S-\\d+$";
		
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatch = studentIdPattern.matcher(studentId);
		
		if(studentIdMatch.matches()) {
			return true;
		}
		System.err.println("Invalid student id - enter the format S-123");
		return false;
	}
	
	//ArrayList is non idempotent in nature. Idempotent is not allow duplicate

	public void enrollCourse(String course) {
		if(!courses.contains(course)) {	
			if(validteCourseName(course)){
				courses.add(course);
				System.out.println("Student is enrolled to "+course+ " successfully!");	
			}
		}
		else {
			System.err.println("Course is already enrolled "+course);			
		}
	}
	
	public void printStudentInfo() {
		System.out.println(" ============== StudentDdata ============== ");
		System.out.println(" Student Name: "+name);
		System.out.println(" Student Age: "+age);
		System.out.println(" Student Studnet Id: "+studentId);
		System.out.println(" Enrolled For: "+courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}
	
	//Validation methods
	public boolean validateAge(int age) {
		
		if (age >= 19 && age<=35) {
			return true;
		}
		System.err.println("Invalid age!!! Student Age needs to be between 19 and 35");
		return false;
	}
	
	public boolean validateName(String name) {
		//kajal KAJAL Kajal KaJAL
		//^ starts with
		// \\s white space
		// any number of combination, same thing happen after middle name etc
		//$ means end with alphebert
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if(nameMatcher.matches()) {
			return true;
		}
		else {
			System.err.println("Invalid Name !! Please enter alphaberts only");
			return false;
		}
	}
	
	public boolean validteCourseName(String course) {
		if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("devops")) {
			return true;
		}		
		System.err.println("Invalid course. Please courses from the list" );
		return false;
		
	}
	
}
