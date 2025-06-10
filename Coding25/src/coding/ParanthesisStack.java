package coding;

import java.util.Stack;

public class ParanthesisStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(()";
		System.out.println((isCorrect(s)));
		
	}
	
	static boolean isCorrect(String s) {
		Stack <Character> stack = new Stack<>();
		
		//String s = "(())";
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));					
			}
			
			if(s.charAt(i) == ')') {
				
				if(stack.size() > 0) {
					stack.pop();
				}	
				else {
					return false;
				}
			}
		}
		return (stack.size() == 0);
	}

}
