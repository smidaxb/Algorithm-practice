package com.smida.algrithm;

import java.util.Objects;
import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 用两个栈实现
 * numStack负责正常的数据入、出栈
 * minStack记录当前栈内最小数据，当新入栈元素小于等于栈顶元素入栈;当出栈元素等于栈顶元素时出栈
 */
public class Stack1 {
    private Stack<Integer> numStack;
    private Stack<Integer> minStack;

    private Stack1() {
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
        if (minStack.isEmpty()){
            System.out.println("栈已空");
            return null;
        }
        System.out.println("最小值：" + minStack.peek());
        return minStack.peek();
    }

    public static void main(String[] args) {
        Stack1 stack1 = new Stack1();
        stack1.push(2);
        stack1.getMin();
        stack1.push(1);
        stack1.getMin();
        stack1.push(3);
        stack1.getMin();
        stack1.push(5);
        stack1.getMin();
        stack1.pop();
        stack1.getMin();
        stack1.pop();
        stack1.getMin();
        stack1.pop();
        stack1.getMin();
        stack1.pop();
        stack1.getMin();
    }
}
