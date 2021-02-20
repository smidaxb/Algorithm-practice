package com.smida.algrithm.book_zuo.chapter_1_stackandqueue;

import java.util.Objects;
import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 用两个栈实现
 * numStack负责正常的数据入、出栈
 * minStack记录当前栈内最小数据，当新入栈元素小于等于栈顶元素入栈;当出栈元素等于栈顶元素时出栈
 */
public class Problem_01_GetMinStack {
    public static class MinNumStack {
        private Stack<Integer> numStack;
        private Stack<Integer> minStack;

        private MinNumStack() {
            numStack = new Stack<>();
            minStack = new Stack<>();
        }

        private void push(int num) {
            System.out.println(num + " 入栈");
            numStack.push(num);
            if (minStack.isEmpty() || minStack.peek() >= num) {
                minStack.push(num);
            }
        }

        private int pop() {
            int res = numStack.pop();
            if (Objects.equals(minStack.peek(), res)) {
                minStack.pop();
            }
            System.out.println(res + " 出栈");
            return res;
        }

        private Integer getMin() {
            if (minStack.isEmpty()) {
                System.out.println("栈已空");
                return null;
            }
            System.out.println("最小值：" + minStack.peek());
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinNumStack minNumStack = new MinNumStack();
        minNumStack.push(2);
        minNumStack.getMin();
        minNumStack.push(1);
        minNumStack.getMin();
        minNumStack.push(3);
        minNumStack.getMin();
        minNumStack.push(5);
        minNumStack.getMin();
        minNumStack.pop();
        minNumStack.getMin();
        minNumStack.pop();
        minNumStack.getMin();
        minNumStack.pop();
        minNumStack.getMin();
        minNumStack.pop();
        minNumStack.getMin();
    }
}
