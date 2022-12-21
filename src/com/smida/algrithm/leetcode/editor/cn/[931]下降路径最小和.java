package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution931 {
    //dp[i][j] 代表走到这一点时最小的下降路径和的值，则取上一行三个路径的最小值即可算出
    public int minFallingPathSum1(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        //初始化第一行路径和
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = matrix[0][j];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //找到上方三个dp的最小值
                int val = dp[i - 1][j];
                if (j - 1 >= 0) {
                    val = Math.min(val, dp[i - 1][j - 1]);
                }
                if (j + 1 < matrix[0].length) {
                    val = Math.min(val, dp[i - 1][j + 1]);
                }
                dp[i][j] = val + matrix[i][j];
                //走到最后一行时开始判断结果
                if (i == matrix.length - 1) {
                    res = Math.min(dp[i][j], res);
                }
            }
        }
        return res == Integer.MAX_VALUE ? dp[0][0] : res;
    }


    //用两行数组做dp即可，节省空间
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[2][matrix[0].length];
        //pre存上一行，cur存本行
        int pre = 0;
        int cur = 1;
        for (int j = 0; j < matrix[0].length; j++) {
            dp[pre][j] = matrix[0][j];
            dp[cur][j] = matrix[0][j];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //找到上方三个dp的最小值
                int val = dp[pre][j];
                if (j - 1 >= 0) {
                    val = Math.min(val, dp[pre][j - 1]);
                }
                if (j + 1 < matrix[0].length) {
                    val = Math.min(val, dp[pre][j + 1]);
                }
                dp[cur][j] = val + matrix[i][j];
                //走到最后一行时开始判断结果
                if (i == matrix.length - 1) {
                    res = Math.min(dp[cur][j], res);
                }
            }
            //切换cur和pre
            int tmp = cur;
            cur = pre;
            pre = tmp;
        }
        return res == Integer.MAX_VALUE ? dp[cur][0] : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
