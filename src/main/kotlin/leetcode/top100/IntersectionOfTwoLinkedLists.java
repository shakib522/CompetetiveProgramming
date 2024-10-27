package src.main.kotlin.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

 class ListNodes {
      int val;
     ListNodes next;
     ListNodes(int x) {
          val = x;
          next = null;
      }
  }




public class IntersectionOfTwoLinkedLists {
    public ListNodes getIntersectionNode(ListNodes headA, ListNodes headB) {
        Map<ListNodes,Integer> map = new HashMap<>();
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

    public ListNodes getIntersectionNode2(ListNodes headA, ListNodes headB) {
        ListNodes a=headA;
        ListNodes b=headB;
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
