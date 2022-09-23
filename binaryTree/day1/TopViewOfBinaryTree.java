package binaryTree.day1;

import java.util.*;

public class TopViewOfBinaryTree {
    Node root;

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Tuple {
        Node node;
        int x;
        int y;

        Tuple(Node node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<Integer> topViewOfBinaryTree(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.peek().node;
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();
            if (!tm.containsKey(x))
                tm.put(x, node.data);


            if (node.left != null) {
                queue.add(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, x + 1, y + 1));
            }
        }
            for (Map.Entry<Integer, Integer> map1 : tm.entrySet()) {

                list.add(map1.getValue());
            }

        return list;
    }

    public static void main(String[] args) {
        TopViewOfBinaryTree tree = new TopViewOfBinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.right = new Node(7);
        tree.root.right.left = new Node(15);
        System.out.println(tree.topViewOfBinaryTree(tree.root));
    }

}
