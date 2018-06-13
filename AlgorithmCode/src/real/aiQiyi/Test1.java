package real.aiQiyi;

import java.util.Scanner;

/**
 * 给定字符串s，s只包含小写字母，请求出字典序最大的子序列。
 * 子序列：https://en.wikipedia.org/wiki/Subsequence
 * 字典序：https://en.wikipedia.org/wiki/Lexicographical_order
 * 输入描述:
 * 一行一个字符串s (1 <= |s| <= 100,000)。
 * 输出描述:
 * 字典序最大的子序列。
 * //最大字典序子序列
 * //解题思路：例如一个字符串asdfghj，我们首先需要遍历一遍字符串，找到字典排序最大的s，
 * //然后接下来遍历dfghj，找到最大的j。此时j是最后一个字符，
 * //搜索结束，字典排序最大的子字符串即为sj。
 */
//已ac 注意temp的作用 不能直接用index
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] list = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = -1;
        while(index <list.length-1) {
            char max = list[list.length - 1];
            int temp = -1;
            for (int i = list.length - 1; i >index ; i--) {

                if(list[i] >= max){
                    max = list[i];
                    temp = i;
                }
            }
            index = temp;
            sb.append(max+"");
        }

        System.out.println(sb.toString());
    }
}
