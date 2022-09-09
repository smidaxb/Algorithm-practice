package com.smida.algrithm.newCode.base.b03;

import java.util.LinkedList;

/**
 * 用队列实现栈
 * 用栈实现队列
 *
 * @author YYF
 * @date 2022/9/7 22:43.
 */
public class P3StackQueTrans {

    /**
     * 由两个栈组成队列
     * stackIn和stackOut分别负责入、出队
     * 入队时直接对应stackIn入栈
     * 出队时，若stackOut不为空，则直接出栈；为空则stackIn所有元素出栈再入栈stackOut，再出栈；两栈均空时报错
     * 见类：Problem_02_TwoStacksImplementQueue
     */

    /**
     * 队列实现栈
     * 俩队列，外加一个专门的引用cur表示当前队
     * 入栈：cur入队
     * 出栈：cur中的数据除了队头都出队进另一个队列，cur出队，cur引用到另一个队列
     * peek：cur中的数据除了队头都出队进另一个队列，cur peek
     */
    public static class QueToStack {
        private LinkedList<Integer> que1 = new LinkedList<>();
        private LinkedList<Integer> que2 = new LinkedList<>();
        private LinkedList<Integer> cur = que1;

        public void push(int e) {
            cur.offer(e);
        }

        public int pop() {
            if (cur.isEmpty()) {
                throw new RuntimeException();
            }
            move();
            int res = cur.poll();
            cur = cur.equals(que1) ? que2 : que1;
            return res;
        }

        public int peek() {
            if (cur.isEmpty()) {
                throw new RuntimeException();
            }
            move();
            int res = cur.peek();
            return res;
        }

        private void move() {
            while (cur.size() != 1) {
                if (cur.equals(que1)) {
                    que2.offer(cur.poll());
                } else {
                    que1.offer(cur.poll());
                }
            }
        }
    }

    public static void main(String[] args) {
        QueToStack stack = new QueToStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

    }
}
