package offer.C21_40;

import common.TreeNode;
import common.Utils;

import java.util.ArrayList;

public class Test24 {
    public static void main(String[] args) {
        TreeNode root = Utils.generateTree(new String[]{"1","2","3","4","5","3"});
        ArrayList<ArrayList<Integer>> res = FindPath(root,7);
        for(ArrayList<Integer> list : res){
            for (Integer i : list){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        helper(root,target,list,res);
        return res;
    }

    public static void helper(TreeNode root,int target,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res){
        target -= root.val;

        if(target < 0){
                return;
            }
        if(root.left == null && root.right == null &&  target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(root.left !=null){
            list.add(root.left.val);
            helper(root.left,target,list,res);
            list.remove(list.size()-1);
        }
        if(root.right !=null){
            list.add(root.right.val);
            helper(root.right,target,list,res);
            list.remove(list.size()-1);

        }

    }

    /**
     * 参考答案 更加简洁
     * public class Solution {
     *     private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
     *     private ArrayList<Integer> list = new ArrayList<Integer>();
     *     public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
     *         if(root == null) return listAll;
     *         list.add(root.val);
     *         target -= root.val;
     *         if(target == 0 && root.left == null && root.right == null)
     *             listAll.add(new ArrayList<Integer>(list));
     *         FindPath(root.left, target);
     *         FindPath(root.right, target);
     *         list.remove(list.size()-1);
     *         return listAll;
     *     }
     * }
     */

/*
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(root,0,target,new ArrayList<Integer>(),res);
        return res;
    }*/

   /* public static void helper(TreeNode root,int value,int target,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res){

        list.add(root.val);
        value+=root.val;
        if(value > target){
            return;
        }

        if(root.left == null && root.right == null && value == target){
            res.add(new ArrayList<>(list));
            return;
        }

        if(root.left != null){
            list.add(root.left.val);
            helper(root.left,value,target,list,res);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            list.add(root.right.val);
            helper(root.right,value,target,list,res);
            list.remove(list.size()-1);
        }

    }*/
}
