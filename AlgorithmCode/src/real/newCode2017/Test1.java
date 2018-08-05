package real.newCode2017;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ab = new int[num];
        for (int i = 0; i < num; i++) {
            ab[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();
        long result = getMaxProduct(ab,k,d);
        System.out.println(result);
    }

    public static long getMaxProduct(int[] ab,int k ,int d){
        if( k > ab.length ||  ab.length == 0) return 0;
        long result = 1;
        long[] maxres = new long[ab.length];
        long[] minres = new long[ab.length];

        return result;
    }
}
