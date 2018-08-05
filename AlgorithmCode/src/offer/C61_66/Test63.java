package offer.C61_66;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.DoubleStream;

public class Test63 {

    PriorityQueue<Integer> minH = new PriorityQueue<>();
    PriorityQueue<Integer> maxH = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int sum = 0;
    public void Insert(Integer num) {
        if(sum % 2 == 0){
            maxH.offer(num);
            minH.offer(maxH.poll());
        }else {
            minH.offer(num);
            maxH.offer(minH.poll());

        }

        sum++;
    }

    public Double GetMedian() {
        if(sum%2 == 0){
            return (minH.peek() + maxH.peek())/2.0;
        }else {
            return (double)minH.peek();
        }
    }

}
