package offer.C1_20;

import java.util.Stack;
//已ac 注意初始为空的情况
public class Test20_ {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        //注意这里
        if(minStack.empty() || node <= minStack.peek()){
            minStack.push(node);
        }
    }

    public void pop() {
        if(minStack.peek()== stack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
