package linkedList;

import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode insertNode(ArrayList<Integer> arr, ListNode head) {
        ListNode temp = head;
        for (int it : arr) {
            temp.next = new ListNode(it);
            temp = temp.next;
        }
        return head;
    }

    public void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
