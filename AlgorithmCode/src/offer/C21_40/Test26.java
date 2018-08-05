package offer.C21_40;

import common.TreeNode;
import common.Utils;

import java.util.Stack;

public class Test26 {
    public static void main(String[] args) {
        TreeNode node = Utils.generateTree(new String[]{"1","2","4","5","6"});
        TreeNode newHead = Convert(node);
        while (newHead.right!=null){
        System.out.println(newHead.val);
        newHead = newHead.right;
        }
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return pRootOfTree;
        TreeNode root = pRootOfTree;
        Stack<TreeNode> stack = new Stack<>();
        boolean first = true;
        TreeNode p = root;
        while (!stack.empty() || p != null){

            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            TreeNode temp = stack.pop();
            p =temp;
            if(first){
                pRootOfTree = temp;
                first = false;
            }else {
                root.right = temp;
                temp.left = root;
            }
            root = temp;
            p = p.right;
        }

        return pRootOfTree;
    }
}
