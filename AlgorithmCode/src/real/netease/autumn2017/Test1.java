package real.netease.autumn2017;

import java.util.Scanner;

/**
 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 * {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 * {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 * 现在给出一个数字序列，允许使用一种转换操作：
 * 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 * 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 *
 * 输入描述:
 * 输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50) 第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。
 *
 *
 * 输出描述:
 * 输出一个数，表示最少需要的转换次数
 *
 * 输入例子1:
 * 4 1 1 1 3
 *
 * 输出例子1:
 * 2
 */
//个人已ac 思路是比较两端的数 相邻则将小数与相邻数进行一下合并。
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(countChangeTimes(arr,num));
    }

    public static int countChangeTimes(int[] arr, int num){
        if(num <= 1 ) return 0;
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        while (left + 1 < right){
            if(arr[left] < arr[right]){
                arr[left+1] += arr[left];
                left++;
                res++;
            }else if(arr[left] > arr[right]){
                arr[right - 1]+= arr[right];
                res++;
                right--;
            }else{
                left++;
                right--;
            }
        }

        return arr[left] == arr[right]?res:res+1;
    }
}
