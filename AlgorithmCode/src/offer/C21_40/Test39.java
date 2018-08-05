package offer.C21_40;

import common.TreeNode;

public class Test39 {
    class Result{
        int depth;
        boolean isB;
        public Result(int depth,boolean isB){
            this.depth = depth;
            this.isB = isB;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return helper(root).isB;
    }

    public Result helper(TreeNode root){
        if(root == null) return new Result(0,true);

        Result left = helper(root.left);
        Result right = helper(root.right);
        if(Math.abs(left.depth-right.depth) >1 ){
            return new Result(Math.max(left.depth,right.depth),false);
        }

        if(!left.isB || !right.isB){
            return new Result(Math.max(left.depth,right.depth),false);
        }

        return new Result(Math.max(left.depth,right.depth)+1,true);
    }


    /**
     *简洁版
     *
     * public class Solution {
     *     //后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
     *      
     *     private boolean isBalanced=true;
     *     public boolean IsBalanced_Solution(TreeNode root) {
     *          
     *         getDepth(root);
     *         return isBalanced;
     *     }
     *     public int getDepth(TreeNode root){
     *         if(root==null)
     *             return 0;
     *         int left=getDepth(root.left);
     *         int right=getDepth(root.right);
     *          
     *         if(Math.abs(left-right)>1){
     *             isBalanced=false;
     *         }
     *         return right>left ?right+1:left+1;
     *          
     *     }
     * }
     */
}
