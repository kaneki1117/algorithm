package others.structure;

import java.util.LinkedList;
import java.util.Queue;

public class Test2 {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x){
        if(q1.isEmpty()){
            q1.offer(x);
            for (int i = 0; i < q2.size(); i++) {
                q1.offer(q2.poll());
            }
        }else{
            q2.offer(x);
            for (int i = 0; i < q1.size(); i++) {
                q2.offer(q1.poll());
            }
        }
    }

    public int pop(){
        return q1.isEmpty()?q2.poll():q1.poll();
    }
    public int peek(){
        return q1.isEmpty()?q2.peek():q1.peek();
    }
}
