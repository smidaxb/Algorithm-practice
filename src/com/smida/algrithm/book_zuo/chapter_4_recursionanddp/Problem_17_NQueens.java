package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

/**
 * n皇后：一个n*n的棋盘，放n个皇后，皇后不能在同一行，同一列，同一斜线
 * <p>
 * 解答：按行增加递归，可避免行冲突
 * 数组record[i]=j代表 第i行的j位置放了皇后
 * 同一斜线即|x-i|=|y-record[i]|
 */
public class Problem_17_NQueens {
    public static void main(String[] args) {
        int n = 8;

        long start = System.currentTimeMillis();
        System.out.println(nQueens(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

    }

    public static int nQueens(int n) {
        if (n < 1) {
            return 0;
        }
        //record[i] = j代表i行j列处放置了一个皇后
        int[] record = new int[n];
        return recursion(record, 0, n);
    }

    private static int recursion(int[] record, int ind, int n) {
        if (n == ind) {
            //如果下标走到了n，说明该次record排列属于符合n皇后，返回1
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            //若ind行，j列可以放置一个皇后，则放进去，下一行
            if (isValid(record, ind, j)) {
                record[ind] = j;
                //此处直接放下一行，所以不会产生行冲突
                res += recursion(record, ind + 1, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int ind, int j) {
        //需考虑ind行之前的所有皇后
        for (int i = 0; i < ind; i++) {
            //列冲突或斜线冲突，返回false
            if (record[i] == j || Math.abs(i - ind) == Math.abs(record[i] - j)) {
                return false;
            }
        }
        return true;
    }
}
