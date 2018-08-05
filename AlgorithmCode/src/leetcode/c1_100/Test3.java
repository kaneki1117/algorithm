package leetcode.c1_100;

import java.util.HashMap;
import java.util.Map;
//维护一个窗口
public class Test3 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));

    }
    public static int lengthOfLongestSubstring(String s) {
        if(s ==null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int index = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                index = Math.max(map.remove(cur) +1,index);
            }
            map.put(cur,i);
            maxLength = Math.max(maxLength,i-index+1);
        }


        return maxLength;
    }
}
