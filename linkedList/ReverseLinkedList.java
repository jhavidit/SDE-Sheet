package linkedList;

public class ReverseLinkedList {


    // iterative solution
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    //recursive solution
    public ListNode recursiveReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursiveReverse(head.next);
        ListNode headNext = head.next;
        headNext.next = head; //next node will be connected to current node
        head.next = null; // current node will be connected to prev
        return newHead; // will always return the tail node
    }

}
