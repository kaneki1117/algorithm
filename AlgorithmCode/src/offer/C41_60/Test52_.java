package offer.C41_60;
//此题重要 一定要会  完全掌握思想
public class Test52_ {
    public static void main(String[] args) {
        char[] str = "ade".toCharArray();
        char[] pat = "ab*c*d".toCharArray();
        System.out.println(match(str,pat));
    }

    public static boolean match(char[] str, char[] pattern){
        //两个length
        if(str == null ||  pattern == null ){
            return false;
        }
        return helper(str,pattern,0,0);
    }

    public static boolean helper(char[] str, char[] pattern,int strSt,int pSt){
        if(strSt == str.length && pSt == pattern.length){
            return true;
        }

        if(strSt != str.length && pSt == pattern.length){
            return false;
        }
        if(pSt != pattern.length - 1 && pattern[pSt+1]== '*') {
            if ((strSt != str.length && pattern[pSt] == str[strSt]) || (strSt != str.length && pattern[pSt] == '.')) {
                return helper(str, pattern, strSt, pSt + 2) || helper(str, pattern, strSt + 1, pSt + 2)
                        || helper(str, pattern, strSt + 1, pSt);
            } else {
                return helper(str, pattern,  strSt,pSt + 2);
            }
        }

            if((strSt!= str.length && pattern[pSt] == str[strSt]) || (strSt!= str.length && pattern[pSt] == '.')){
                return helper(str, pattern, strSt+1,pSt+1);
            }

        return false;
    }
}
