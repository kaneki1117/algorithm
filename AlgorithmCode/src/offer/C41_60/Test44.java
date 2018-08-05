package offer.C41_60;

public class Test44 {
    public static void main(String[] args) {
        String res = ReverseSentence(" ");
        System.out.println(res);
    }
    public static String ReverseSentence(String str) {
        if(str.length() == 0) return "";
        //注意这条语句进行筛选排除掉 " "等
        if(str.trim().equals("")) return str;
        StringBuilder sb = new StringBuilder();
      String[] string = str.split(" ");
        for (int i = string.length - 1; i >= 0  ; i--) {
            sb.append(string[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
