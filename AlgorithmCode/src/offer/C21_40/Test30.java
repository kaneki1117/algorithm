package offer.C21_40;

public class Test30 {
    public static void main(String[] args) {
        int[] arr = {-1,6,-3,2,7,-3,2,-11};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        long sum = 0;
        //注意此处 minSum 应当为0  考虑全是正的情况
        long minSum = 0;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            max = Math.max(max,sum - minSum);
            minSum = Math.min(minSum,sum);
        }
        return (int)max;
    }
}
