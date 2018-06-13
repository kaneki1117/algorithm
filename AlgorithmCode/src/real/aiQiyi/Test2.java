package real.aiQiyi;
import  java.util.*;
/**
 * 题目描述：
 * 牛牛有三个整数X, Y, Z. 牛牛现在要使用若干次操作让X, Y, Z变为相等，每次操作牛牛有两种操作类型可选：
 * 操作1：从X, Y, Z中选择两个数，都加1
 * 操作2：从X, Y, Z中选择一个数，加2
 * 牛牛已经证明了使用若干次这两种操作一定可以让三个整数变为相等，请你帮他计算一下最少需要多少次操作。
 * 对数组升序排序，计算两个较小数与最大数的差值n1, n2 (n1 > n2)，先选较小的两个数进行加1操作，直至有两个数相等（即第二小的数与最大数），接着对较小数进行加2操作。注意：此时若第三个数与它们的差为奇数，则还需（差/2 + 2）次操作，若为偶数则还需（差/2）次操作。
 *
 * 例1: (2, 4, 5) -> (3, 5, 5) -> (5, 5, 5)
 * 需 (n1 + (n2 - n1) / 2) 次操作
 *
 * 例2: (1, 4, 5) -> (2, 5, 5) -> (4, 5, 5) -> (6, 5, 5) -> (6, 6, 6)
 * 需 (n1 + (n2 - n1) / 2 + 2) 次操作
 */
public class Test2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int[] num = new int[3];
        for(int i=0; i<3; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(num);
        //排序后计算三个数中两两之间最大差n1与最小差n2
        int n1 = num[2]-num[0];
        int n2 = num[2]-num[1];
        int count = 0;
        //判断两种情况
        if((n1-n2) %2 == 1) {
            count = n2 + (n1-n2)/2 + 2;
        }
        else {
            count = n2 + (n1-n2)/2;
        }
        System.out.println(count);
    }
    /**
     * 考试时自己ac的方式
     *
     *  public static void main(String[] args) {
     *         Scanner scanner = new Scanner(System.in);
     *         int[] arr = new int[3];
     *         for (int i = 0; i < arr.length; i++) {
     *             arr[i] = scanner.nextInt();
     *         }
     *         Arrays.sort(arr);
     *         if ((arr[2] - arr[1] + arr[2] - arr[0]) % 2 == 0) {
     *             System.out.println((arr[2] - arr[1] + arr[2] - arr[0]) / 2);
     *         } else {
     *             System.out.println((arr[2] - arr[1] + arr[2] - arr[0] + 3) / 2);
     *         }
     *     }
     */
}
