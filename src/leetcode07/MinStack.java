package leetcode07;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    //这里辅助栈push的一直是栈内最小值
    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

