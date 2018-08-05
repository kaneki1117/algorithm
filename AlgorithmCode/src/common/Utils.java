package common;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    // 有一点问题。
    public static TreeNode generateTree(String[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].equals("#")){
                if(isLeft){
                    list.get(index).left = null;
                }else{
                    list.get(index).right = null;
                }
                continue;
            }
            TreeNode temp;
            if(isLeft){
                temp = new TreeNode(Integer.parseInt(arr[i]));
                list.get(index).left = temp;
            }else{
                temp = new TreeNode(Integer.parseInt(arr[i]));
                list.get(index).right = temp;
            }
            list.add(temp);
            isLeft =!isLeft;
            if(i%2 == 0) index++;
        }

        return root;
    }


    public static ListNode genLists(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode res = head;
        for (int i = 1; i < array.length ; i++) {
            head.next = new ListNode(array[i]);
            head = head.next;
        }
        return res;
    }

    public static RandomListNode genRandomLists(int[] array){
        RandomListNode head = new RandomListNode(array[0]);
        RandomListNode res = head;
        for (int i = 1; i < array.length ; i++) {
            head.next = new RandomListNode(array[i]);
            head = head.next;
        }
        return res;
    }
}
