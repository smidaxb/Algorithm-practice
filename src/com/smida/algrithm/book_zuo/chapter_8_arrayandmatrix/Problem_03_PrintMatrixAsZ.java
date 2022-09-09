package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 按 Z 型打印数组
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 打印 1 2 5 9 6 3 4 7 10 13 14 11 8 12 15 16
 * <p>
 * 解答：用两个点
 * a从左上走到右上，走到右上了再走到右下，每次走一步；
 * b从左上走到左下，走到左下了再走到右下，每次走一步
 * 只需要打印两个点的斜连线即可，第一次从上打到下，第二次就从下打到上，依次类推
 */
public class Problem_03_PrintMatrixAsZ {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrixAsZ(matrix);
    }

    public static void printMatrixAsZ(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return;
        }
        int aI = 0, aJ = 0;
        int bI = 0, bJ = 0;
        boolean fromUpToDown = false;
        while (aI < matrix.length) {
            printLine(matrix, aI, aJ, bI, bJ, fromUpToDown);
            fromUpToDown = !fromUpToDown;
            //a是先到右边界了再往下，先判断要不要往下走，避免右走一步直接往下，同理，b先判断要不要往右走
            //ai先不变，a走到右上之后，开始往下走
            aI = (aJ == matrix[0].length - 1) ? aI+1 : aI;
            //a没走到右上就往右走，否则aj不变
            aJ = (aJ == matrix[0].length - 1) ? aJ : aJ+1;
            //b先往下走，再往右走
            bJ = (bI == matrix.length - 1) ? bJ+1 : bJ;
            bI = (bI == matrix.length - 1) ? bI : bI+1;
        }
    }

    private static void printLine(int[][] matrix, int aI, int aJ, int bI, int bJ, boolean fromUpToDown) {
        if (fromUpToDown) {
            //从上到下
            while (aI < matrix.length && aJ >= 0) {
                System.out.print(matrix[aI++][aJ--] + " ");
            }
        } else {
            //从下到上
            while (bI >= 0 && bJ < matrix[0].length) {
                System.out.print(matrix[bI--][bJ++] + " ");
            }
        }
    }

}
