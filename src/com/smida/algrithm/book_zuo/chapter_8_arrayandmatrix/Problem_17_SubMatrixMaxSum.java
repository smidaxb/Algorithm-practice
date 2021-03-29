package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 求子矩阵最大累加和
 * <p>
 * matrix：
 * -90,48,78
 * 64,-40,64
 * -81,-7,66
 * 最大累加和子矩阵为
 * 48,78
 * -40,64
 * -7,66
 * 返回累加和 209
 * <p>
 * 解析：
 * 1、(可得出包含1、12、123行的累加和)
 * 先第一行，按数组算累加和
 * 再加上第二行，按数组算累加和
 * 再加上第三行，按数组算累加和
 * 2、(可得出包含2、23行的累加和)
 * 先第二行，按按数组算累加和
 * 再加上第三行，按数组算累加和
 * 3、(可得出包含3行的累加和)
 * 第三行，按数组算累加和
 */
public class Problem_17_SubMatrixMaxSum {
    public static void main(String[] args) {
        int[][] matrix = {{-90, 48, 78}, {64, -40, 64}, {-81, -7, 66}};
        System.out.println(maxSum(matrix));
        System.out.println(maxSumMy(matrix));
    }

    /**
     * my
     */
    public static int maxSumMy(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return 0;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = new int[colLen];
            for (int rowInd = i; rowInd < rowLen; rowInd++) {
                int colInd = 0;
                while (colInd < colLen) {
                    arr[colInd] += matrix[rowInd][colInd];
                    colInd++;
                }
                max = Math.max(max, maxSumArr(arr));
            }
        }
        return max;
    }

    private static int maxSumArr(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int cur = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur > max) {
                max = cur;
            }
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }

    /**
     * 标准答案
     */
    public static int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for (int i = 0; i != m.length; i++) {
            s = new int[m[0].length];
            for (int j = i; j != m.length; j++) {
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }
}
