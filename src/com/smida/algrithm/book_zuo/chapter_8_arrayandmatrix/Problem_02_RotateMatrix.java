package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 旋转矩阵
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 变成
 * 13 9  5 1
 * 14 10 6 2
 * 15 11 7 3
 * 16 12 8 4
 * 要求空间复杂1
 * 解答：按圈搞，圈内按组搞，比如最外圈，先换1 4 16 13一组，再2 8 15 9...
 */
public class Problem_02_RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("==================转换后=====================");
        printMatrix(matrix);
    }


    public static void rotateMatrix(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return;
        }
        int topI = 0;
        int topJ = 0;
        int bottomI = matrix.length - 1;
        int bottomJ = matrix[0].length - 1;
        //n为这一圈需要调整的组数
        int n = matrix.length - 1;
        while (topI < bottomI && topJ < bottomJ) {
            rotateCircle(matrix, topI, topJ, bottomI, bottomJ, n);
            topI++;
            topJ++;
            bottomI--;
            bottomJ--;
            n -= 2;
        }
    }

    private static void rotateCircle(int[][] matrix, int topI, int topJ, int bottomI, int bottomJ, int n) {
        for (int i = 0; i < n; i++) {
            int tmp = matrix[topI][topJ + i];
            matrix[topI][topJ + i] = matrix[bottomI - i][topJ];
            matrix[bottomI - i][topJ] = matrix[bottomI][bottomJ - i];
            matrix[bottomI][bottomJ - i] = matrix[topI + i][bottomJ];
            matrix[topI + i][bottomJ] = tmp;
        }
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
