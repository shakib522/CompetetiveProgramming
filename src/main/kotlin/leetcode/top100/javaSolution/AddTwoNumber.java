package src.main.kotlin.leetcode.top100.javaSolution;

import java.util.ArrayList;
import java.util.Collections;

public class AddTwoNumber {
}

class SolutionOfAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (l1 != null) {
            digits.add(l1.val);
            l1 = l1.next;
        }
        ArrayList<Integer> digits2 = new ArrayList<>();
        while (l2 != null) {
            digits2.add(l2.val);
            l2 = l2.next;
        }
        Collections.reverse(digits);
        Collections.reverse(digits2);

        System.out.println(digits);
        System.out.println(digits2);

        ListNode node = new ListNode();
        ListNode head = node;
        int i = digits.size() - 1;
        int j = digits2.size() - 1;
        int cary = 0;
        while (i >= 0 && j >= 0) {
            int num = digits.get(i) + digits2.get(j) + cary;
            node.next = new ListNode(num % 10);
            node = node.next;
            i--;
            j--;
            cary = num / 10;
        }
        while (i >= 0) {
            int num = digits.get(i) + cary;
            node.next = new ListNode(num % 10);
            node = node.next;
            i--;
            cary = num / 10;
        }
        while (j >= 0) {
            int num = digits.get(j) + cary;
            node.next = new ListNode(num % 10);
            node = node.next;
            j--;
            cary = num / 10;
        }
        if (cary > 0) {
            System.out.println("Cary:" + cary);
            node.next = new ListNode(cary);
        }
        return head.next;
    }
}


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
