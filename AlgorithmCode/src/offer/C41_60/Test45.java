package offer.C41_60;

import java.util.Arrays;

/**
 * 1、排序
 * 2、计算所有相邻数字间隔总数
 * 3、计算0的个数
 * 4、如果2、3相等，就是顺子
 * 5、如果出现对子，则不是顺子
 */
public class Test45 {
    public static void main(String[] args) {
        int[] arr = {2,1,1,5,3};
        System.out.println(isContinuous(arr));
    }

    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0)return false;
        int count = 0;
        int distance = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0){
                count++;
            }
            if(i>0 && numbers[i-1] != 0){
                distance = numbers[i] - numbers[i-1];
                if(distance == 0){
                    return false;
                }
                while (distance != 1){
                    distance--;
                    count--;
                    if(count < 0){
                        return false;
                    }
                }
            }


        }

        return true;
    }
}
