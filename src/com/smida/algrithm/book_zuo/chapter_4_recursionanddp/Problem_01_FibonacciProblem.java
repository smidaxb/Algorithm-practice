package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

/**
 * 斐波那契数列问题fn = fn-1 + fn-2  f1=f2=1
 * 上台阶问题，n阶台阶，每次1步/2步，多少种？fn = fn-1 + fn-2  f1=1,f2=2，基本同斐波那契数列
 * 第一年一头成年牛，每头成年牛每年生一头牛，小牛经过3年成熟，求n年一共多少牛?
 */
public class Problem_01_FibonacciProblem {
    //My
    //斐波那契递归
    public static int fRecursionMy1(int n) {
        if (n <= 2) {
            return 1;
        }
        return fRecursionMy1(n - 1) + fRecursionMy1(n - 2);
    }

    //斐波那契非递归
    public static int fMy1(int n) {
        if (n <= 2) {
            return 1;
        }
        int pre1 = 1;
        int pre2 = 1;
        int cur = 0;
        for (int i = 3; i < n + 1; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }

    //台阶递归
    //My
    public static int sRecursionMy1(int n) {
        if (n <= 2) {
            return n;
        }
        return sRecursionMy1(n - 1) + sRecursionMy1(n - 2);
    }

    //台阶非递归
    public static int sMy1(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        int cur = 0;
        for (int i = 3; i < n + 1; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }

    //进阶台阶，一次可以跨1-n,fn = fn-1 + fn-2 + ... +f1+1
    public static int snMy1(int n) {
        if (n <= 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                arr[i] += arr[j];
            }
        }
        return arr[n];
    }

    //牛头数问题，第n年牛的头数fn等于第n-1年所有本来就有的牛fn-1加上新出生的牛头数（成熟牛头数）fn-3，即fn = fn-1 + fn-3，f1=1，f2=2，f3=3
    public static int cowMy(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3 && n >= 1) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for (int i = 4; i < n + 1; i++) {
            int ns1 = arr[i - 1];
            int ns3 = arr[i - 3];
            arr[i] = ns1 + ns3;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fRecursionMy1(n));
        System.out.println(fMy1(n));
        System.out.println("============================================================");
        System.out.println(sRecursionMy1(n));
        System.out.println(sMy1(n));
        System.out.println(snMy1(n));
        System.out.println("============================================================");
        System.out.println(cowMy(n));
    }
}
