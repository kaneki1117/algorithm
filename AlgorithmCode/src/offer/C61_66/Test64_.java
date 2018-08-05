package offer.C61_66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//注意存入的是下标 比较的时候 要取出的数据框在Num【】之中
public class Test64_ {
    public static void main(String[] args) {
        int[] nums = {2,3,4,2,2,3,6,7};
        ArrayList<Integer> res =maxInWindows(nums,3);
        for(Integer i : res){
            System.out.print(i+",");
        }
    }


    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || size < 1 || num.length < size) return res;
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (;index < num.length;index++){
            while (!queue.isEmpty() && num[index] >= num[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(index);
            if(queue.peekFirst() == index - size){
                queue.pollFirst();
            }
            if(index >= size -1){
                res.add(num[queue.peekFirst()]);
            }
        }

        return res;
    }
}
