package offer.C41_60;

import java.util.LinkedList;

//为了提升删除效率用linkedlist 之后模拟过程即可。

public class Test46_ {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5,2));
    }

    public static int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int k = 0;
        while (list.size() !=1){
             k = (k + m-1) % list.size();
             list.remove(k);
        }
        return list.get(0);
    }
}
