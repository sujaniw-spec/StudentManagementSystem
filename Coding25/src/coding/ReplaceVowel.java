package coding;

import java.util.Arrays;
import java.util.HashSet;

public class ReplaceVowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            String str= "sujani";
            String repalce = str.replaceAll("[aeouiAEOUI]", "x");
            System.out.println(repalce);
            char [] vowels = "aeouiAEOUI".toCharArray();
            HashSet <Character> set = new HashSet<>(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));
            
            
            char [] chrArray = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            
            for(char c: chrArray) {
            	if(set.contains(c)) {
            		c = 'x';
            		sb.append(c);
            	}
            	else {
            		sb.append(c);
            	}
            }
            System.out.println(sb.toString());
            
            //or
            
            for(char c: chrArray) {
            	if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u') {
            		c = 'x';
            		sb.append(c);
            	}
            	else {
            		sb.append(c);
            	}
            }
            
            
            
            
	}

}
