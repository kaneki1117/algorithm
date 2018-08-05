package real.netease.autumn2017;
/**
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 * 例如：半径的平方如果为25
 * 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
 * 输入描述:
 * 输入为一个整数，即为圆半径的平方,范围在32位int范围内。
 *
 *
 * 输出描述:
 * 输出为一个整数，即为优雅的点的个数
 *
 * 输入例子1:
 * 25
 *
 * 输出例子1:
 * 12
 *
 *
 * 未能ac 题目不难。但自己思考的太复杂了 其实只要将得到的两个整数尝试能否得到sum和即可。
 */

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        System.out.println(countTimes(sum));
    }

    public static int countTimes(int sum){
        int result = 0;
        double s2 = Math.sqrt(sum);

        for (int i = 1; i <=s2 ; i++) {
            int temp = (int)Math.sqrt(sum - i*i);
            if(i*i + temp*temp == sum){
                result+= 4;
            }
        }

        return result;
    }


   /* public static int countTimes(int sum){
        int result = 0;
         int s2 = mySqrt(sum);
         if(s2 * s2 == sum){
             result += 4;
         }
        for (int i = 1; i <=sum ; i++) {
            int temp = mySqrt(sum - i*i);
            if(temp == 0) continue;
            if(i*i + temp*temp == sum){
                result+= 4;
            }
        }

        return result;
    }


    public static int mySqrt(int num){
        if(num < 0)return 0;
        int start = 0 ; int end = num;
        while (start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(mid* mid == num){
                return mid;
            }else if(mid * mid < num){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(end * end < num){
            return end;
        }
        return start;
    }*/
}
