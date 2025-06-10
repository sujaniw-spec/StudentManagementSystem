package codingpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		//count the number of names starting with letter 'A' in the list
		//JavaStreamexample.regular();
		JavaStreamexample.StreamMap();
		streamCollect();
		
	}
	
	static void regular() {
		ArrayList <String> names = new ArrayList<String>();
		names.add("abc");
		names.add("dbc");
		names.add("abcd");
		names.add("abce");
		names.add("rabcnnggg");
		names.add("nbcnnn");
		
		for(String name: names) {
			if(name.startsWith("a")) {
				System.out.println(name);
			}	
		}
		
		long count = names.stream().filter(n -> n.startsWith("a")).count();
		System.out.println(count);
		
		Stream.of("abc","dbc","abcd","abcf","rabc","nbc").filter(c-> c.startsWith("n"));
		
		long count1=Stream.of("abc","dbc","abcd","abcf","rabc","nbc").filter(c->{
			 c.startsWith("a");
			 return true;
		}).count();
		System.out.println(count1);
		
		names.stream().filter(a-> a.startsWith("a")).forEach(a->System.out.println(a));
		names.stream().filter(f ->f.length()>4).forEach(f ->System.out.println(f));
		names.stream().filter(f ->f.length()>4).limit(1).forEach(f ->System.out.println(f));
		
	}
	
	static void StreamMap() {
		//print names end with a with uppercase
		Stream.of("abc","dbc","abcda","abcf","rabc","nbcvva").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		List <String> names = Arrays.asList("bcc","dbc","bacda","abcf","rabc","nbcvva");
		names.stream().filter(s -> s.startsWith("b")).sorted().map(s -> s.toUpperCase()).forEach(s-> System.out.println(s));
		List <String> names1 = Arrays.asList("ncc","mbcbb","bacda","abcf","rkabc","nbcvva","vvv");
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
	//	newStream.sorted().forEach(n->System.out.println(n));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("vvv"));
		System.out.println(flag);
	}
	
	static void streamCollect() {
		List<String> list = Stream.of("abc","dbc","abcda","abcf","rabc","nbcvva").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println("Map tp list "+list.get(0));
		
		List <Integer> values = Arrays.asList(3,3,4,5,5,1,9,7,5,9);
		//print unique number from this array
		//sort array
		values.stream().distinct().forEach(n -> System.out.println(n));
		values.stream().distinct().sorted().forEach(n -> System.out.println(n));
		List <Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}

}
