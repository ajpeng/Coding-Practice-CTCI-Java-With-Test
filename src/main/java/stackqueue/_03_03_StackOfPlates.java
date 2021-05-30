package stackqueue;

import java.util.ArrayList;
import java.util.Stack;

/** Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 composed of several stacks and should create a new stack once the previous one exceeds capacity.
 SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
 (that is, pop () should return the same values as it would if there were just a single stack).
 **/
class _03_03_StackOfPlates {
    ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    int threshold = 0;

    _03_03_StackOfPlates(int threshold) {
        this.threshold = threshold;
    }

    void push(int val) {
        Stack<Integer> stack = getLastStack();
        if (stack.size() + 1 < threshold) {
            stack.push(val);
        } else {
            Stack<Integer> newStack = new Stack<Integer>();
            newStack.push(val);
            stacks.add(newStack);
        }
    }

    int pop(){
        Stack last = getLastStack();
        if (last == null) {
            // do nothing or throw error//
        }
        int result = (int) last.pop();
        if (last.size() == 0) {
            removeEmptyStack();
        }
        return result;
    }

    int popAt(int stackNum) {
        throw new UnsupportedOperationException();
    }

    // helper functions
    private Stack<Integer> getLastStack() {
        if (stacks.size() == 0) {
            Stack<Integer> newStack = new Stack<Integer>();
            stacks.add(newStack);
        }
        return stacks.get(stacks.size() - 1);
    }

    private void removeEmptyStack() {
        stacks.remove(stacks.size() - 1);
    }

}
