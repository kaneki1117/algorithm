package others.bagSeries;

/**
 * Created by heyu1 on 2018/6/11
 * 多重背包问题（网上依然缺少比较好的讲解）
 * 理解 f[j] = Math.max(f[j], f[j-weight[i]*k]+val[i]*k);  j倒序，
 */
public class Test5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] weight = {3,5,2,6,4}; //物品重量
        int[] val = {4,4,3,5,3}; //物品价值
        int[] nums = {1,0,1,0,1};
        int m = 9; //背包容量
        int n = val.length; //物品个数
        //对数量进行优化 超过背包容量的不考虑
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.min(nums[i],m/weight[i]);
        }
        int[] f = new int[m+1];
        for(int i=0;i<f.length;i++){
            f[i] = 0;
        }
        for(int i=0;i<val.length;i++){
            for(int j=f.length-1;j>=weight[i];j--){
                for (int k = 0; k <= nums[i]; k++) {
                    if(j - k*weight[i] >= 0){
                        f[j] = Math.max(f[j], f[j-weight[i]*k]+val[i]*k);
                    }
                }

            }
        }
        int max = 0;
        for (int i = 0; i < f.length; i++) {
            max = Math.max(max,f[i]);
        }
        System.out.println(max);
    }

}
