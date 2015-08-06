package leetcode;

import java.util.Stack;

public class ImplementQueueusingStacks {
    // Push element x to the back of queue.
	Stack<Integer> tail = new Stack<Integer>();
	Stack<Integer> head = new Stack<Integer>();
    public void push(int x) {
    	tail.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (head.isEmpty()) {
        	while (!tail.isEmpty()) {
				head.push(tail.pop());
			}
		}
        if (!head.isEmpty()) {
			head.pop();
		}
    }

    // Get the front element.
    public int peek() {
        if (head.isEmpty()) {
        	while (!tail.isEmpty()) {
				head.push(tail.pop());
			}
		}
        if (!head.isEmpty()) {
			return head.peek();
		}
        return 0;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }
}
