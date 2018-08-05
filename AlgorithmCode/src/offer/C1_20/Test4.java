package offer.C1_20;

import common.TreeNode;

public class Test4 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre == null || in == null || pre.length != in.length){
            return null;
        }
        return helper(pre,in,0,0,pre.length-1);
    }

    public TreeNode helper(int[] pre, int[] in, int stPre,int stIn, int endIn){
        if(stIn > endIn){
            return null;
        }
        TreeNode node = new TreeNode(pre[stPre]);
        int j = stIn;
        for (; j <=endIn; j++) {
            if(in[j] == node.val){
                break;
            }
        }
        node.left = helper(pre,in,stPre+1,stIn,j-1);
        //注意此时的下标.
        node.right = helper(pre,in,stPre+j-stIn+1,j+1,endIn);

        return node;
    }
}
