package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution48 {
    public void rotate(int[][] matrix) {
        rotate2(matrix);
    }

    //思路一：上下左右四个界，按圈移
    public void rotate1(int[][] matrix) {
        int l = 0, t = 0, r = matrix.length - 1, b = r;
        while (l < r) {
            int len = r - l;
            for (int i = 0; i < len; i++) {
                int tmp = matrix[t][l + i];
                matrix[t][l + i] = matrix[b - i][l];
                matrix[b - i][l] = matrix[b][r - i];
                matrix[b][r - i] = matrix[t + i][r];
                matrix[t + i][r] = tmp;
            }
            l++;
            t++;
            r--;
            b--;
        }
    }

    //思路二：先按对角线反转，再按左右对角线反转
    public void rotate2(int[][] matrix) {
        //对角线反转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j);
            }
        }

        //左右中轴线反转
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            for (int i = 0; i < matrix.length; i++) {
                int tmp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = tmp;
            }
            l++;
            r--;
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
