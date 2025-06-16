package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {
	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("********************* Student Management System *********************");
		System.out.println("********************* Welcome *********************");
		
		studentList = new ArrayList<Student>();
		while(true) {
			System.out.println("######### Select an Option ###########");
			System.out.println("1. Register a Student");
			System.out.println("2. Find a student with studentid");
			System.out.println("3. List All Student Information");
			System.out.println("4. List All Student Information in Sorted Order");
			System.out.println("5. Exit");
		
			scanner = new Scanner(System.in);
			
			int option = scanner.nextInt();
			
			switch(option){
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentById(scanner);
				break;
			case 3: printAllStudentData();
				break;
			case 4: sortByName();
				break;
			case 5: 
				exit();
				break;
			default: System.out.println("Invalid option selected. --- Enter between 1 to 5");	
				
			}
		}
	}
	
	private static void exit() {
		System.exit(0);
		
	}

	private static void printAllStudentData() {		
		if(!studentList.isEmpty()) {
			System.out.println(" -- Print All Studnet Data -- ");
			studentList.stream().forEach(s -> s.printStudentInfo());
		}
		else {
			System.out.println("Student list is Empty!! No Student records are found ");
		}
	}

	private static void findStudentById(Scanner scanner2) {
		System.out.println("Enter the Student Id ");
		Student studentFound = null;
		String studentId = scanner2.next();	
		
		try {
		studentFound = studentList.stream().filter(student -> student.getStudentId().equals(studentId)).findFirst()
				.orElseThrow(() -> new RuntimeException("No Data Found!!"));
		
		}catch(RuntimeException e) {
			System.out.println("Student with ID "+studentId + " Not Found!!");
		}
		studentFound.printStudentInfo();
	}

	private static void enrollStudent(Scanner scanner2) {
		try {
		System.out.println("Enter the Student Name: ");
		String studentName = scanner2.next();
		
		System.out.println("Enter the Student Age: ");
		int studentAge = scanner2.nextInt();
		
		System.out.println("Enter the Student Id: ");
		String studentId = scanner2.next();	
		
		Student newStudent = new Student(studentName,studentAge,studentId);
		studentList.add(newStudent);
		
		while(true) {
			System.out.println("Enter the course to be enrolled! .....Type Done to exit");			
			String courseName = scanner2.next();		
			if(courseName.equalsIgnoreCase("done")) break;
			newStudent.enrollCourse(courseName);				
		}
		
		newStudent.printStudentInfo();
		}catch(Exception e) {
			System.out.println("Error on creating studnet--");
			scanner2.next();
		}
		
	}

	private static void sortByName() {
		Comparator <Student> comparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentList,comparator);
		
		System.out.println(studentList);
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
