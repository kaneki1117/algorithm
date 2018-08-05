package book.test;

import common.TreeNode;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int nums = sc.nextInt();
//        int[] prices = new int[nums];
//        for (int i = 0; i < nums; i++) {
//            prices[i] = sc.nextInt();
//        }
        int[] prices = {3,8,6,9,7,6};
        int max = Math.max(maxPrice(prices,0), maxPrice(prices,1));
        System.out.println(max);
    }


    public static int maxPrice(int[] prices,int offset){
        if(prices.length <= 1)
            return prices.length == 0 ? 0:prices[0];

        //res[i] means the max price with end of prices[i]
        int[] res = new int[prices.length];
        //init
        res[offset] = prices[offset];
        res[offset+1] = prices[1+offset];
        for(int i = 2 + offset; i < prices.length - 1 + offset; i++){
            int max = prices[i];
            for (int j = 0; j < i-1; j++) {
                if(prices[i] > prices[j] && prices[i] + res[j] > max){
                    max = prices[i] + res[j] ;
                }
            }
            res[i] = max;
        }
        int result = Integer.MIN_VALUE;
        for (int i = offset; i < prices.length - 1 + offset; i++) {
            result = Math.max(result,res[i]);
        }

        return result;
    }
}
