package offer.C41_60;

public class Test43 {
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0) return "";
        int len = str.length();
        n = n %len;
        String  str1 = str.substring(0,n);
        String  str2 = str.substring(n);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str1);
        return sb.toString();
    }
}
