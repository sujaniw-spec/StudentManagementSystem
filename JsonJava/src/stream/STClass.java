package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class STClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList <String> list = new ArrayList<String>();
		
		list.add("agg");
		list.add("bgg");
		list.add("abgrrr");
		list.add("cggmm");
		list.add("agcmmm");
		
ArrayList <String> list2 = new ArrayList<String>();
		
		list2.add("agg");
		list2.add("bgg");
		list2.add("cddbgrrr");
		list2.add("mnggmm");
		list2.add("yugcmmm");
		
		//list.stream().filter(f ->f.startsWith("a")).forEach(f ->System.out.println(f));
		long countout = list.stream().filter(a -> a.endsWith("g")).count();
		//System.out.println(countout);
		
		//print all the names greater than 4
		//list.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		list.stream().filter(s -> s.length() > 4).limit(1).forEach(s-> System.out.println(s));
		
		//print names greater than 4 and makeupper case		
	//	list.stream().filter(a -> a.length() >4).map(a -> a.toUpperCase()) 
	//	.forEach(s -> System.out.println(s));
		
		//sort
		list.stream().filter(a -> a.length() > 4).sorted().map(s -> s.toUpperCase())
		.forEach(s -> System.out.println(s));
		
		Stream <String> newStream = Stream.concat(list.stream(), list2.stream());
		newStream.sorted().forEach(w -> System.out.println(w));
		
		Stream <String> newStream1 = Stream.concat(list.stream(), list2.stream());
		boolean b = newStream1.anyMatch(s -> s.equalsIgnoreCase("Abgrrr"));
		System.out.println(b);
		
		List<Integer> intList = Arrays.asList(1,3,3,4,1,2);
//intList.stream().distinct().sorted().collect(Collectors.toList()).forEach(e -> System.out.println(e));
//		
		intList.stream().distinct().sorted().forEach(e ->System.out.print(e));
		
		String [] sArray = {"c","b","d","c","e","b","e","f"};
		Arrays.stream(sArray).distinct().sorted().forEach(s-> System.out.print(s));
		
	}

}
