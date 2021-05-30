package stackqueue;

import java.util.Arrays;

/**
 * Describe how you could use a single array to implement three stacks
 */
class _03_01_ThreeInOne {
    int[] values;
    int[] stackSize;
    int capacity;
    int numberOfStacks = 3;

    _03_01_ThreeInOne(int initSize) {
        values = new int[initSize * numberOfStacks];
        stackSize = new int[numberOfStacks];
        capacity = initSize;
    }

    void push(int stackNum, int val) throws UnsupportedOperationException{

        checkIfFull(stackNum);
        stackSize[stackNum]++;
        values[indexOfTop(stackNum)] = val;
        System.out.println(Arrays.toString(values));
    }

    int pop(int stackNum) throws UnsupportedOperationException {
        // if there are still elements pop
        if (!isEmpty(stackNum)) {
            int res = values[indexOfTop(stackNum)];
            values[indexOfTop(stackNum)] = 0;
            stackSize[stackNum]--;
            return res;
        } else {
            throw new UnsupportedOperationException("Cannot pop empty stack");
        }
    }

    boolean isEmpty(int stackNum){
        return stackSize[stackNum] == 0;
    }

    void checkIfFull(int stackNum) {
        if (stackSize[stackNum] == capacity) {
            throw new UnsupportedOperationException("This stack is already full");
        }
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * capacity;
        int size = stackSize[stackNum];
        return offset + size - 1;
    }


}
