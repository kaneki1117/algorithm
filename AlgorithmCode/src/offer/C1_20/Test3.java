package offer.C1_20;

import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;
//碰到改变方向的应该先考虑到栈。运行时间：21ms
//reverse链表方法 20ms
public class Test3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode == null) return result;
        ListNode cur = listNode;
        Stack<Integer> stack = new Stack<>();
        while (cur!= null){
            stack.push(cur.val);
            cur = cur.next;
        }
        while (!stack.empty()){
            result.add(stack.pop());
        }
        return result;
    }


//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> result = new ArrayList<>();
//        ListNode rever = reverse(listNode);
//        ListNode cur = rever;
//        while (cur != null){
//            result.add(cur.val);
//            cur = cur.next;
//        }
//        reverse(rever);
//        return result;
//    }
//
//
//    public ListNode reverse(ListNode node){
//        ListNode prev = null;
//        ListNode cur = node;
//        while (cur!= null){
//            ListNode temp = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = temp;
//        }
//
//        return prev;
//    }
}
