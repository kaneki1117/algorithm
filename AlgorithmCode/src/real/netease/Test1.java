package real.netease;

import java.util.*;

/**
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * 输出描述:
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 *
 * 3 3
 * 1 100
 * 10 1000
 * 1000000000 1001
 * 9 10 1000000000
 *
 * Output
 * 100
 * 1000
 * 1001
 *
 */
//已ac  思路是用一个队列存储所有人的能力值，另一个队列存储所有任务和能力值，之后依次更新map中的能完成的任务值。

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int workNum = sc.nextInt();
        int boyNum = sc.nextInt();
        Map<Integer,Integer> works = new HashMap<>();
        int[] ablities = new int[boyNum];
        int[] hard = new int[boyNum + workNum];
        for (int i = 0; i < workNum; i++) {
            int hardness = sc.nextInt();
            int pay = sc.nextInt();
            works.put(hardness,pay);
            hard[i] = hardness;
        }
        for (int i = 0; i < boyNum; i++) {
            int ability = sc.nextInt();
            hard[workNum + i] = ability;
            ablities[i] = ability;
        }
        Arrays.sort(hard);
        int max = 0;
        for (int i = 0; i < hard.length; i++) {
            if(works.get(hard[i]) == null){
                works.put(hard[i],max);
            }else{
                max = Math.max(works.get(hard[i]),max);
                works.put(hard[i],max);

            }
        }
        for (int i = 0; i < boyNum; i++) {
            System.out.println(works.get(ablities[i]));
        }
    }

    /** 网上版本
     * import java.util.*;
     * public class Main{
     *     public static void main(String[] args){
     *         Scanner sc = new Scanner(System.in);
     *         int n = sc.nextInt();
     *         int m = sc.nextInt();
     *         int t1=0,t2=0;
     *         HashMap<Integer,Integer> hs = new HashMap<>();
     *         int[] a = new int[n+m];
     *         int[] b = new int[m];
     *         for(int i=0;i<n;i++){
     *             t1 = sc.nextInt();
     *             t2 = sc.nextInt();
     *             a[i] = t1;
     *             hs.put(t1,t2);
     *         }
     *         for(int i=0;i<m;i++){
     *             t1 = sc.nextInt();
     *             a[n+i] = t1;
     *             b[i] = t1;
     *             if(!hs.containsKey(t1))
     *                hs.put(t1,0);
     *         }
     *         Arrays.sort(a);
     *         int max = 0;
     *         for(int i=0;i<m+n;i++){
     *             max = Math.max(max,hs.get(a[i]));
     *             hs.put(a[i],max);
     *         }
     *         for(int i=0;i<m;i++){
     *             System.out.println(hs.get(b[i]));
     *         }
     *     }
     * }
     */
}
