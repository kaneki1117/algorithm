package leetcode.c1_100;

public class Test59 {
    public static void main(String[] args) {

    }

    public  int[][] genMatrix(int n){
        int value = 0;
        int left = 0;
        int right = n-1;
        int top = 0 ;
        int down = n-1;
        int[][] res = new int[n][n];
        while(left <= right && top <= down){
            for (int j = left; j <= right; j ++) {
                res[left][j] = ++value;
            }
            top++;

            for (int j = top; j <= down; j ++) {
                res[j][right] = ++value;
            }
            right--;

            if (top <= down) {
                // Traverse Left
                for (int j = right; j >= left; j --) {
                    res[down][j] = ++value;
                }
            }
            down--;

            if ( left<=right ) {
                // Traver Up
                for (int j = down; j >= top; j --) {
                    res[j][left] = ++value;
                }
            }
            left ++;
        }

        return res;
    }
}
