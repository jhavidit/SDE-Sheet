package stackAndQueue.day1;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    Queue<Integer> queue;

    public ImplementStackUsingQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        while (!queue.isEmpty()) {
            temp.add(queue.poll());
        }
        queue.add(x);
        while (!temp.isEmpty()) {
            queue.add(temp.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}

class ImplementStackUsingSingleQueue {

    Queue<Integer> queue;

    public ImplementStackUsingSingleQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i=0;i<queue.size()-1;i++){
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}

