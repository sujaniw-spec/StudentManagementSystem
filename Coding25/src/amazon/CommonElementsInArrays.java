package amazon;

import java.util.ArrayList;
import java.util.HashSet;

public class CommonElementsInArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {3, 4, 5, 6, 7};
		
		HashSet <Integer> set = new HashSet<>();
		
		for(int a: arr1) {
			set.add(a);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int n: arr2) {
			
			if(set.contains(n)) {
				
				if(!list.contains(n)) {
					list.add(n);
				}
			}
		}

		
		list.forEach(n -> System.out.println(n));
	}

}
