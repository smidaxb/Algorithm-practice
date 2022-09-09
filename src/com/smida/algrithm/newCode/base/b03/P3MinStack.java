package com.smida.algrithm.newCode.base.b03;

import java.util.Queue;
import java.util.Timer;

/**
 * 实现特殊栈，基本功能基础上能返回最小值
 * 思路：用俩栈，其中一个存最小值
 *
 * @author YYF
 * @date 2022/9/7 19:15.
 */
public class P3MinStack {
    private P3ArrStackQue.P3Stack stack;
    private P3ArrStackQue.P3Stack minRecord;

    public P3MinStack(int size) {
        this.stack = new P3ArrStackQue.P3Stack(size);
        this.minRecord = new P3ArrStackQue.P3Stack(size);
    }

    public void push(int e){
        this.stack.push(e);
        if (minRecord.isEmpty() || minRecord.peek() >=e) {
            minRecord.push(e);
        }
    }

    public int peek(){
        return stack.peek();
    }

    public int pop(){
        int res = stack.pop();
        if (res == minRecord.peek()) {
            minRecord.pop();
        }
        return res;
    }

    public int getMin() {
        return minRecord.peek();
    }

    public static void main(String[] args) {
        P3MinStack stack = new P3MinStack(4);
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
