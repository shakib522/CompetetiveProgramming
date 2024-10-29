package src.main.kotlin.leetcode.top150;

import java.util.HashSet;

public class RemoveDuplicateFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        HashSet<Integer> set = new HashSet<>();
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                set.add(cur.val);
            }
            cur = cur.next;
        }
        cur = head;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        if (set.contains(head.val)) {
            head = head.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = new ListNode(0);
        prev.next=head;
        ListNode dummy = prev;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
