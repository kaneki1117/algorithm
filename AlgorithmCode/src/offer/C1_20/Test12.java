package offer.C1_20;

public class Test12 {
    public double Power(double base, int exponent) {
        if(base == 0.0 ){
            return 0.0;
        }else if(exponent == 0){
            return 1.0;
        }

        boolean b = exponent < 0?false:true;
        int exp = Math.abs(exponent);
        double result = 1;
        for (int i = 1; i <= exp; i++) {
            result *= base;
        }
        if(b){
            return result;
        }else{
            return 1/result;
        }


    }


}
