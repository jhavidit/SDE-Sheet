package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PopulatingNextPointer {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (prev != null)
                    prev.next = node;

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null) {
                    queue.add(node.right);
                }
                prev = node;
            }
        }
        return root;
    }

}
