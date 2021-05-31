package stackqueue;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack,
 * but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
class _03_05_SortStack {

    Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> r = new Stack<>();
        while (!stack.isEmpty()) {
            // insert each element of unsort stack into r
            int temp = stack.pop();
            while (!r.isEmpty() && r.peek() > temp) {
                stack.push(r.pop());
            }
            r.push(temp);
        }

        //
        while (!r.isEmpty()) {
            stack.push(r.pop());
        }
        return stack;
    }
}
