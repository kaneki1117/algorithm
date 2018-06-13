package book.test;

import java.util.Stack;

public class Test1 {

	public static void main(String[] args) {
		int[] weight = {3,5,2,6,4}; //物品重量
		int[] val = {4,4,3,5,3}; //物品价值
		int m = 12; //背包容量

	}

	public static void maxValue(int[] weight,int[] val,int m){
		int n = weight.length;
		int[][] values = new int[n+1][m+1];
		for (int i = 0; i < values.length; i++) {
			values[i][0] = 0;
		}
		for (int i = 0; i < values[0].length; i++) {
			values[0][i] = 0;
		}

		for (int i = 1; i < values.length; i++) {
			for (int j = 1; j < values[0].length; j++) {
				if(weight[i-1]>j){
					values[i][j] = values[i-1][j];
				}else{
					values[i][j] = Math.max(values[i-1][j],values[i-1][j-weight[i-1]] + val[i-1]);
				}
			}
		}
	}
}
