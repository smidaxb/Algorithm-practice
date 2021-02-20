package com.smida.algrithm.book_zuo.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 由两个栈组成队列
 * stackIn和stackOut分别负责入、出队
 * 入队时直接对应stackIn入栈
 * 出队时，若stackOut不为空，则直接出栈；为空则stackIn所有元素出栈再入栈stackOut，再出栈；两栈均空时报错
 */
public class Problem_02_TwoStacksImplementQueue {
    public static class TwoStackQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public TwoStackQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void add(int num) {
            System.out.println(num + " 入队");
            inStack.add(num);
        }

        public Integer poll() {
            if (inStack.isEmpty() && outStack.isEmpty()) {
                System.out.println("队列为空");
                return null;
            }
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    Integer num = inStack.pop();
                    outStack.push(num);
                }
            }
            int res = outStack.pop();
            System.out.println(res + " 出队");
            return res;
        }
    }

    public static void main(String[] args) {
        TwoStackQueue stack2 = new TwoStackQueue();
        stack2.add(1);
        stack2.add(2);
        stack2.add(3);
        stack2.poll();
        stack2.add(4);
        stack2.poll();
        stack2.poll();
        stack2.poll();
        stack2.poll();
    }
}
