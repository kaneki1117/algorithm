package others.structure;

import java.util.Stack;

public class TwoStackQueue {

    private static Stack<Integer> stackPush;
    private static Stack<Integer> stackPop;
    public TwoStackQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(Integer i){
        stackPush.push(i);
    }

    public Integer pop(){
       if(stackPush.empty() && stackPop.empty()){
           throw new RuntimeException("empty stack");
       }else if(stackPop.empty()){
           while(!stackPush.empty()){
               stackPop.push(stackPush.pop());
           }
       }
       return stackPop.pop();
    }

    public Integer peek(){
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("empty stack");
        }else if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    /**
     * 另一种更简单版本 只改变了 push 思路就是每次push 重构整个栈达到队列的效果。
     * class MyQueue {
     * Stack<Integer> queue = new Stack<Integer>();
     * // Push element x to the back of queue.
     * public void push(int x) {
     *     Stack<Integer> temp = new Stack<Integer>();
     *     while(!queue.empty()){
     *         temp.push(queue.pop());
     *     }
     *     queue.push(x);
     *     while(!temp.empty()){
     *         queue.push(temp.pop());
     *     }
     * }
     *
     * // Removes the element from in front of queue.
     * public void pop() {
     *     queue.pop();
     * }
     *
     * // Get the front element.
     * public int peek() {
     *     return queue.peek();
     * }
     */
}
