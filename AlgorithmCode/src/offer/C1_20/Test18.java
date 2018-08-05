package offer.C1_20;

import common.TreeNode;

public class Test18 {
    public static void main(String[] args) {

    }

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

}
