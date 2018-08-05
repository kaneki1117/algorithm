package offer.C41_60;

import common.TreeLinkNode;
//虽然ac 但在树的右节点的情况没考虑清楚 不够熟练
public class Test57_ {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        TreeLinkNode temp = pNode.right;
        if(temp!=null){
            while (temp.left!=null){
                temp = temp.left;
            }
            return temp;
        }else {
            if(pNode.next == null){
                return null;
            }else if(pNode.next.left == pNode){
                return pNode.next;
            }else{
                while (pNode.next!= null && pNode.next.right == pNode){
                    pNode = pNode.next;
                }
                return pNode.next;
            }
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e
     * 来源：牛客网
     *
     * TreeLinkNode GetNext(TreeLinkNode node)
     *     {
     *         if(node==null) return null;
     *         if(node.right!=null){    //如果有右子树，则找右子树的最左节点
     *             node = node.right;
     *             while(node.left!=null) node = node.left;
     *             return node;
     *         }
     *         while(node.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
     *             if(node.next.left==node) return node.next;
     *             node = node.next;
     *         }
     *         return null;   //退到了根节点仍没找到，则返回null
     *     }
     */
}
