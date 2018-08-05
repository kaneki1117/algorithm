package offer.C41_60;

public class Test49_ {
    //当输入 为2*10^19次方时  大于了最大long值 过不了leetcode ac 需要通过不停*10翻倍 超过MAx或min直接返回。
    //for (int i = start; i < len; i++) {
    //		if (!Character.isDigit(str.charAt(i)))
    //			return (int) sum * sign;
    //		sum = sum * 10 + str.charAt(i) - '0';
    //		if (sign == 1 && sum > Integer.MAX_VALUE)
    //			return Integer.MAX_VALUE;
    //		if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
    //			return Integer.MIN_VALUE;
    //	}

    /**
     * 总结一下考虑的情况 :1.空字符串 和只有空格 直接0  2.直接一个+ 或者 - 号 也返回0
     * 3.进行trim去空格 4.对开始的符号进行判断
     * 5.Integer.minValue 的情况 先long存储。
     * 6.超大数据情况直接返回0
     *
     */
    public static void main(String[] args) {

        System.out.println(StrToInt("20000000000000000000"));
    }

    public static int StrToInt(String str) {
        if(str == null || str.trim().length() == 0){
            return 0;
        }

        str = str.trim();
        int index = 0;
        boolean isNeg = false;
        if(str.charAt(0) == '-'){
            isNeg = true;
            index++;
        }else if(str.charAt(0) == '+') {
            index++;
        }



        for (int i = index; i< str.length(); i++) {
            if(!Character.isDigit(str.charAt(i) )){
                return 0;
            }
        }


        if(str.substring(index).length()== 0) return 0;
        long res = Long.parseLong(str.substring(index));
        if(isNeg = true && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(isNeg = false && res*(-1) < Integer.MIN_VALUE)  return Integer.MIN_VALUE;
        int result = (int)res;

        return isNeg == false?result:-result;
    }
}
