package offer.C41_60;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Test60 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                list.add(p.val);
                if(p.left != null){
                    queue.offer(p.left);
                }
                if(p.right != null){
                    queue.offer(p.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
