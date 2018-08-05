package offer.C21_40;

import java.util.ArrayList;
import java.util.Arrays;
//类似的题目 有 使立方体的8个顶点的，每个相对的面上4个顶点相等。全排列后去除掉不符合的。
//n皇后问题
public class Test27 {
    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> res = Permutation(s);
        for(String str : res){
            System.out.println(str);
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0 ) return res;
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        boolean[] visit = new boolean[arr.length];
        help(arr,visit,new StringBuilder(),res);
        return res;
    }


    public static void help(char[] arr,boolean[] visit,StringBuilder sb, ArrayList<String> res ){
        if(sb.length() == arr.length){
            res.add(sb.toString());
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            if(visit[i] == true || (i > 0&&arr[i] == arr[i-1] && visit[i-1]== false)){
                continue;
            }
            sb.append(arr[i]);
            visit[i] = true;
            help(arr,visit,sb,res);
            visit[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }


    /**
     * 思路是进行交换，可以节省空间
     * 链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7
     * 来源：牛客网
     *
     * public ArrayList<String> Permutation(String str) {
     *         List<String> res = new ArrayList<>();
     *         if (str != null && str.length() > 0) {
     *             PermutationHelper(str.toCharArray(), 0, res);
     *             Collections.sort(res);
     *         }
     *         return (ArrayList)res;
     *     }
     *  
     *     public void PermutationHelper(char[] cs, int i, List<String> list) {
     *         if (i == cs.length - 1) {
     *             String val = String.valueOf(cs);
     *             if (!list.contains(val))
     *                 list.add(val);
     *         } else {
     *             for (int j = i; j < cs.length; j++) {
     *                 swap(cs, i, j);
     *                 PermutationHelper(cs, i+1, list);
     *                 swap(cs, i, j);
     *             }
     *         }
     *     }
     *  
     *     public void swap(char[] cs, int i, int j) {
     *         char temp = cs[i];
     *         cs[i] = cs[j];
     *         cs[j] = temp;
     *     }
     */
}
