package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution712 {
    // 类似583
    // 定义：s1[0..i-1] 和 s2[0..j-1] 的 最小删除和为 dp[i][j]
    // 目标：s1[0..m-1] 和 s2[0..n-1] 的 最小删除和，即 dp[m][n]
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = dp[0][j-1] + s2.charAt(j - 1);
        }
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i - 1);
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                //相等的话，不用删除操作
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //不相等，则两个字符至少要删一个
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1),
                            dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
