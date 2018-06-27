package leetcode.c201_300;

import common.TreeNode;

public class Test222 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        System.out.println(countNodes(node));

    }

    public static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int height = getLevel(root,1);

       return countNodes(root,1,height);
    }

    public static int countNodes(TreeNode root,int level,int height){
        if(level == height){
            return 1;
        }
        //注意此处return需要的括号
        if(getLevel(root.right,level+1) == height){
            return (1<<(height - level)) + countNodes(root.right,level+1,height);
        }else{
            return (1<<(height - level - 1)) + countNodes(root.left,level+1,height);
        }
    }

    public static int getLevel(TreeNode node,int level){
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
