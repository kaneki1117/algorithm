package offer.C1_20;

import common.ListNode;

public class Test16 {
    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }

        while (list1!=null){
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        while (list2!=null){
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
