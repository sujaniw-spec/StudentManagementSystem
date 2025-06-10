package coding;

import java.util.Stack;

public class Balanceparanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "())";
		System.out.println(balanceParanthesis(input));
	}
	
	static boolean balanceParanthesis(String input) {
		
		char []  charArray = input.toCharArray();
		
		Stack <Character> stack = new Stack<>();
		
		/*for(char c: charArray) {
			
			if(c == '(') {
				stack.push(c);
			}
			if(c == ')') {
				if(stack.isEmpty()) {
					return false;
				}
				else {
					char pop = stack.pop();
					if(pop != '(') {
						return false;
					}
				}
			}
		}
		if(stack.isEmpty()) return true;
		
		return false; */
		 for(char c: charArray) {
		        if(c == '(') {
		            stack.push(c);
		        } else if(c == ')') {
		            if(stack.isEmpty()) {
		                return false;
		            }
		            stack.pop();
		        }
		    }
		    
		    return stack.isEmpty();
	}

}
