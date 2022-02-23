package linkedList;

public class AddTwoNumberAsLinkedList {

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode temp = null;
        ListNode head = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int data = l1.val + l2.val + carry;

            carry = data / 10;
            data = data % 10;

            if (temp == null) {
                temp = new ListNode(data);
                head = temp;
            } else {
                temp.next = new ListNode(data);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
            System.out.println(carry);
        }
        while (l1 != null) {
            int data = l1.val + carry;
            carry = data / 10;
            data = data % 10;

            if (temp == null) {
                temp = new ListNode(data);
                head = temp;
            } else {
                temp.next = new ListNode(data);
                temp = temp.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int data = l2.val + carry;
            carry = data / 10;
            data = data % 10;

            if (temp == null) {
                temp = new ListNode(data);
                head = temp;
            } else {
                temp.next = new ListNode(data);
                temp = temp.next;
            }
            l2 = l2.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
            carry = 0;
        }
        return head;
    }
}
