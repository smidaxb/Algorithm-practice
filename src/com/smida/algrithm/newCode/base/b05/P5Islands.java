package com.smida.algrithm.newCode.base.b05;

/**
 * 岛问题
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右 四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个 矩阵中有多少个岛?
 * 举例:
 * 001010
 * 111010
 * 100100
 * 000000
 * 这个矩阵中有三个岛。
 * <p>
 * 思路，遍历矩阵，若为1则通过感染函数将其所在整个岛置为2，岛数+1；若为0或2则continue
 */
public class P5Islands {

    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int res = 0;
        int rows = m.length;
        int cols = m[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (m[i][j] == 0 || m[i][j] == 2) {
                    continue;
                } else {
                    tagIsland(m, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void tagIsland(int[][] m, int i, int j) {
        int rows = m.length;
        int cols = m[0].length;
        //越界或者已经标记过，直接返回
        if (i < 0 || i >= rows || j < 0 || j >= cols || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        //标记上下左右
        tagIsland(m, i - 1, j);
        tagIsland(m, i + 1, j);
        tagIsland(m, i, j - 1);
        tagIsland(m, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] m1 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m1));

        int[][] m2 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m2));

    }

}
