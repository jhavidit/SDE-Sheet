package linkedList;

public class RemoveNthFromEndOfList {

    ListNode delete(ListNode head, int k) {
        ListNode first = head, prev = null;
        ListNode second = head;
        while (k-- > 0) {
            second = second.next;
        }
        while (second != null) {
            prev = first;
            first = first.next;
            second = second.next;
        }
        if (prev != null)
            prev.next = first.next;
        else
            head = head.next;
        return head;
    }
}
