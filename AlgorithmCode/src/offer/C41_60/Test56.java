package offer.C41_60;

import common.ListNode;

import java.util.List;

public class Test56 {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) return pHead;

        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode prev = dummy;
        ListNode cur = pHead;
        while (cur != null && cur.next!=null){
            if(cur.val != cur.next.val){
                prev = cur;
                cur = cur.next;
                continue;
            }
            while (cur.next!=null && cur.next.val == cur.val){
                cur = cur.next;
            }
            prev.next = cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
