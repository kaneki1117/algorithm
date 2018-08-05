package offer.C61_66;

import apple.laf.JRSUIUtils;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test61 {
    public static void main(String[] args) {
    }

    public TreeNode Deserialize(String str) {
        if(str.length() == 0 ) return null;
        String[] res = str.substring(1,str.length()-1).split(",");
        boolean sign = false;
        int index = 0;
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(res[0]));
        list.add(root);
        boolean left = true;
        for (int i = 1; i < res.length; i++) {
            if(!res[i].equals("#")){
                TreeNode newNode = new TreeNode(Integer.parseInt(res[i]));
                list.add(newNode);
                if(left){
                    list.get(index).left = newNode;
                }else {
                    list.get(index).right = newNode;
                }
            }/*考虑到其实不需要此也可。
            else{
                if(left){
                    list.get(index).left = null;
                }else {
                    list.get(index).right = null;
                }
            }*/
            left = !left;
            if(i%2 ==0) index++;
        }
        return root;
    }


    public String Serialize(TreeNode root) {
        if(root == null){
            return  "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node);
            if(node != null){
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        while (list.get(list.size()-1) == null){
            list.remove(list.size()-1);
        }

        StringBuilder res = new StringBuilder();
        res.append("{");
        for (int i = 0; i < list.size(); i++) {
            TreeNode temp = list.get(i);
            if(temp != null){
                res.append(temp.val+",");
            }else {
                res.append("#,");
            }
        }
        res.deleteCharAt(res.length()-1);
        res.append("}");
        return res.toString();
    }


}
