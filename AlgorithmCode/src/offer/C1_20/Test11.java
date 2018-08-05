package offer.C1_20;

public class Test11 {

    public static void main(String[] args) {
        System.out.println(NumberOf1(8));
    }

    public static int NumberOf1(int n) {
        int standard = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if((n & standard) !=0){
                res++;
            }
            standard <<= 1;
        }
        return res;
    }

    /**
     * 最优解
     * public static int NumberOf1(int n) {
     *         int count = 0;
     *         while (n != 0) {
     *             ++count;
     *             n = (n - 1) & n;
     *         }
     *         return count;
     *     }
     */
}
