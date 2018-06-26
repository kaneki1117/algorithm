package others.sort;

public class RadixSort {


    public static void main(String[] args) {
        int[] array = new int[]{2222,373,22,2314,17,5428};
        radixSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    // only for no-negative value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] arr, int begin, int end, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] count = new int[radix];
        int[] bucket = new int[end - begin + 1];
        for (int d = 1; d <= digit; d++) {
            //注意多个for循环的上下界
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }
            for (i = begin; i <= end; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            //将各个桶中的数字个数，转化成各个桶中最后一个数字的下标索引
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            //这里一定是从后向前遍历,才不会在这次排序中相同的情况下打乱之前的排序顺序
            for (i = end; i >= begin; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = begin, j = 0; i <= end; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
    /**
     * public static int getBit(int num, int d){
     *         return ((num/(int)Math.pow(10,d-1))%10);
     *     }
     */
}
