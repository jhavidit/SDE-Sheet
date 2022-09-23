package binaryTree.day1;

import java.util.*;

public class LeftViewOfBinaryTree {
    Node root;

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
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

    public ArrayList<Integer> leftView(Node root) {
        if (root == null)
            return new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.peek().node;
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();
            if (!treeMap.containsKey(y))
                treeMap.put(y, node.data);
            if (node.left != null) {
                queue.add(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, x + 1, y + 1));
            }
        }
        return new ArrayList<>(treeMap.values());
    }

}
