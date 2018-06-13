package book.stack_queue;

import java.util.Stack;

//注意此题的设计思想
public class RecursiveStack {

	public static int getAndRemoveLast(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.isEmpty()) {
			return result;
		}else {
			int last = getAndRemoveLast(stack);
			stack.push(result);
			return last;
		}
	}
	
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}		
		int res = getAndRemoveLast(stack);
		reverse(stack);
		stack.push(res);
	}
	
	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}
	}
}
