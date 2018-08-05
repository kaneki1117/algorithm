package offer.C21_40;
//注意最后的 double check 不一定存在这样的数。
public class Test28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int count = 1;
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if(count == 0){
                res = array[i];
                count = 1;
                continue;
            }
            if(array[i] == res){
                count++;
            }else {
                count--;
            }
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == res) temp++;
        }

        return temp > array.length/2 ? res:0;
    }
}
