package offer.C21_40;

import common.ListNode;

public class Test36 {
    public static void main(String[] args) {

    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        int len1 = 1;
        int len2 = 1;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1.next!=null){
            p1 = p1.next;
            len1++;
        }
        while (p2.next!=null){
            p2 = p2.next;
            len2++;
        }

        if(len1 > len2){
            int dis = len1 - len2;
            for (int i = 0; i < dis; i++) {
                pHead1 = pHead1.next;
            }
        }else{
            int dis = len2 - len1;
            for (int i = 0; i < dis; i++) {
                pHead2 = pHead2.next;
            }
        }

        while (pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;
    }
}
