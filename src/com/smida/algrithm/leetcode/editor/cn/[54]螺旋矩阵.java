package com.smida.algrithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution54 {
    //上下左右四个界，按圈移
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int l = 0, u = 0, r = matrix[0].length - 1, d = matrix.length - 1;
        while (l < r && u < d) {
            for (int j = l; j < r; j++) {
                res.add(matrix[u][j]);
            }
            for (int i = u; i < d; i++) {
                res.add(matrix[i][r]);
            }
            if (l == r || u == d) {
                break;
            }
            for (int j = r; j > l; j--) {
                res.add(matrix[d][j]);
            }
            for (int i = d; i > u; i--) {
                res.add(matrix[i][l]);
            }
            l++;
            u++;
            r--;
            d--;
        }
        if (u == d) {
            for (int j = l; j <= r; j++) {
                res.add(matrix[u][j]);
            }
        } else if (l == r) {
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
