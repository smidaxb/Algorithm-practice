package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 转圈打印矩阵
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 打印 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * <p>
 * 解答：左上右下两个点，按圈打印，一圈走完缩小
 */
public class Problem_01_PrintMatrixCircleOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        circleOrderPrint(matrix);
    }

    public static void circleOrderPrint(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return;
        }
        int topI = 0;
        int topJ = 0;
        int bottomI = matrix.length - 1;
        int bottomJ = matrix[0].length - 1;
        while (topI <= bottomI && topJ <= bottomJ) {
            printOneCircle(matrix, topI, topJ, bottomI, bottomJ);
            topI++;
            topJ++;
            bottomI--;
            bottomJ--;
        }
    }

    private static void printOneCircle(int[][] matrix, int topI, int topJ, int bottomI, int bottomJ) {
        if (topI == bottomI) {
            while (topJ <= bottomJ) {
                System.out.print(matrix[topI][topJ++] + " ");
            }
            return;
        }
        if (topJ == bottomJ) {
            while (topI <= bottomI) {
                System.out.print(matrix[topI++][topJ] + " ");
            }
            return;
        }
        int i=topI,j=topJ;
        //从左到右
        while (j < bottomJ) {
            System.out.print(matrix[i][j++] + " ");
        }
        //从上到下
        while (i < bottomI) {
            System.out.print(matrix[i++][j] + " ");
        }
        //从右到左
        while (j > topJ) {
            System.out.print(matrix[i][j--] + " ");
        }
        //从下到上
        while (i > topI) {
            System.out.print(matrix[i--][j] + " ");
        }
    }
}
