package others.bagSeries;

/**
 * 0.1 背包问题 要求完全装满
 * //必装满则f[0]=0,f[1...m]都初始化为无穷小
 */
public class Test3 {
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            int[] weight = {3,5,2,6,4}; //物品重量
            int[] val = {4,4,3,5,3}; //物品价值
            int m = 12; //背包容量
            int n = val.length; //物品个数

            int[] f = new int[m+1];
            for(int i=1;i<f.length;i++){
                f[i] = Integer.MIN_VALUE;
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
