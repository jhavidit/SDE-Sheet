package interview;

public class LinkedList {

    Node head;

    static class Node {
        Node next;
        int data;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }
    }

    public void display(Node head) {
        while (head != null) {
            System.out.print(head.data + "   ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        obj.display(head);
    }

}
