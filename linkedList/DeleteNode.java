package linkedList;

public class DeleteNode {

    public void deleteNode(ListNode t) { // deletion in O(1) time and space complexity
        if(t==null)
            return;
        t.val = t.next.val;
        t.next = t.next.next;
    }
}
