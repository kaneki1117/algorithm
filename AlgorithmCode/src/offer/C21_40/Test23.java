package offer.C21_40;
//已ac 但不是很熟练.
//个人思路是：从前面找到第一个大于根节点的 从而分出树的左右子树 再依次递归。注意边界条件
public class Test23 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return helper(sequence,0,sequence.length -1);

    }

    public static boolean helper(int[] sequence ,int start,int end){
        if(start >= end) return true;
        int temp = sequence[end];
        int i =  start;
        //注意这两处是小于而不是 小于等于. 否则会报栈溢出
        for (; i < end; i++) {
            if(sequence[i] > temp){
                break;
            }
        }
        for (int j = i; j <end; j++) {
            if(sequence[j] < temp){
                return false;
            }
        }
        //end-1 而不是end
        return helper(sequence,start,i-1)&& helper(sequence,i,end-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,3,2,5};
        boolean b = VerifySquenceOfBST(arr);
        System.out.println(b);
    }
}
