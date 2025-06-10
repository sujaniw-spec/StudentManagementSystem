package coding;

import java.util.Arrays;
import java.util.HashSet;

public class Removeduplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
		HashSet<Integer> hash = new HashSet<>();
		
		Arrays.stream(arr).distinct().forEach(n -> System.out.print(n + " "));
		System.out.println();
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			
			if(!hash.contains(arr[i])) {
				hash.add(arr[i]);
				arr[count++] = arr[i];
			}
		}
		
		for(int i=0; i<count; i++) {
			System.out.print(arr[i] +" ");
		}
		
		
	}

}
