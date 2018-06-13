package book.other;

public class Manacher {

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(findLongestPalidrome(str1));
		String str2 = "abcd123321";
		System.out.println(makeitPalidrome(str2));
	}
	
	public static int findLongestPalidrome(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		String string = genManaString(str);
		int[] pArray = new int[string.length()];
		int pR = -1;
		int index = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < pArray.length; i++) {
			//注意此处pArray下2index-i而不是直接的
			pArray[i] = pR>i?Math.min(pArray[2*index-i], pR-i):1;
			while(i- pArray[i] > -1 && i + pArray[i] < pArray.length) {
				if(string.charAt(i- pArray[i]) == string.charAt(i+pArray[i])) {
					pArray[i]++;
				}else {
					break;
				}	
			}
			
			if(i+pArray[i] > pR){
				pR = i+ pArray[i];
				index = i;
			}
			//注意max的改变条件 pR -i
			max = Math.max(max, pR - i);
		}
		
		return max-1;
	}
	
	public static String makeitPalidrome(String str) {
		if(str == null || str.length() == 0) {
			return "";
		}
		
		String string = genManaString(str);
		int[] pArray = new int[string.length()];
		int pR = -1;
		int index = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < pArray.length; i++) {
			pArray[i] = pR>i?Math.min(pArray[2*index-i], pR-i):1;
			while(i- pArray[i] > -1 && i + pArray[i] < pArray.length) {
				if(string.charAt(i- pArray[i]) == string.charAt(i+pArray[i])) {
					pArray[i]++;
				}else {
					break;
				}	
			}
			if(i+pArray[i] == pArray.length) {
				max = pArray[i] ;
				break;
			}
			
			
			if(i+pArray[i] > pR){
				pR = i+ pArray[i];
				index = i;
			}

		}
		
		StringBuilder sb = new StringBuilder();
		//注意此处是str。length 而不是 pArray，length
		for (int j = 0; j < str.length() - max + 1; j++) {
			sb.append(string.charAt(2*j+1)+"");
		}
		
		return sb.reverse().toString();
	}
	
	public static String genManaString(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i)+"");
			sb.append("#");
		}
		return sb.toString();
	}
}
