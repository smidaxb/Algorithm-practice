package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int l = 0, u = 0, r = matrix[0].length - 1, d = matrix.length - 1;
        int count = 1;
        while (l < r && u < d) {
            for (int j = l; j < r; j++) {
                matrix[u][j] = count++;
            }
            for (int i = u; i < d; i++) {
                matrix[i][r] = count++;
            }
            if (l == r || u == d) {
                break;
            }
            for (int j = r; j > l; j--) {
                matrix[d][j] = count++;
            }
            for (int i = d; i > u; i--) {
                matrix[i][l] = count++;
            }
            l++;
            u++;
            r--;
            d--;
        }
        if (u == d) {
            for (int j = l; j <= r; j++) {
                matrix[u][j] = count++;
            }
        } else if (l == r) {
            for (int i = u; i <= d; i++) {
                matrix[i][r] = count++;
            }
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
