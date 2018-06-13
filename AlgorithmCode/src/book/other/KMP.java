package book.other;

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
				//����mi = 0 ����һ�����Ѿ���mi ����0�ˡ�
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
