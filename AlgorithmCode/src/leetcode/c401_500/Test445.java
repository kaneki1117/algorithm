package leetcode.c401_500;

import common.ListNode;

import java.util.List;
import java.util.Stack;

public class Test445 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;

        Stack<ListNode> left = new Stack<>();
        Stack<ListNode> right = new Stack<>();
        Stack<ListNode> res = new Stack<>();
        while (l1 !=null){
            left.push(l1);
            l1 = l1.next;
        }
        while (l2 !=null){
            right.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        while (!left.empty() || !right.empty()){
            int sum = carry;
            if(!left.empty()){
                sum += left.pop().val;
            }
            if(!right.empty()){
                sum += right.pop().val;
            }
            res.push(new ListNode(sum%10));
            carry = sum/10;

        }
        if(carry == 1){
            res.push(new ListNode(1));
        }
        ListNode start = res.pop();
        ListNode cur = start;
        while(!res.empty()){
            cur.next = res.pop();
            cur = cur.next;
        }
        return start;
    }
}
