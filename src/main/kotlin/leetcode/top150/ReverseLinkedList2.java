package src.main.kotlin.leetcode.top150;


import java.util.Stack;

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

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftPointer=head;
        for (int i = 1; i < left; i++) {
            leftPointer=leftPointer.next;
        }
        ListNode rightPointer=leftPointer;
        Stack<Integer> st = new Stack<>();

        for (int i = left; i <= right; i++) {
            st.push(rightPointer.val);
            rightPointer=rightPointer.next;
        }
        for (int i = left; i <= right; i++) {
            leftPointer.val=st.pop();
            leftPointer=leftPointer.next;
        }
        return head;
    }
}
