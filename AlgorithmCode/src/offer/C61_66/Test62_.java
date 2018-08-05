package offer.C61_66;
//基本的非递归思路好掌握 主要难在递归上的写法 更省空间。
import common.TreeNode;

public class Test62_ {
    int count = 0;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot != null){
            TreeNode left = KthNode(pRoot.left,k);
            if(left != null){
                return left;
            }
            count++;
            if(count == k){
                return pRoot;
            }
            TreeNode right = KthNode(pRoot.right,k);
            if(right != null){
                return right;
            }
        }
        return null;
    }
}
