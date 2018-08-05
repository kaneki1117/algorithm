package offer.C1_20;

import java.util.ArrayList;

public class Test19 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int left = 0 ; int right = matrix[0].length - 1;
        int top = 0 ; int down = matrix.length - 1;
        while (left <= right && top <= down){
            for (int i = left; i <=right ; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <=down ; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if(top <= down){
                for (int i = right; i >= left ; i--) {
                    res.add(matrix[down][i]);
                }
            }
            down--;
            if(left <= right){
                for (int i = down; i >= top ; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrix(matrix);
    }
}
