package offer.C21_40;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode t = queue.poll();
            res.add(t.val);
            if(t.left!=null){
                queue.offer(t.left);
            }
            if(t.right!=null){
                queue.offer(t.right);
            }
        }

        return res;
    }

}
