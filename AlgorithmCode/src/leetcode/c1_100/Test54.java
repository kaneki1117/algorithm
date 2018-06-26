package leetcode.c1_100;

import java.util.ArrayList;
import java.util.List;
//特别注意循环最后的两步 如何保证没有重复。
public class Test54 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = spiralOrder(matrix);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int top = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length -1;
        while (top <= down && left <= right){
            for (int i = left; i <= right ; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <=down ; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if(top <= down){
                for (int i = right; i >= left ; i--) {
                    result.add(matrix[down][i]);
                }
            }
            down--;
            if(left <= right){
                for (int i = down; i >= top ; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }

        return  result;
    }
}
