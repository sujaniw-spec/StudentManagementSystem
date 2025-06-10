package coding;

import java.util.Stack;

public class ReverseStringWithRemoveExtraDots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "..geeks..for.geeks.";
		
		Stack <String> stack = new Stack<>();
		StringBuilder word = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i) != '.') {
				word.append(str.charAt(i));
				System.out.println(str.charAt(i));
			}
			
			else if(word.length() > 0) {
				System.out.println(word.toString());
				stack.push(word.toString());
				word.setLength(0);
			}
		}
		
		StringBuilder reverse = new StringBuilder();
		while(!stack.isEmpty()) {
			reverse.append(stack.pop());
			if(!stack.isEmpty()) {
				reverse.append('.');
			}
		}
		
		System.out.println(reverse.toString());
		
	}

}
