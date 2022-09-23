package heap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
      maxHeap.offer(num);
      minHeap.offer(maxHeap.poll());
      if(minHeap.size()>maxHeap.size()){
          maxHeap.offer(minHeap.poll());
      }
    }

    public double findMedian() {
       if(minHeap.size()<maxHeap.size())
           return maxHeap.peek();
       else
           return (double)(maxHeap.peek()+minHeap.peek())/2.0;

    }

}
