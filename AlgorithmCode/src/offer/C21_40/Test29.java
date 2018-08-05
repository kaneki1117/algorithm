package offer.C21_40;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
//第一遍提交未考虑到 k == 0 的情况需排除
public class Test29 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,5,6,7,8,7,6,4,3,2,0};
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr,5);
        for(Integer i : res){
            System.out.print(res.get(i)+" ");
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || input.length == 0 || k==0 || k > input.length){
            return list;
        }
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k,comp);
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }

        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
            return list;
        }
    }

