package com.smida.algrithm.lettcode.tencent50;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class _059GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, left = 0;
        int right = n - 1, bottom = n - 1;
        int k = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = k++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[i][right] = k++;
            }
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    res[bottom][i] = k++;
                }
            }
            if (left < right) {
                for (int i = bottom - 1; i >= top + 1; i--) {
                    res[i][left] = k++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            System.out.print('[');
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.print(']');
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(2);
        printMatrix(res);
    }
}
