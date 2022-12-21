package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution509 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
//        return fib1(n);
//        return fib2(n, new int[n + 1]);
        return fib3(n);
    }

    //暴力递归，性能较差
    public int fib1(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //带备忘录的暴力递归，性能好
    public int fib2(int n, int[] memo) {
        if (n <= 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //改成迭代，性能更好
    public int fib3(int n) {
        if (n <= 2) {
            return 1;
        }
        //可以把数组优化为两个值即可
        int res = 0, f1 = 1, f2 = 1;
        for (int i = 3; i <= n; i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
