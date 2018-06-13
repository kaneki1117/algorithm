package book.stack_queue;

import java.util.Stack;

public class StackInOrder {

	public static void makeitOrder(Stack<Integer> stack) {
		if(stack == null) return;
		Stack<Integer> help = new Stack<>();
		help.push(stack.pop());
		while(!stack.empty()) {
			int pop = stack.pop();
			while(!help.isEmpty() && pop >  help.peek()) {
				stack.push(help.pop());
			}
			help.push(pop);
		}
		while(!help.empty()) {
			stack.push(help.pop());
		}
	}
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(1);
		stack.push(6);
		stack.push(2);
		stack.push(5);
		stack.push(4);
		makeitOrder(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
}
