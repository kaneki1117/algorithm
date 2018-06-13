package others.bagSeries;

//最基本的背包问题 01背包

/**
 * 有编号分别为a,b,c,d,e的五件物品，它们的重量分别是2,2,6,5,4，
 * 它们的价值分别是6,3,5,4,6，每件物品数量只有一个，
 * 现在给你个承重为10的背包，如何让背包里装入的物品具有最大的价值总和？
 */
public class Test1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] weight = {3,5,2,6,4}; //物品重量
        int[] val = {4,4,3,5,3}; //物品价值
        int m = 12; //背包容量
        int n = val.length; //物品个数

        int[][] f = new int[n+1][m+1]; //f[i][j]表示前i个物品能装入容量为j的背包中的最大价值
        //初始化第一列和第一行
        for(int i=0;i<f.length;i++){
            f[i][0] = 0;
        }
        for(int i=0;i<f[0].length;i++){
            f[0][i] = 0;
        }
        for(int i=1;i<f.length;i++){

            for(int j=1;j<f[0].length;j++){
                if(weight[i-1]>j){
                    f[i][j] = f[i-1][j];
                }else{
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-weight[i-1]] + val[i-1]);
                }
            }
         }
    }

}
//如果想查看组成最大value是使用了哪几个位置的可以使用path数组在遍历时记录
//通过公式迭代计 int[][] path = new int[n+1][m+1];
        //       if(weight[i-1]>j)
//                    f[i][j] = f[i-1][j];
//                else{
//                    if(f[i-1][j]<f[i-1][j-weight[i-1]]+val[i-1]){
//                        f[i][j] = f[i-1][j-weight[i-1]]+val[i-1];
//                        path[i][j] = 1;
//                    }else{
//                        f[i][j] = f[i-1][j];
//                    }
//                    //f[i][j] = Math.max(f[i-1][j], f[i-1][j-weight[i-1]]+val[i-1]);
//                }
//       int i=f.length-1;
//        int j=f[0].length-1;
//        while(i>0&&j>0){
//            if(path[i][j] == 1){
//                System.out.print("第"+i+"个物品装入 ");
//                j -= weight[i-1];
//            }
//            i--;
//        }




