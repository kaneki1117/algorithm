package others.expMatch;

/**
 * 个人写的字符串匹配，*等于 0个或者多个字符，与前面的字符是什么无关。。结果不正确 但是可以借鉴思路。
 * 1.如果p[j] ！=‘*’那么 m[i][j] = m[i-1][j-1]&&(p[j-1]==s[i-1]);
 * 2。如果p[j]=='*' 那么  m[i][j] = m[k][j-1]||m[k-1][j-1] 其中k为 1到i-1
 */
public class ExpMatch {
    public static boolean match(char[] p, char[] s) {
        boolean[][] m = new boolean[128][128];
        m[0][0] = true;

        int pl = p.length;
        int sl = s.length;
        if (pl > sl) {
            return false;
        }
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (p[j - 1] == '*') {
                    boolean mac = false;
                    for (int k = i - 1; k >= 0; k--) {
                        mac = mac || m[k][j - 1];
                        if (mac) {
                            break;
                        }
                    }
                    m[i][j] = mac;
                } else {
                    m[i][j] = m[i - 1][j - 1] && (p[j - 1] == s[i - 1]);
                }

            }
        }
        return m[sl][pl];
    }

    public static void main(String[] args) {
        String s = "abcde";
        String p = "a*cd*";
        System.out.println(match(p.toCharArray(), s.toCharArray()));
    }
}
