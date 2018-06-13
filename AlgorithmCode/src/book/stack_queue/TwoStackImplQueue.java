package book.stack_queue;

import java.util.Stack;
/**
 * 
 * @author heyu1
 *peek poll的校验 与book答案不同但可ac
 */

public class TwoStackImplQueue {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	
	public void add(Integer i) {
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		stack1.push(i);
	}
	
	public Integer poll() {
		if (stack1.empty() && stack2.empty()) {
			throw new RuntimeException("Queue is empty!");
		}
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	
	public Integer peek() {
		if (stack1.empty() && stack2.empty()) {
			throw new RuntimeException("Queue is empty!");
		}
		
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int res = stack2.peek();
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return res;
	}
	
	/* 另一种写法 push时校验 写法更简洁
	 Stack<Integer> stack1, stack2;
	    public MyQueue() {
	        stack1 = new Stack<>();
	        stack2 = new Stack<>();
	    }
	    
	    public void push(int x) {
	        while(!stack1.isEmpty())
	            stack2.push(stack1.pop());
	        stack2.push(x);       
	        while(!stack2.isEmpty())
	            stack1.push(stack2.pop());
	    }
	    
	    public int pop() {
	        return stack1.pop();
	    }
	    
	    public int peek() {
	        return stack1.peek();
	    }
	    
	    public boolean empty() {
	        return stack1.isEmpty();
	    }
	}
*/
	public static void main(String[] args) {
		TwoStackImplQueue test = new TwoStackImplQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
	}
}
