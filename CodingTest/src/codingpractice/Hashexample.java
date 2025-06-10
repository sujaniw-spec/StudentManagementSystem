package codingpractice;

import java.util.HashSet;
import java.util.Iterator;

public class Hashexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//hashSet, TreeSet, LinkedHashSet implements Set interface
		//Does not allow duplicate values
		//There is no gurantee elelemts stored in sequential order. Random order
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("USA");
		hs.add("UK");
		hs.add("India");
		hs.add("India");
		System.out.println(hs);
		hs.remove("UK");
		hs.size();
		Iterator <String> it = hs.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
