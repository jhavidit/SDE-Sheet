package heap;

import java.util.*;

public class KMostFrequentElement {

        public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int it : nums) {
            if (!map.containsKey(it)) {
                map.put(it, 1);
            } else
                map.put(it, map.get(it) + 1);
        }
        //   System.out.println(map);
        PriorityQueue<Pair> treeMap = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> val : map.entrySet()) {
            treeMap.offer(new Pair(val.getValue(), val.getKey()));
        }
        //  System.out.println(treeMap);
        int[] arr = new int[k];
        System.out.println(treeMap);
        for (int i = 0; i < k; i++) {
            arr[i] = treeMap.remove().j;
        }
        return arr;
    }

    static class Pair implements Comparable<Pair> {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.i, i);
        }
    }

    public static void main(String[] args) {
        KMostFrequentElement obj = new KMostFrequentElement();
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(obj.topKFrequent(arr, 2)));
    }

}
