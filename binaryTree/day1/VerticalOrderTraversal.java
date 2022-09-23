package binaryTree.day1;

import java.util.*;

public class VerticalOrderTraversal {
    TreeNode root;

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tuple {
        TreeNode node;
        int x;
        int y;

        public Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm = new TreeMap<>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek().node;
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();
            if (!tm.containsKey(x)) {
                tm.put(x, new TreeMap<>());
            }
            if (!tm.get(x).containsKey(y)) {
                tm.get(x).put(y, new PriorityQueue<>());
            }
            tm.get(x).get(y).add(node.val);
            if (node.left != null) {
                queue.add(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, x + 1, y + 1));
            }
        }
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map : tm.entrySet()) {
            TreeMap<Integer, PriorityQueue<Integer>> val = map.getValue();
            List<Integer> l = new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> map1 : val.entrySet()) {
                PriorityQueue<Integer> pq = map1.getValue();
                while (!pq.isEmpty()) {
                    l.add(pq.poll());
                }
            }
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        VerticalOrderTraversal tree = new VerticalOrderTraversal();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left = new TreeNode(15);
        System.out.println(tree.verticalTraversal(tree.root));
    }


}
