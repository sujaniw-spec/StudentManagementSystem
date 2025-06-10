package coding;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack <String> stack = new Stack<>();
		stack.push("s");
		stack.push("u");
		stack.push("j");
		stack.push("a");
		stack.push("i");
		
		stack.stream().forEach(s -> System.out.println(s));
		System.out.println(stack.pop());
	}

}
