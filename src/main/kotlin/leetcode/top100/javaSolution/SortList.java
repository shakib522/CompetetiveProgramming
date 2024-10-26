package src.main.kotlin.leetcode.top100.javaSolution;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortList {

    public ListNode mid(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        if (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeSort(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur=dummy;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if (l1!=null){
            cur.next=l1;
        }else{
            cur.next=l2;
        }
        return dummy.next;

    }
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode mid=mid(head);
        ListNode newNode=mid.next;
        mid.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(newNode);
        return mergeSort(left,right);
    }
    public ListNode sortList2(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode temp=head;
        List<Integer> list = new ArrayList<>();
        while (temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(list);
        temp=head;
        int i=0;
        while (temp!=null){
            temp.val=list.get(i++);
            temp=temp.next;
        }
        return head;
    }
    public ListNode sortList3(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        int [] arr = new int[count];
        temp = head;
        count = 0;
        while(temp!=null){
            arr[count++] = temp.val;
            temp=temp.next;
        }
        Arrays.sort(arr);
        temp = head;
        count=0;
        while(temp!=null){
            temp.val = arr[count++];
            temp = temp.next;
        }
        return head;
    }
}
