package offer.C41_60;
import common.TreeNode;
//对递归不熟悉 需要多练。

public class Test58_ {
    public static void main(String[] args) {

    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) return true;
        return helper(pRoot.left,pRoot.right);

    }
    public boolean helper(TreeNode left,TreeNode right){
        if(left ==null ) return right == null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }

}
