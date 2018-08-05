package leetcode.c101_200;
//此题不错！！自己根据提示才做出的  主要从后往前的思路 比较重要

public class Test174 {
    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }

    public static int calculateMinimumHP(int[][] dungeon){
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        //
        int m = dungeon.length;
        int n = dungeon[0].length;

        //status
        int[][] func = new int[m][n];

        //init
        func[m-1][n-1] = dungeon[m-1][n-1]>0?0:dungeon[m-1][n-1];
        for (int i = n-2; i >= 0; i--) {
            func[m-1][i] = func[m-1][i+1] + dungeon[m-1][i];
            if(func[m-1][i] > 0){
                func[m-1][i] = 0;
            }
        }

        for (int i = m-2; i >= 0; i--) {
            func[i][n-1] = func[i+1][n-1] + dungeon[i][n-1];
            if(func[i][n-1] > 0) func[i][n-1] = 0;
        }

        //function
        for (int i = m-2; i >=0 ; i--) {
            for (int j = n-2; j >= 0; j--) {
                func[i][j] = Math.max(func[i+1][j],func[i][j+1]) + dungeon[i][j];
                if(func[i][j] > 0){
                    func[i][j] = 0;
                }
            }
        }

        if(func[0][0] == 0){
            return 1;
        }else {
            return Math.abs(func[0][0])+1;
        }
    }
}
