package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
       ArrayList<Integer> arr = new ArrayList<>();
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(ArrayList<Integer> temp : kArrays){
           for(int t : temp){
               pq.offer(t);
           }
       }
       while (!pq.isEmpty()){
           arr.add(pq.poll());
       }
       return arr;
    }

}
