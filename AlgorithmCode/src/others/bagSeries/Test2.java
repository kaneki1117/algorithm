package others.bagSeries;

//最基本的背包问题 01背包 与Test1不同的是他用一维数组表示
//注意第二层j循环时的上下限
public class Test2 {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] weight = {3,5,2,6,4}; //物品重量
        int[] val = {4,4,3,5,3}; //物品价值
        int m = 12; //背包容量
        int n = val.length; //物品个数

        int[] f = new int[m+1];
        for(int i=0;i<f.length;i++){     //不必装满则初始化为0
            f[i] = 0;
        }
        for(int i=0;i<n;i++){
            for(int j=f.length-1;j>=weight[i];j--){
                f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
            }
        }
        for(int i=0;i<f.length;i++){
            System.out.print(f[i]+" ");
        }
        System.out.println();
        System.out.println("最大价值为"+f[f.length-1]);
    }

}
