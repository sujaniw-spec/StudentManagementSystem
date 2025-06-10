package codingpractice;

import java.util.Arrays;

public class AnagramChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Listen".replaceAll("\\s+", "").toLowerCase();
        String s2 = "Silent".replaceAll("\\s+", "").toLowerCase();
        
        if(s1.length() != s2.length())
        	return ;
        
        char [] arr1 = s1.toCharArray();
        char [] arr2 = s2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        System.out.println(Arrays.equals(arr1, arr2));
	}

}
