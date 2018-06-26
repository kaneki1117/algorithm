package leetcode.c101_200;

public class Test200 {

    public static void main(String[] args) {
         char[][] temp = new char[][]{{'1','1'},{'0','1'}};
        System.out.println(numIslands(temp));
    }
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    makeBFS(grid,i,j);
                    res++;
                }
            }
        }

        return res;
    }

    public static void makeBFS(char[][] grid,int i ,int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            makeBFS(grid,i+1,j);
            makeBFS(grid,i-1,j);
            makeBFS(grid,i,j+1);
            makeBFS(grid,i,j-1);
        }

    }
}
