package offer.C41_60;

public class Test48_ {
    public static void main(String[] args) {
        System.out.println(Add(5,7));
    }

    public static int Add(int num1,int num2) {

        while (num1 != 0){
            int temp = num1^num2;
            num1 = (num1&num2)<<1;
            num2 = temp;
        }
        return num2;
    }
}
