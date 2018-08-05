package offer.C1_20;

import common.ListNode;

public class Test14 {
    public static void main(String[] args) {

    }
    public ListNode FindKthToTail(ListNode head, int k) {
        if(k <= 0 || head == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            //注意此处的校验
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
