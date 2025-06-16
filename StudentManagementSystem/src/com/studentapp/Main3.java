package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("********************* Student Management System *********************");
		System.out.println("********************* Welcome *********************");
		
		studentList = new ArrayList<Student>();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Student Name: ");
		String name = scanner.next();
		System.out.println("You entered the name "+ name);
		
		//To read integer values from the console
		//the readInt()
		
		System.out.println("Enter Student Age: ");
		int age  = scanner.nextInt();
		System.out.println("The Student age is "+ age);
		
		Student s1;
		s1 = new Student("Sujani vv",32, "S-18786");
		
		if(s1 !=null) {
			s1.enrollCourse("Java");		
			s1.enrollCourse("DSA");		
			s1.enrollCourse("devops");		
			
			s1.printStudentInfo();
		}		
	
		System.out.println(s1);
		
	
		Student s2 = new Student("Uday bb",24, "S-11");
		s2.enrollCourse("Java");
		System.out.println(s2);
		s2.printStudentInfo();
		
		Student s3 = new Student("Ritu",27, "S-13");
		s3.enrollCourse("devops");
		System.out.println(s3);
		s3.printStudentInfo();
		
		Student s4 = new Student("Aitu",28, "S-1212");
		s3.enrollCourse("devops");
		//System.out.println(s3);
		s4.printStudentInfo();
		
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		
		Student result = searchStudentById("S-13");
		System.out.println("Result "+result);
		
		sortByName();
		
	}
	
	private static void sortByName() {
		//A comparator is an interface used to define custom sorting  logic. You implement the Compare() method, which compares two objects and returns an integer value based on their order.
		
		//Comparator<Student> studentNameComparoator = new Comparator<Student>() {

		/*	@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getName().compareTo(o2.getName());//lexographically
			}							
		};*/
		Comparator<Student> studentNameComparoator = (o2,o1) -> o1.getName().compareTo(o2.getName()); //descending
		
		Collections.sort(studentList,studentNameComparoator);
		System.out.println("Result "+studentList);
		
	}

	public static Student searchStudentById(String studentId) {
		Student result = null;
		
		try {
		result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
		.orElseThrow(() -> new RuntimeException("No Data found!!!"));
		}catch(RuntimeException e) {
			System.err.println(" No student id "+studentId+" found ");
		}
		
		return result;
	}
	
	

}
