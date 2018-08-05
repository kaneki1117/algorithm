package offer.C61_66;
//自己做的只能ac 20 但是他提示的错误样例本地可以通过
public class Test65 {

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'a','b','c','b'};
        System.out.println(hasPath(matrix,3,4,str));
    }
    static boolean result =false;
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str.length == 0) return false;
        char[][] newmatrix = new char[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            newmatrix[i/cols][i%cols] = matrix[i];
        }

        boolean[][] visit = new boolean[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(newmatrix[i][j] == str[index]){
                    makeBFS(newmatrix,i,j,str,index,visit);
                }
            }
        }

        return result;
    }

    public static void makeBFS(char[][] matrix,int i,int j,char[] str, int index,boolean[][] visit) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length||visit[i][j] ){
            return;
        }

        if(index == str.length){
            result = true;
            return;
        }
            visit[i][j] = true;
        if(matrix[i][j] == str[index]){
            makeBFS(matrix,i+1,j,str,index+1,visit);
            makeBFS(matrix,i-1,j,str,index+1,visit);
            makeBFS(matrix,i,j+1,str,index+1,visit);
            makeBFS(matrix,i,j-1,str,index+1,visit);
            visit[i][j] = false;
        }
    }
}


/**参考答案
 * public class Solution {
 *     public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
 *         int flag[] = new int[matrix.length];
 *         for (int i = 0; i < rows; i++) {
 *             for (int j = 0; j < cols; j++) {
 *                 if (helper(matrix, rows, cols, i, j, str, 0, flag))
 *                     return true;
 *             }
 *         }
 *         return false;
 *     }
 *  
 *     private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
 *         int index = i * cols + j;
 *         if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
 *             return false;
 *         if(k == str.length - 1) return true;
 *         flag[index] = 1;
 *         if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
 *                 || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
 *                 || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
 *                 || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
 *             return true;
 *         }
 *         flag[index] = 0;
 *         return false;
 *     }
 * }
 */