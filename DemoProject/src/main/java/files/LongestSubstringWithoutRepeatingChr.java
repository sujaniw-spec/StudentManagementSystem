package files;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcabcbb";
	    
		HashSet <Character> hashSet = new HashSet<>();
		int maxLenght=0;
		int left = 0;
		
		for(int right=0; right<s.length(); right++) {
			
			while(hashSet.contains(s.charAt(right))) {
				hashSet.remove(s.charAt(left));
				left++;
			}
			
			hashSet.add(s.charAt(right));
			maxLenght = Math.max(maxLenght, right - left+1);
		}
	   
	   System.out.println(maxLenght);
	    
	   int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
	   int low = ages[0];
	   
	   for(int age: ages) {
		   if(low > age) {
			   low = age;
		   }
	   }
	   System.out.println("low"+low);
	}

}
