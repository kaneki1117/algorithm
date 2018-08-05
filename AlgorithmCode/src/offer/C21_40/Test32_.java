package offer.C21_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//本题 主要考虑到此方法思路：可以按照自己想要的想法作比较器 对数组列表等重排。
public class Test32_ {
    public static void main(String[] args) {
        int[] arr = {33,132,2,2,65};
        System.out.println(PrintMinNumber(arr));
    }

    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 +"" + o2;
                String str2 = o2 +"" + o1;

                return  Integer.parseInt(str1) - Integer.parseInt(str2);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i)+"");
        }
        return result.toString();
    }


}
