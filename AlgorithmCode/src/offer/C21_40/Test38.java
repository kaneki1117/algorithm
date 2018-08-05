package offer.C21_40;

import common.TreeNode;

public class Test38 {
    public static void main(String[] args) {

    }
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return Math.max(left,right)+1;
    }
}
