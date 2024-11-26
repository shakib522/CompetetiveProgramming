package src.main.kotlin.leetcode.neetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode result = ans;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ans.next = new ListNode(list1.val);
                list1 = list1.next;
                ans = ans.next;
            } else {
                ans.next = new ListNode(list2.val);
                list2 = list2.next;
                ans = ans.next;
            }
        }
        if (list1!=null){
            ans.next=list1;
        }else {
            ans.next=list2;
        }
        return result.next;
    }
}
