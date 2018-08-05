package offer.C1_20;

import common.ListNode;

public class Test15 {
    public ListNode ReverseList(ListNode head) {
            if(head == null) return head;
            ListNode cur = head;
            ListNode prev = null;
            while (cur!=null){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            return prev;
    }
}
