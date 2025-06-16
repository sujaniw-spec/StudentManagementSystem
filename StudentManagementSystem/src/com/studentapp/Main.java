package com.studentapp;

public class Main {

	public static void main(String[] args) {
		System.out.println("********************* Student Management System *********************");
		System.out.println("********************* Welcome *********************");
		
		Student s1;
		s1 = new Student("Sujani vv",32, "S-18786");
		
		if(s1 !=null) {
			s1.enrollCourse("Java");		
			s1.enrollCourse("DSA");		
			s1.enrollCourse("devops");		
			s1.enrollCourse("Java");	
			s1.enrollCourse("HR");
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
		
	}

}
