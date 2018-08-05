package offer.C41_60;

import java.util.ArrayList;

public class Test42 {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length == 0) return res;

        int left = 0 ; int right = array.length - 1;
        while (left < right){
            if(array[left] + array[right] == sum ){
                res.add(array[left]);
                res.add(array[right]);
                break;
            }else if(array[left] + array[right] < sum ){
                left++;
            }else {
                right--;
            }
        }

        return res;
    }
}
