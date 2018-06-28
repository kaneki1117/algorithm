package offer;
//和 跳台阶1 同理
public class Test10 {
    public int RectCover(int target) {
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
