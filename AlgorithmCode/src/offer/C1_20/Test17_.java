package offer.C1_20;

import common.TreeNode;

public class Test17_ {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        boolean result = false;
            if(root1.val == root2.val){
                result = check(root1,root2);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        return result;
    }

    //注意此处 node1 node2 的判断顺序。如果颠倒的话 将node1 ==null && node2 == null 的情况看成false了。
    public static boolean check(TreeNode node1,TreeNode node2){
        if(node2 == null){
            return true;
        }
        if(node1 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return check(node1.left,node2.left) && check(node1.right,node2.right);
    }
}
