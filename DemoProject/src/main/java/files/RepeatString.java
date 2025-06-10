package files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class RepeatString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word= "Sujani";
		String reverse="";
		
		for(int i=word.length()-1; i>=0; i--) {
			reverse+=word.charAt(i);
		}
		System.out.println(reverse);
		
		String mixWord="sujani567";
		String strDigit="";
		char letter=' ';
		
		for(int i=0; i<mixWord.length(); i++) {
			if(Character.isDigit(mixWord.charAt(i))) {
				strDigit+=mixWord.charAt(i);
			}
		}
		System.out.println(strDigit);
		System.out.println(mixWord.replaceAll("[^0-9]", ""));
		
//		for(int i=0; i<mixWord.length(); i++) {
//			if(Character.isDigit(mixWord.charAt(i))) {
//				letter =mixWord.charAt(i);
//				strDigit+=letter;
//			}
//		}
//		System.out.println(strDigit);
		HashSet<String> hs = new HashSet<String>();
		hs.add("bbb");
		hs.add("ccc");
		hs.add("ddd");
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		HashMap <Integer, String>map = new HashMap<>();
		map.put(1, "www");
		map.put(2, "bb");
		map.put(3, "nn");
		map.put(4, "cc");
		
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() +"-> "+entry.getValue());
		}
		
		int a[] = {4,5,5,5,4,6,6,9,4};
		
		ArrayList list = new ArrayList();
		int k =0;
		for(int i=0; i<a.length; i++) {
			k=0;
			if(!list.contains(a[i])) {
				list.add(a[i]);
				k++;
			
			for(int j=i+1; j<a.length; j++ ) {
				if(a[i] == a[j]) {
					k++;
				}
			}
			System.out.println(a[i] +"="+k);
			}
		}
		
		
		
	}
	
	

}
