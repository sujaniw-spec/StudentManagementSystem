package coding;

import java.util.Stack;

public class StackExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<String> stack = new Stack<String>(); // created in heap memory
		stack.push("Apple");//4
		stack.push("Banana");//3
		stack.push("Orange"); //2
		stack.push("Mango"); //top1
		
		int position = stack.search("Mango");//position of the topelement, 1,2,3,4. if the element is not return -1
		System.out.println("position "+position);
		System.out.println(stack);
		String topElement =stack.peek();
		System.out.println(topElement);
		String elementOutFromStack = stack.pop();
		System.out.println(elementOutFromStack);
		topElement =stack.peek(); // It does not remove the top lelemnt from the stak but returns the value
		System.out.println(topElement);
		stack.pop(); // remove the element from the stack and return it back to you
		System.out.println(stack.isEmpty());
	}

}
