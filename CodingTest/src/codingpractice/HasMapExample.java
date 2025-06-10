package codingpractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HasMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap <Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "Hello");
		hm.put(0, "Hello1");
		hm.put(1, "GoodBye");
		hm.put(2, "Morning");
		hm.put(3, "Evening");
		
		System.out.println(hm.get(1));
		System.out.println(hm.remove(2));
		
		for(Map.Entry<Integer, String> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + " "+ entry.getValue());
		}
		Set<Entry<Integer, String>> set = hm.entrySet();
		Iterator<Entry<Integer, String>> i = set.iterator();
		
		while(i.hasNext()) {
			//System.out.println(i.next());
			Map.Entry<Integer, String> m = i.next();
			System.out.println(m.getKey() + " "+ m.getValue());
		}
		
		
	}

}
