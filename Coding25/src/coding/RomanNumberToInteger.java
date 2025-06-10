package coding;

import java.util.HashMap;

public class RomanNumberToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "IX";
       HashMap<Character, Integer> romanMap = new HashMap<>();
       int result =0;
       int previousValue = 0;
       romanMap.put('I', 1);
       romanMap.put('V', 5);
       romanMap.put('X', 10);
       romanMap.put('L', 50);
       romanMap.put('C', 100);
       
       for (int i = input.length() - 1; i >= 0; i--) {
    	   char currentChar = input.charAt(i);
    	   int currentValue = romanMap.get(currentChar);
    	   if(currentValue >= previousValue) {
    		   result = result +currentValue;
    		   System.out.println(result);
    		   }
    	   else {
    		   result = result -currentValue;
    		   System.out.println("else "+result);
    		   }
    	   
    	   previousValue = currentValue;
      }
       
       System.out.println(result);
       
	}

}
