package src.main.kotlin.leetcode.top100.javaSolution;

import java.util.*;

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
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> digits = new ArrayDeque<>();
        while (l1 != null) {
            digits.addLast(l1.val);
            l1 = l1.next;
        }
        Deque<Integer> digits2 = new ArrayDeque<>();
        while (l2 != null) {
            digits2.addLast(l2.val);
            l2 = l2.next;
        }
        ListNode node = new ListNode();
        ListNode head = node;
        int cary = 0;
        while (!digits2.isEmpty()  && !digits.isEmpty()) {
            System.out.println("digit: "+digits.peek());
            System.out.println("digit2: "+digits2.peek());
            int num = digits.poll()+ digits2.pop() + cary;
            node.next = new ListNode(num % 10);
            node = node.next;
            cary = num / 10;
        }
        while (!digits.isEmpty()) {
            int num = digits.poll() + cary;
            node.next = new ListNode(num % 10);
            node = node.next;
            cary = num / 10;
        }
        while (!digits2.isEmpty()) {
            int num = digits2.poll() + cary;
            node.next = new ListNode(num % 10);
            node = node.next;
            cary = num / 10;
        }
        if (cary > 0) {
            node.next = new ListNode(cary);
        }
        return head.next;
    }
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        int cary = 0;
        while (l1!=null || l2!=null || cary!=0) {
            int digit1= (l1!=null) ? l1.val:0;
            int digit2=(l2!=null) ? l2.val:0;
            int num = digit1+ digit2 + cary;
            node.next = new ListNode(num % 10);
            node = node.next;
            cary = num / 10;
            l1=(l1!=null)?l1.next:null;
            l2=(l2!=null)?l2.next:null;
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
