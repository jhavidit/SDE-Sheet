package heap;

import jdk.nashorn.internal.objects.annotations.SpecializedFunction;

import java.util.*;

public class MaxSumCombination {

    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.sort(a);
        Collections.sort(b);
        PriorityQueue<PairSum> pq = new PriorityQueue<>();
        int l = n - 1;
        int m = n - 1;
        HashSet<Pair> set = new HashSet<>();
        pq.add(new PairSum( l, m,a.get(l) + b.get(m)));
        set.add(new Pair(l, m));
        for (int i = 0; i < k; i++) {
            PairSum max = pq.poll();
            arr.add(max.sum);
            l = max.l - 1;
            m = max.m;

            if (l >= 0 && m >= 0 && !set.contains(new Pair(l, m))) {
                pq.add(new PairSum( l, m,a.get(l) + b.get(m)));
                set.add(new Pair(l, m));
            }

            l = max.l;
            m = max.m - 1;

            if (l >= 0 && m >= 0 && !set.contains(new Pair(l, m))) {
                pq.add(new PairSum( l, m,a.get(l) + b.get(m)));
                set.add(new Pair(l, m));
            }


        }
        return arr;
    }

    static class Pair {
        int l;
        int m;

        Pair(int l, int m) {
            this.l = l;
            this.m = m;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return l == pair.l && m == pair.m;
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, m);
        }
    }

    static class PairSum implements Comparable<PairSum>{
        int l;
        int m;
        int sum;

        PairSum(int l, int m, int sum) {
            this.l = l;
            this.m = m;
            this.sum = sum;
        }

        @Override
        public int compareTo(PairSum o) {
            return Integer.compare(o.sum,sum);
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(6);
        b.add(4);
        b.add(2);
        System.out.println(kMaxSumCombination(a,b,a.size(),2));

    }

}
