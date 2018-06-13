package real.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
 *
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
 *
 * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 *
 *
 * 输入描述:
 * 输入包括五行。
 * 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
 * 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
 * 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
 * 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
 * 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
 *
 *
 * 输出描述:
 * 输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
 *
 * 输入例子1:
 * 2
 * 0 90
 * 0 90
 * 100 200
 * 100 200
 *
 * 输出例子1:
 * 2
 */
//未ac 答案
    //ac Python 版本
//了解此题原理
/**
 * import sys
 * lines = sys.stdin.readlines()
 * n = int(lines[0])
 * x1 = list(map(int,lines[1].split()))
 * y1 = list(map(int,lines[2].split()))
 * x2 = list(map(int,lines[3].split()))
 * y2 = list(map(int,lines[4].split()))
 * res = 1
 * for x in x1+x2:
 *     for y in y1+y2:
 *         cnt = 0
 *         for i in range(n):
 *             if x > x1[i] and y > y1[i] and x <= x2[i] and y <= y2[i]:
 *                 cnt += 1
 *         res = max(res,cnt)
 * print(res)
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int num = sc.nextInt();
        int maxNum = 0;
        long[] x1 = new long[num];
        long[] x2 = new long[num];
        long[] y1 = new long[num];
        long[] y2 = new long[num];
        List<Long> row = new ArrayList<>();
        List<Long> column = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            x1[i] = sc.nextLong();
            row.add(x1[i]);
        }
        for (int i = 0; i < num; i++) {
            y1[i] = sc.nextLong();
            column.add(y1[i]);
        }
        for (int i = 0; i < num; i++) {
            x2[i] = sc.nextLong();
            row.add(x2[i]);
        }
        for (int i = 0; i < num; i++) {
            y2[i] = sc.nextLong();
            column.add(y2[i]);
        }
        for(Long x: row){
            for(Long y : column){
                    int count  = 0;
                for (int i = 0; i < num; i++) {
                    if(x >= x1[i] && y >= y1[i] && x < x2[i] && x < y2[i]){
                        count++;
                    }
                }
                maxNum = Math.max(count,maxNum);
            }
        }

        System.out.println(maxNum);
    }
}
