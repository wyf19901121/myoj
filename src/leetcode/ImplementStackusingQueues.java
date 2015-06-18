package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
    // Push element x onto stack.
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        if (queue2.isEmpty()) {
            queue1.offer(x);
        }
        else {
            queue2.offer(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return ;
        }
        Queue<Integer> emptyQueue;
        Queue<Integer> hasQueue;
        emptyQueue = queue1.isEmpty() ? queue1 : queue2;
        hasQueue = queue1.isEmpty() ? queue2 : queue1;
        while (hasQueue.size() > 1) {
            emptyQueue.offer(hasQueue.poll());
        }
        hasQueue.poll();
    }

    // Get the top element.
    public int top() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return 0;
        }
        Queue<Integer> emptyQueue;
        Queue<Integer> hasQueue;
        emptyQueue = queue1.isEmpty() ? queue1 : queue2;
        hasQueue = queue1.isEmpty() ? queue2 : queue1;
        while (hasQueue.size() > 1) {
            emptyQueue.offer(hasQueue.poll());
        }
        int value = hasQueue.poll();
        emptyQueue.offer(value);
        return value;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
