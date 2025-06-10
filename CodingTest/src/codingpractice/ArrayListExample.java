package codingpractice;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Arraylist, LinkedList, Vector - implements List interface
		//Array have fixed size where as arraylist can grow dynamically
		//you can access and insert any value in any index
		//allow duplicates
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("sujani");
		list.add("java");
		list.add("sujani");
		list.add("java");
		list.add("sujani");
		list.add("java");
		list.add("sujani");
		list.add("sava");
		list.add(0, "student");
		System.out.println(list);
		list.remove(1);
	//	list.remove("student");
		list.get(0);
	
		System.out.println(list.contains("student"));
		System.out.println(list.indexOf("java"));
		System.out.println(list.size());
		
		 for(String fruit: list){
	         System.out.println(fruit +" "+list.indexOf(fruit));
	     } 
		 
		 long count = list.stream().filter(letter -> letter.startsWith("s")).count();
		 System.out.println(count);
		 
		// list.forEach(System.out::println);
		 list.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		 //if you want to change the result use map
		 
		 list.stream().filter(s -> s.endsWith("i")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		 
		 list.stream().filter(s -> s.startsWith("s") ).map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));
		 list.stream().filter(s -> s.startsWith("s") ).map(s -> s.toUpperCase()).sorted().collect(Collectors.toList());
	     list.stream().filter(s -> s.startsWith("s") ).limit(1).forEach(System.out::println);
	     
	     list.stream().distinct().forEach(s -> System.out.println(s));
	     String ss = list.stream().distinct().sorted().collect(Collectors.toList()).get(3);
	     System.out.println(ss);
	     
	}

}
