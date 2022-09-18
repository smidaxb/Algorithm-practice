package com.smida.algrithm.newCode.base.b08;

public class Code_02_Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "左", "右", "中");
        }
    }


    /**
     * 1
     * 2
     * ...
     * n
     * 左 中 右
     * 只剩一个，直接移
     * 否则把n-1个移到 中 ,把 n 移到 右, 再把n-1个移到 右
     */
    public static void func(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("move " + 1 + " from " + from + " to " + to);
        } else {
            func(n - 1, from, help, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            func(n - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

}
