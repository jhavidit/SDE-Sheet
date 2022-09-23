package linkedList;

public class MergeKSortedList {

    static class ListNode {
        ListNode next;
        int val;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.next = next;
            this.val = val;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = null;
        for (ListNode list : lists) {
            temp = merge(temp, list);
        }
        return temp;

    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                temp.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1 != null) {
            temp.next = new ListNode(head1.val);
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = new ListNode(head2.val);
            head2 = head2.next;
            temp = temp.next;
        }
        return head.next;
    }

}
