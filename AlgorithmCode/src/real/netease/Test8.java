package real.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 *
 * 输入描述:
 * 输入包括两行
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 *
 *
 * 输出描述:
 * 输出一个正整数, 表示牛牛一共有多少种零食放法。
 *
 * 输入例子1:
 * 3 10
 * 1 2 4
 *
 * 输出例子1:
 * 8
 */
//背包问题  很重要很经典。
public class Test8 {
    static  int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sNum = sc.nextInt();
        long cap = sc.nextLong();
        long[] stacks = new long[sNum];
        long sum = 0;

        for (int i = 0; i < sNum; i++) {
            stacks[i] = sc.nextLong();
            sum+= stacks[i];
        }
        if(sum <= cap){
            System.out.println((long)Math.pow(2,sNum));
            return;
        }
        Arrays.sort(stacks);
        helper(stacks,0,cap);
        System.out.println(count);
    }


    public static void helper(long[] stacks,int index,long rcap){
        if(rcap <= 0) return;

        count++;
        for (int i = index; i < stacks.length; i++) {
            helper(stacks,i+1,rcap - stacks[i]);
        }
    }
}
