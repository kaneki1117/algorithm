package offer;

public class Test1 {
    public static boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length  == 0){
            return false;
        }

        int m = array.length - 1;
        int n = array[0].length - 1;
        int x = 0; int y = n;
        while (x >= 0 && x <= m && y >= 0 && y <= n){
            if(array[x][y] == target){
                return true;
            }else if(array[x][y] < target){
                x++;
            }else {
                y--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7,a));
    }
}
