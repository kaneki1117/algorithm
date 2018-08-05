package offer.C41_60;


import java.util.ArrayList;

//未能ac 数学思路 比较巧妙

public class Test41_ {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(100);
        for(ArrayList<Integer> list : res){
            for(Integer i : list){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }


    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum <= 0) return result;
        double temp = Math.sqrt(2* sum);
        for (int i = (int)temp; i >=2 ; i--) {
            if((i&1)==1&&sum%i == 0 || (sum%i*2)==i){
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0,k= sum/i-(i-1)/2; j < i; j++,k++) {
                    list.add(k);
                }
                result.add(list);
            }

        }
        return result;
    }
}
