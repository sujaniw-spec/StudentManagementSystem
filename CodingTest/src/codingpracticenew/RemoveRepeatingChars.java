package codingpracticenew;

import java.util.ArrayList;

public class RemoveRepeatingChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "aabbbcabcbb";
		char [] arr = str.toCharArray();
		ArrayList <Character> list = new ArrayList<>();
		
		
		/*for(char c: arr) {
			if(!list.contains(c)) {
				list.add(c);
			}
		}
			
		list.forEach(c -> System.out.print(c +" "));*/
		
		System.out.println("arr.length"+arr.length );
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length-1; j++) {
				System.out.println("arr[i]  "+arr[i] +" "+arr[j] );
				if(arr[i] != arr[j] ) {
					list.add(arr[j]);
				}
			}
		}
	
		
		list.forEach(c -> System.out.print(c));
//		
	}

}
