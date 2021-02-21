package com.smida.algrithm.book_zuo.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序（顶到底从大到小）
 * 辅助栈需从小到大，逐个插入排序即可，用递归
 */
public class Problem_05_StackSortStack {
    private Stack<Integer> tmp;

    public Problem_05_StackSortStack() {
        tmp = new Stack<>();
    }

    public void sort(Stack<Integer> stack) {
        if (null == stack || stack.isEmpty()) {
            throw new RuntimeException("");
        }
        while (!stack.isEmpty()) {
            Integer num = stack.pop();
            putMaxToEnd(tmp, num);
        }
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    private void putMaxToEnd(Stack<Integer> tmp, Integer num) {
        if (tmp.isEmpty()) {
            tmp.push(num);
            return;
        }
        Integer top = tmp.peek();
        if (num >= top) {
            tmp.pop();
            putMaxToEnd(tmp, num);
            tmp.push(top);
        } else {
            tmp.push(num);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(2);
        s.push(0);
        s.push(9);
        System.out.println(s);
        new Problem_05_StackSortStack().sort(s);
        System.out.println(s);
    }

    /**
     * 标准答案
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
