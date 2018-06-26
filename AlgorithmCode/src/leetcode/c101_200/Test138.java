package leetcode.c101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * public class Solution {
 *     public RandomListNode copyRandomList(RandomListNode head) {
 *         if (head == null) {
 *             return null;
 *         }
 *         HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
 *         RandomListNode dummy = new RandomListNode(0);
 *         RandomListNode pre = dummy, newNode;
 *         while (head != null) {
 *             if (map.containsKey(head)) {
 *                 newNode = map.get(head);
 *             } else {
 *                 newNode = new RandomListNode(head.label);
 *                 map.put(head, newNode);
 *             }
 *             pre.next = newNode;
 *             if (head.random != null) {
 *                 if (map.containsKey(head.random)) {
 *                     newNode.random = map.get(head.random);
 *                 } else {
 *                     newNode.random = new RandomListNode(head.random.label);
 *                     map.put(head.random, newNode.random);
 *                 }
 *             }
 *             pre = newNode;
 *             head = head.next;
 *         }
 *         return dummy.next;
 *     }
 * }
 */
class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 }
public class Test138 {

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy,newNode;
        RandomListNode cur = head;
        Map<RandomListNode,RandomListNode> nodeMap = new HashMap<>();
        while(cur!=null){
            if(nodeMap.containsKey(cur)){
                newNode = new RandomListNode(cur.label);
                nodeMap.put(cur,newNode);
            }else{
                 newNode = nodeMap.get(cur);
            }
            prev.next = newNode;
            if (cur.random != null) {
                 if (nodeMap.containsKey(cur.random)) {
                      newNode.random = nodeMap.get(head.random);
                  } else {
                      newNode.random = new RandomListNode(cur.random.label);
                      nodeMap.put(head.random, newNode.random);
                  }
              }
              prev = newNode;
              cur = cur.next;
        }
        return dummy.next;
    }
}
