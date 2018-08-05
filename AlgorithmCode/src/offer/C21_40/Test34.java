package offer.C21_40;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//个人解法 太浪费空间  可以省去 list 和 pos 的空间。只需要重新遍历 原字符串即可。
public class Test34 {
    public static void main(String[] args) {
        String str = "afedsacfd";
        System.out.println(FirstNotRepeatingChar(str));
    }

    public static int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0) return -1;
        char[] arr = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> pos = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
                list.add(arr[i]);
                pos.put(arr[i],i);
            }
        }

        for (int i = 0; i < list.size(); i++) {

            if(map.get(list.get(i)) == 1){
                return pos.get(list.get(i));
            }
        }

        return -1;
    }
}
