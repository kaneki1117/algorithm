package real.netease;

import java.util.Scanner;

/**
 *小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 *
 * 输入描述:
 * 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
 *
 * 输出描述:
 * 输出一个整数, 表示区间内能被3整除的数字个数。
 */
//思想就是 算出前l-1中 不满足的个数  前r中不满足的个数  然后用总数减去 其中不满足的个数即可
    //由此题可想到做类似中间一段数时考虑到 也就是prefixSum的思想。
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int base = r-l + 1;
        int useless = countUseless(r) - countUseless(l-1);
        int res = base - useless;
        System.out.println(res);

    }


    public static int countUseless(int x){
        return (x+2)/3;
    }
}
