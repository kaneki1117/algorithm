package real.netease.autumn2017;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test3_50ac {
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        countStep(start,end,0);
        if(result == Integer.MAX_VALUE){
            result = -1;
        }
        System.out.println(result);

    }
    public static void countStep(int start,int end,int count){
        if(start == end){
            result = Math.min(result,count);
            return;
        }
        if(start > end) return;

        Set<Integer> set = cal(start);
        if(set == null) return;
        for(Integer i : set){
            countStep(start+i,end,count+1);
        }
    }


    public static Set<Integer> cal(int num){
        Set<Integer> set = new HashSet<>();
        double temp = Math.sqrt(num);
        for (int i = 2; i <= temp; i++) {
            if(num % i == 0 && i != num){
                set.add(i);
                set.add(num/i);
            }
        }

        return set;
    }
}
