package stackqueue;

import java.util.Stack;

class _03_04_QueueViaStacks {
    Stack<Integer> stackNewest = new Stack<>();
    Stack<Integer> stackOldest = new Stack<>();

    // add item to queue
    void enqueue(int val) {
        stackNewest.add(val);
    }

    int size() {
        return stackNewest.size() + stackOldest.size();
    }

    int peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    int dequeue() {
        shiftStacks();
        return stackOldest.pop();
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }


}
