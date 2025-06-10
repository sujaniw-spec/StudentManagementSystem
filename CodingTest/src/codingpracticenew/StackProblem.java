package codingpracticenew;

import java.util.Stack;

public class StackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input= "()[]{}";
		
		Stack<Character> stack = new Stack<>();
		
		for(char c: input.toCharArray()) {
			if(c == '(') stack.push(')');
			else if(c == '{') stack.push('}');
			else if(c== '[')stack.push(']');
			
		}
		
		stack.forEach(c -> System.out.print(c));
	}

}
