package book.other;

//KMP算法的两个应用场景：1、只能在后面添加字母，求使得一个字符串出现两次需要添加字符串最小长度。
// 如:abcabc 要使其变成 abcabcabc，这样原abcabc就出现了两次。主要应用next数组的思想，next数组增加一项next计算整个字符串的最大匹配前后缀。
//2.树的子结构问题。。 可以通过将树进行序列化之后 利用KMP进行字符串匹配判断。

public class KMP {

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str,match));
	}
	
	public static int getIndexOf(String str,String match) {
		int si = 0 ;
		int mi = 0;
		
		int[] next = genNextArray(match);
		
		while( si < str.length() && mi < match.length()) {
			if(str.charAt(si) == match.charAt(mi)) {
				si++;
				mi++;
			}else if(next[mi]!= -1) {
				mi = next[mi];
			}else {
				si++;
			}
		}
		
		return mi == match.length()? si -mi : -1;
	}
	
	
	public static int[] genNextArray(String match) {
		if(match.length() <= 1) return new int[] {-1};
		int[] next = new int[match.length()];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while(pos < match.length()) {
			if(match.charAt(pos-1) == match.charAt(cn)) {
				next[pos++] = ++cn;
			}else if(next[cn] > 0) {
				cn = next[cn];
			}else {
				next[pos++] = 0;
			}
		}
		return next;
	}
}
