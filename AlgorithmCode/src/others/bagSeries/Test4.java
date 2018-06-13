package others.bagSeries;

/**
 * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是c[i]，价值是w[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * 这个算法使用一维数组，先看伪代码：
 *
 * for i=1..N
 *
 *     for v=0..V
 *
 *         f[v]=max{f[v],f[v-cost]+weight}
 *
 * 你会发现，这个伪代码与01背包的伪代码只有v的循环次序不同而已。
 */
public class Test4 {
    public static void main(String[] args){
        int[] weight = {3,5,2,6,4}; //物品重量
        int[] val = {4,4,3,5,3}; //物品价值
        int maxw = 12; //背包容量
        int[] f = new int[maxw+1];
        for(int i=0;i<f.length;i++){
            f[i] = 0;
        }
        for(int i=0;i<val.length;i++){
            for(int j=weight[i];j<f.length;j++){
                f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
            }
        }
        System.out.println(f[maxw]);
    }
}
