package binaryTree.day1;

import java.util.*;

public class BottomViewOfBinaryTree {
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

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null)
            return arr;
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (!queue.isEmpty()) {
            Node node = queue.peek().node;
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();
            treeMap.put(x, node.data);
            if (node.left != null) {
                queue.add(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, x + 1, y + 1));
            }

        }
        for (Map.Entry<Integer, Integer> map : treeMap.entrySet()) {
            arr.add(map.getValue());
        }
        return arr;
    }

    public static void main(String[] args) {
        BottomViewOfBinaryTree bottomViewOfBinaryTree = new BottomViewOfBinaryTree();
        bottomViewOfBinaryTree.root = new Node(2);
        bottomViewOfBinaryTree.root.left = new Node(3);
        bottomViewOfBinaryTree.root.right = new Node(5);
        System.out.println(bottomViewOfBinaryTree.bottomView(bottomViewOfBinaryTree.root));

    }

}
