package leetcode.c1_100;

import common.ListNode;

//拓展 见C445
public class Test2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            prev.next = newNode;
            prev = prev.next;
        }

        if(carry == 1){
            prev.next = new ListNode(1);
        }

        return dummy.next;
    }
}
