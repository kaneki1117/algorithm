package real.aiQiyi;

//牛牛配糖果

import java.util.Scanner;

/**
 * n种糖果 每种糖果都有足够多 要给每个糖果盒装m个糖果，第i种糖果不少于li也不多于ri，
 * 求方案数。
 * 输入包括n+1行
 * 第一行 包括两个正整数（1<= n<=20 ,1<=m<=100）表示糖果种数和一盒糖果要装的数量
 * 接下来n行每两行证书 l r 0<=l<=10，表示第i种的数量上下限
 *
 * 如 3 5
 *  0 3
 *  0 3
 *  0 3
 * 输出：12
 */
public class Test3 {

    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kind = sc.nextInt();
        int boxCap = sc.nextInt();
        int[] least = new int[kind];
        int[] most = new int[kind];
        int[] remain = new int[kind];
        for (int i = 0; i < kind; i++) {
            least[i] = sc.nextInt();
            boxCap -= least[i];
            most[i] = sc.nextInt();
            remain[i] = most[i] - least[i];
        }

        helper(remain,0,boxCap);
        System.out.println(count);
    }

    public static void helper(int[] remain,int index,int sum){
        if(sum <=0 || index > remain.length){
            return;
        }
        if(index == remain.length && sum >= 0){
            count++;
            return;
        }

        for (int i = 0; i <= remain[index] ; i++){
            helper(remain,index+1,sum - i);
        }
    }
}
