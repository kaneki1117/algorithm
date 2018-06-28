package offer;

public class Test7 {
    //虽然ac但不够熟练，开始没处理好n=2。。应该让ll从0开始记会更简洁一些。
    public int Fibonacci(int n) {
        if(n <= 1) return n;
        long last = 1;
        long lastLast = 0;
        long res = 0;
        for (int i = 1; i < n; i++) {
            res = last + lastLast;
            lastLast = last;
            last = res;
        }

        return (int)res;
    }
}
