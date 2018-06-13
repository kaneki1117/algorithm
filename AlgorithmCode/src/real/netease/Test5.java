package real.netease;

import java.util.Scanner;

/**
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 *
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 *
 *
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 *
 * 输入例子1:
 * 5 2
 *
 * 输出例子1:
 * 7
 */
//记住这个规律 注意是一层循环 因为是直接计算 所以没有对x的循环
public class Test5 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        if(k == 0){
            System.out.println(n*n);
            return;
        }
        long res = 0;

        for (long y = k; y <=n ; y++) {
            res += (n/y)*(y-k)+Math.max(0,n%y-k+1);
        }
        System.out.println(res);
    }

}
