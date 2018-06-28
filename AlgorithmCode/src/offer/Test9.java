package offer;
//注意边界是target-1 不是target
public class Test9 {
    public int JumpFloorII(int target) {
        if(target <= 1) return target;
        long res = (long)Math.pow(2,target-1);
        return (int)res;
    }
}
