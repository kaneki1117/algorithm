package others.tree;


import common.TreeNode;
//if cur 无左孩子 cur右移
//cur 有左孩子 find Mostright节点，mostright 指向空 则指向cur cur左；mostright指向 cur 则指向空 cur右；
public class Test {
    public void Morris(TreeNode node){
        TreeNode cur1 = node;
        while(cur1!=null){
            TreeNode cur2 = cur1.left;
            if(cur2 !=null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }
            cur1 = cur1.right;
        }
    }
}
