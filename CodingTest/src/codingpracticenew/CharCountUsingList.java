package codingpracticenew;

import java.util.ArrayList;

public class CharCountUsingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Sujani Wijesundera".toLowerCase().replaceAll("\\s+", "");
		System.out.println(str);
		
		char [] charArray = str.toCharArray();
		
		ArrayList <Character> list = new ArrayList<>();
		
		int k=0;
		
		for(int i=0; i<charArray.length; i++) {
			k=0;
			if(!list.contains(charArray[i])) {
				list.add(charArray[i]);
				k++;
				
				for(int j=i+1; j<charArray.length; j++) {
					if(charArray[i] == charArray[j]) {
						k++;
					}
				}
				
				System.out.println("char occur "+charArray[i] + " = "+k);
			}
			
		}
	}

}
