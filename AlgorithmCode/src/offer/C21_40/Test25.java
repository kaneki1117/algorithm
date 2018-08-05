package offer.C21_40;

import common.RandomListNode;
import common.Utils;

public class Test25 {
    public static void main(String[] args) {
        RandomListNode head = Utils.genRandomLists(new int[]{1,2,3,4,5,6});
        System.out.println(Clone(head).val);
    }

    public static RandomListNode Clone(RandomListNode pHead){
        if(pHead == null) return pHead;
        copyNext(pHead);
        copyRandom(pHead);
        return splitList(pHead);
    }

    public static void copyNext(RandomListNode node){
        RandomListNode temp = node;
        while(node!= null){
            RandomListNode newNode = new RandomListNode(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = node.next.next;
        }

    }

    public static void copyRandom(RandomListNode node){
        while (node!= null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }

    public static RandomListNode splitList(RandomListNode node){
        RandomListNode res = node.next;
        while (node!=null&&node.next != null){
            RandomListNode temp = node.next;
            node.next = node.next.next;
            node = temp;
        }

        return res;
    }
}
