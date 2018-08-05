package offer.C1_20;

public class Test8 {
    public int JumpFloor(int target) {
        if(target <= 2) return target;
        long lastLast = 1;
        long last = 2;
        long res = 0;
        for (int i = 2; i < target; i++) {
            res = last + lastLast;
            lastLast = last;
            last = res;
        }

        return (int)res;
    }
}
