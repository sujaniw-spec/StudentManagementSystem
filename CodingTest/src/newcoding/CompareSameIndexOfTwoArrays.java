package newcoding;

import java.util.ArrayList;

public class CompareSameIndexOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a = {1,4,5,7};
		int b [] = {6,4,3,7};
		
		ArrayList<Integer> list = new ArrayList <Integer>();
		
		for(int i=0; i<a.length; i++) 	
		{
			if(a[i] == b[i]) {
				list.add(a[i]);
			}
		}
		
		for(int i: list) {
			System.out.println(i);
		}
		
		Object[] arr = list.toArray();
		
		for(Object o: arr) {
			System.out.print(o+" ");
		}
	}

}
