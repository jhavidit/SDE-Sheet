package linkedList;

import java.util.*;

public class crud {
    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void pushAtBeginning(int d) {
        Node temp = new Node(d);
        temp.next = head;
        head = temp;

    }

    public void pushAtEnd(int d) {
        Node newNode = new Node(d);
        Node temp = head;
        if (temp == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
        newNode.next = null;
    }


    public int length() {
        int c = 0;
        Node temp = head;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }

    public void pushAtSpecific(int d, int pos) {

        if (pos <= 0 || pos > length() + 1)
            System.out.println("Invalid position");
        else {
            int i = 1;
            Node temp = head;
            Node prev = null;
            Node newNode = new Node(d);
            while (i < pos) {
                prev = temp;
                temp = temp.next;
                i++;
            }
            if (prev == null) {
                newNode.next = head;
                head = newNode;
            } else {
                prev.next = newNode;
                newNode.next = temp;
            }

        }
    }

    public void deleteAtBegin() {
        if (head == null)
            System.out.println("underflow");
        else {
            Node temp = head;
            head = temp.next;
        }
    }

    public void deleteAtEnd() {
        if (head == null)
            System.out.println("underflow");
        else if (head.next == null)
            head = null;
        else {
            Node temp = head;
            Node prev = null;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }
    }

    public void deleteAtSpecific(int pos) {
        if (pos < 0 || pos > length())
            System.out.println("Invalid position");
        else {
            int i = 1;
            Node temp = head;
            Node prev = null;
            while (i < pos) {
                prev = temp;
                temp = temp.next;
                i++;
            }
            if (prev == null)
                head = head.next;
            else
                prev.next = temp.next;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean search(int d, Node head) {

        if (head==null)
            return false;
        else if(head.data==d)
            return true;
        else
            return search(d, head.next);
    }

    public static void main(String[] args) {
        crud obj = new crud();
        Scanner in = new Scanner(System.in);
        obj.deleteAtBegin();
        obj.pushAtBeginning(2);
        obj.deleteAtBegin();
        obj.pushAtBeginning(3);
        obj.pushAtEnd(8);
        obj.deleteAtEnd();
        obj.pushAtBeginning(5);
        obj.pushAtEnd(6);
        obj.pushAtSpecific(12, 4);
       System.out.println(obj.search(13, obj.head));
        System.out.println(obj.length());

        obj.display();
        in.close();
    }
}
