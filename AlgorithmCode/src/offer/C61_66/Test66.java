package offer.C61_66;

public class Test66 {
    public static void main(String[] args) {
        System.out.println(movingCount(15,20,20));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if(rows <= 0 || cols <= 0 ) return 0;
        long sum = 0;
        boolean[][] sign = new boolean[rows][cols];
        sum += helper(0,0,rows,cols,threshold,sign);
        return (int) sum;

    }

    public static int helper(int i, int j ,int rows,int cols,int threshold,boolean[][] sign){
        if(i < 0 || i >= rows || j < 0 || j >= cols || count(i)+ count(j) > threshold){
            return 0;
        }
        if(sign[i][j]) return 0;
        sign[i][j] = true;
        return 1 + helper(i+1,j,rows,cols,threshold,sign) + helper(i,j+1,rows,cols,threshold,sign);
    }



    public static int count(int num){
        int res = 0;
        while (num != 0){
            res += num%10;
            num/=10;
        }

        return res;
    }
}
