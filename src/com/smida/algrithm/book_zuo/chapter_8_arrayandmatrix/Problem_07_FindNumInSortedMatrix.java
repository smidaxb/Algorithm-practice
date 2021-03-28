package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 在上下左右都排好序的矩阵里，判断数字是否在阵中
 * <p>
 * 从右上角找，相等就返回true，比要找的数大就往左，比要找的数小就往下，过界返回false
 */
public class Problem_07_FindNumInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 3, 4, 5, 6},// 0
                {10, 12, 13, 15, 16, 17, 18},// 1
                {23, 24, 25, 26, 27, 28, 29},// 2
                {44, 45, 46, 47, 48, 49, 50},// 3
                {65, 66, 67, 68, 69, 70, 71},// 4
                {96, 97, 98, 99, 100, 111, 122},// 5
                {166, 176, 186, 187, 190, 195, 200},// 6
                {233, 243, 321, 341, 356, 370, 380} // 7
        };
        int K = 233;
        System.out.println(isContains(matrix, K));
        System.out.println(isContains(matrix, 201));
    }

    private static boolean isContains(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rowInd = 0;
        int colInd = matrix[0].length - 1;
        while (colInd >= 0 && rowInd < matrix.length) {
            if (matrix[rowInd][colInd] == k) {
                return true;
            }
            if (matrix[rowInd][colInd] > k) {
                colInd--;
                continue;
            } else {
                rowInd++;
            }
        }
        return false;
    }
}
