package com.smida.algrithm.book_zuo.chapter_1_stackandqueue;

import java.util.Stack;

/**
 * 用栈实现汉诺塔，移动必须经过中间
 */
public class Problem_06_HanoiStack {

    public static int hanoiProblem1(int num, String left, String mid,
                                    String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    //递归
    public static int process(int num, String left, String mid, String right,
                              String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static enum Action {
        No, LToM, MToL, MToR, RToM
    }

    //非递归
    public static int hanoiProblem2(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<Integer>();
        Stack<Integer> mS = new Stack<Integer>();
        Stack<Integer> rS = new Stack<Integer>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != num + 1) {
            step += fStackTotStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record, Action preNoAct,
                                     Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack,
                                     String from, String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    //基本汉诺塔
    public static void normalHanoi(int num, String from, String to, String tmp) {
        if (num == 1) {
            System.out.println(num + " " + from + " to " + to);
            return;
        }
        normalHanoi(num - 1, from, tmp, to);
        System.out.println(num + " " + from + " to " + to);
        normalHanoi(num - 1, tmp, to, from);
    }

    public static void main(String[] args) {
    	normalHanoi(1,"left","right","mid");
		System.out.println("==================================");
		normalHanoi(2,"left","right","mid");
		System.out.println("==================================");
		normalHanoi(3,"left","right","mid");
		System.out.println("==================================");
//        int num = 4;
//
//        // solution 1
//        int steps1 = hanoiProblem1(num, "left", "mid", "right");
//        System.out.println("It will move " + steps1 + " steps.");
//        System.out.println("===================================");
//
//        // solution 2
//        int steps2 = hanoiProblem2(num, "left", "mid", "right");
//        System.out.println("It will move " + steps2 + " steps.");
//        System.out.println("===================================");

    }

}