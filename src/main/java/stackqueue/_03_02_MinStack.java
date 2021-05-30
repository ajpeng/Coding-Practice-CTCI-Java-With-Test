package stackqueue;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
class _03_02_MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack();

    void push(int val) {
        // checking for less than or equal for edge cases for min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.add(val);
        }
        stack.push(val);
    }

    int pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    int min() {
        return minStack.peek();
    }
}
