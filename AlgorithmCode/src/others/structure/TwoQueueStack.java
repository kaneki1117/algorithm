package others.structure;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {

    private static Queue<Integer> queue1;
    private static Queue<Integer> queue2;

    public TwoQueueStack(){
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int i){
        if(queue1.isEmpty()){
            queue1.offer(i);
            for (int j = 0; j < queue2.size(); j++) {
                queue1.offer(queue2.poll());
            }
        }else{
            queue2.offer(i);
            for (int j = 0; j < queue1.size(); j++) {
                queue2.offer(queue1.poll());
            }
        }
    }

    public int pop(){
        if(queue1.isEmpty()){
            return queue2.poll();
        }else {
            return queue1.poll();
        }
    }

    public int peek(){
        if(queue1.isEmpty()){
            return queue2.peek();
        }else {
            return queue1.peek();
        }
    }


    //可以用单个队列实现栈
    /**
     * class MyStack {
     *
     * //one Queue solution
     * private Queue<Integer> q = new LinkedList<Integer>();
     *
     * // Push element x onto stack.
     * public void push(int x) {
     *     q.add(x);
     *     for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
     *         q.add(q.poll());
     *     }
     * }
     *
     * // Removes the element on top of the stack.
     * public void pop() {
     *     q.poll();
     * }
     * // Get the top element.
     * public int top() {
     *     return q.peek();
     * }
     * // Return whether the stack is empty.
     * public boolean empty() {
     *     return q.isEmpty();
     * }
     * }
     */
}
