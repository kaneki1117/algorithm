package offer.C21_40;

//之前对丑数的做法一直都没有很明确的了解 下标不停增加 对应的含义：实际上是所有前面的丑数乘上2，3，5，但是把肯定小于要求结果的前1个数的部分舍弃了。
public class Test33_ {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }

    public static int GetUglyNumber_Solution(int index) {
        if(index <= 6) return index;

        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        int[] res = new int[index];
        res[0] = 1;
        for (int i = 1; i < index ; i++) {
            int min = getMin(res[n2]*2,res[n3]*3,res[n5]*5);
            if(min == res[n2]*2) n2++;
            if(min == res[n3]*3) n3++;
            if(min == res[n5]*5) n5++;
            res[i] = min;
        }
        return res[index-1];
    }

    public static int getMin(int a,int b,int c){
        return  Math.min(Math.min(a,b),c);
    }
}
