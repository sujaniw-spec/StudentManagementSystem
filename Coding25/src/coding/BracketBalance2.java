package coding;

import java.util.Stack;

public class BracketBalance2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(balanceBrackets());
	}
	
	static boolean balanceBrackets() {
		
		String str = "(([{}]))";
	       char[] charArray = str.toCharArray();
	       Stack <Character> stack = new Stack<>();
	       
	       for(char c: charArray) {
	    	   
	    	   if(c == '(' || c== '[' || c=='{') {
	    		   stack.push(c);
	    	   }
	    	   else if(c == ')' || c==']' || c=='}') {
	    		   if(stack.isEmpty()) {
	    			   return false;
	    		   }
	    		   
	    		   char open = stack.pop();
	    		   if(!isBracketsMatching(open,c)) {
	    			   System.out.println("Mismatched pair: " + open + " and " + c);
	    			   return false;
	    			}
	    	   }
	       }
	       return stack.isEmpty();
	} 
	
	static boolean isBracketsMatching(char open, char close) {
		
		return (open == '(' && close == ')') ||
		(open == '{' && close == '}') ||
		(open == '[' && close == ']');
	}

}
