package linkedList;

public class MergeSortedLinkedList {

    public ListNode mergeTwoListsNoExtraSpace(ListNode list1, ListNode list2) {
        if (list2 == null)
            return list1;
        if (list1 == null)
            return list2; // if any list is empty return other list
        if (list1.val > list2.val) { // make list1 the list with smaller head
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode prev = null;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                prev = temp1;
                temp1 = temp1.next;
            } else {
                prev.next = temp2;  // connect list2 node to list1
                ListNode temp = temp2;
                temp2 = temp2.next; // move forward
                temp.next = temp1;
                prev = temp; // update previous
            }
        }
        if (temp2 != null) {
            prev.next = temp2; // add remaining node to list1
        }


        return list1;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { // like merge sort merge method
        ListNode head;
        ListNode l3;
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val <= l2.val) {
                head = new ListNode(l1.val, null);
                l1 = l1.next;
            } else {
                head = new ListNode(l2.val, null);
                l2 = l2.next;
            }
            l3 = head;
            l3.next = null;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    l3.next = new ListNode(l1.val, null);
                    l3 = l3.next;
                    l1 = l1.next;
                } else {
                    l3.next = new ListNode(l2.val, null);
                    l3 = l3.next;
                    l2 = l2.next;
                }
            }
            if (l2 == null) {
                l3.next = l1;
            }
            if (l1 == null) {
                l3.next = l2;

            }
            return head;
        }
    }


}
