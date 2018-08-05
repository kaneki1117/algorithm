package offer.C41_60;

import common.ListNode;

public class Test55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null) return pHead;
        //记住 slow fast 开始时的处理
        ListNode slow = pHead.next;
        if(slow == null) return null;

        ListNode fast = slow.next;
        while (fast!= null && fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast == null) return null;

        slow = pHead;
        while (fast!= slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
