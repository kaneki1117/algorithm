package book.stack_queue;
/**
 * 
 * @author heyu1
 *
 */
import java.util.Stack;

//注意pop min时进行非空校验
public class MyStack {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minstack = new Stack<>();

	public void push(Integer i) {
		if(minstack.isEmpty()) {
			minstack.push(i);
			//注意此处比较的时候
		}else if(minstack.peek().compareTo(i) >= 0){
			minstack.push(i);
		}
		
		stack.push(i);
	}

	public Integer pop() {
		if(stack.empty()) throw new RuntimeException("empty stack");
		if(stack.peek() == minstack.peek()) {
			minstack.pop();
		}
		return stack.pop();
	}

	public Integer min() {
		if(minstack.empty()) throw new RuntimeException("empty stack");
		return minstack.peek();
	}
	
	public static void main(String[] args) {
		MyStack stack1 = new MyStack();
		stack1.push(3);
		System.out.println(stack1.min());
		stack1.push(4);
		System.out.println(stack1.min());
		stack1.push(1);
		System.out.println(stack1.min());
		System.out.println(stack1.pop());
		System.out.println(stack1.min());
	}
}
