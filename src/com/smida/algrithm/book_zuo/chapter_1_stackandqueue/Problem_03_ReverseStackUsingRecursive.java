package com.smida.algrithm.book_zuo.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 仅用递归和栈操作逆序一个栈
 * 递归一：获取并移除栈底元素，|1,2,3   --->> |2,3
 * 递归二：逆序栈，|1,2,3 --->> 1  |2,3 --->> 1  2 |3 --->> 1 2 3 |--->>1 2 |3 --->>1 |3,2 --->> |3,2,1
 */
public class Problem_03_ReverseStackUsingRecursive {
    public static class ReverseStack{
        private Stack<Integer> numStack;

        public ReverseStack(Stack<Integer> numStack) {
            this.numStack = numStack;
        }

        //获取并移除栈底元素
        public Integer getLastAndRemove(Stack<Integer> numStack){
            if (numStack.isEmpty()) {
                System.out.println("栈为空");
                return null;
            }
            int top = numStack.pop();
            if (numStack.isEmpty()) {
                return top;
            }else {
                Integer last = getLastAndRemove(numStack);
                numStack.push(top);
                return last;
            }
        }
        //反转
        public void reverseStack(Stack numStack){
            if (numStack.isEmpty()){
                return;
            }
            Integer last = getLastAndRemove(numStack);
            reverseStack(numStack);
            numStack.push(last);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println("after reverse");
        ReverseStack reverseStack = new ReverseStack(new Stack<>());
        reverseStack.reverseStack(stack);
        System.out.println(stack);
    }
}
