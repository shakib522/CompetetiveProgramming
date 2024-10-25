package src.main.kotlin.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

 class ListNode {
      int val;
     ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }




public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map = new HashMap<>();
        while (headA!=null){
            map.put(headA,headA.val);
            headA=headA.next;
        }
        while (headB!=null){
            if (map.containsKey(headB)){
                return headB;
            }else{
                map.put(headB, headB.val);
            }
            headB=headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        while (a!=b){
            if (a==null && b==null){
                return null;
            }else if (a==null){
                a=headB;
            }else if (b==null){
                b=headA;
            }else{
                a=a.next;
                b=b.next;
            }
        }
        return a;
    }
}
