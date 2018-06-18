package leetcode.c1_100;

/**
 * 基本思路就是维护一个长度为n的数组，进行两次扫描，一次从左往右，一次从右往左。
 * 第一次扫描的时候维护对于每一个bar左边最大的高度是多少，存入数组对应元素中，第二次扫描的时候维护右边最大的高度，
 * 并且比较将左边和右边小的最大高度（我们成为瓶颈）存入数组对应元素中。这样两遍扫描之后就可以得到每一个bar能承受的最大水量
 * 从而累加得出结果。这个方法只需要两次扫描，所以时间复杂度是O(2*n)=O(n)。空间上需要一个长度为n的数组，复杂度是O(n)。
 */
public class Test42 {

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(array));
    }

    public static int trap(int[] array){
        int res = 0;
        if(array == null || array.length < 2){
            return 0;
        }
        int[] container = new  int[array.length];
        int max = 0;
        for (int i = 0; i < container.length; i++) {
            max = Math.max(max,array[i]);
            container[i] = max;

        }
        max = 0;
        for (int i = container.length -1; i >=0 ; i--) {
            container[i] = Math.min(max,container[i]);
            max = Math.max(array[i],max);
            if(container[i] - array[i] > 0){
                res +=  container[i] - array[i];
            }
        }

        return res;
    }

    /**
     * 思路2：
     * 用两个指针从两端往中间扫，在当前窗口下，如果哪一侧的高度是小的，那么从这里开始继续扫，如果比它还小的，肯定装水的瓶颈就是它了，
     * 可以把装水量加入结果，如果遇到比它大的，立即停止，重新判断左右窗口的大小情况，重复上面的步骤。这里能作为停下来判断的窗口，
     * 说明肯定比前面的大了，所以目前肯定装不了水（不然前面会直接扫过去）。这样当左右窗口相遇时，就可以结束了，因为每个元素的装水量都已经记录过了。
     *这个算法每个元素只被访问一次，所以时间复杂度是O(n)，并且常数是1.
     *
     * public int trap(int[] A) {
     *     if(A==null || A.length ==0)
     *         return 0;
     *     int l = 0;
     *     int r = A.length-1;
     *     int res = 0;
     *     while(l<r)
     *     {
     *         int min = Math.min(A[l],A[r]);
     *         if(A[l] == min)
     *         {
     *             l++;
     *             while(l<r && A[l]<min)
     *             {
     *                 res += min-A[l];
     *                 l++;
     *             }
     *         }
     *         else
     *         {
     *             r--;
     *             while(l<r && A[r]<min)
     *             {
     *                 res += min-A[r];
     *                 r--;
     *             }
     *         }
     *     }
     *     return res;
     * }
     */
}
