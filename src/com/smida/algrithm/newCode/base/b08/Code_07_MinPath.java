package com.smida.algrithm.newCode.base.b08;

public class Code_07_MinPath {
    /**
     * 暴力递归
     * 从左上角出发，加右边或下边路径和中较小的值
     */
    public static int minPath1(int[][] m) {
        return process1(m, 0, 0, 0);
    }

    //代表从i,j点到右下角的最小路径和
    private static int process1(int[][] m, int i, int j, int sum) {
        //走到最后一个位置直接加
        if (i == m.length - 1 && j == m[0].length - 1) {
            return sum + m[i][j];
        }
        //走到最后一行直接加右边点的累加和
        if (i == m.length - 1) {
            return m[i][j] + process1(m, i, j + 1, sum);
        }
        //走到最后一列直接加下边点的累加和
        if (j == m[0].length - 1) {
            return m[i][j] + process1(m, i + 1, j, sum);
        }
        //常规加右边和下边累加和里较小的值
        return m[i][j] + Math.min(process1(m, i, j + 1, sum), process1(m, i + 1, j, sum));
    }

    /**
     * 动态规划
     * 用相同大小矩阵上的每个点代表到该点的最小路径和，可求出第一行和第一列，在推到右下角即可
     */
    public static int minPath2(int[][] m) {
        int rawLen = m.length;
        int colLen = m[0].length;
        int[][] pd = new int[rawLen][colLen];
        //初始化第一行和第一列
        pd[0][0] = m[0][0];
        for (int i = 1; i < rawLen; i++) {
            pd[i][0] = m[i][0] + pd[i - 1][0];
        }
        for (int j = 1; j < colLen; j++) {
            pd[0][j] = m[0][j] + pd[0][j - 1];
        }
        //开始推,此处按行推
        for (int i = 1; i < rawLen; i++) {
            for (int j = 1; j < colLen; j++) {
                pd[i][j] = m[i][j] + Math.min(pd[i - 1][j], pd[i][j - 1]);
            }
        }
        return pd[rawLen - 1][colLen - 1];
    }

    /**
     * 动态规划空间复杂度优化
     * 在得知第一行或第一列后，按行或按列递推即可，此时只用单行或单列即可完成，下边按行
     */
    public static int minPath3(int[][] m) {
        int rawLen = m.length;
        int colLen = m[0].length;
        int[] pd = new int[colLen];
        //初始化第一行
        pd[0] = m[0][0];
        for (int i = 1; i < colLen; i++) {
            pd[i] = m[0][i] + pd[i - 1];
        }
        //开始推,此处按行推
        for (int i = 1; i < rawLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (j == 0) {
                    pd[j] = m[i][j] + pd[j];
                } else {
                    pd[j] = m[i][j] + Math.min(pd[j - 1], pd[j]);
                }
            }
        }
        return pd[colLen - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
        System.out.println(minPath3(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
        System.out.println(minPath3(m));
    }
}
