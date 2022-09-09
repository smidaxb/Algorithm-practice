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
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        //n为这一圈需要调整的组数
        int n = matrix.length - 1;
        while (top < bottom && left < right) {
            rotateCircle(matrix, top, left, bottom, right, n);
            top++;
            left++;
            bottom--;
            right--;
            n -= 2;
        }
    }

    private static void rotateCircle(int[][] matrix, int top, int left, int bottom, int right, int n) {
        for (int i = 0; i < n; i++) {
            int tmp = matrix[top][left + i];
            //上边 == 左边
            matrix[top][left + i] = matrix[bottom - i][left];
            //左边 == 下边
            matrix[bottom - i][left] = matrix[bottom][right - i];
            //下边 == 右边
            matrix[bottom][right - i] = matrix[top + i][right];
            //右边 == 原上边
            matrix[top + i][right] = tmp;
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
