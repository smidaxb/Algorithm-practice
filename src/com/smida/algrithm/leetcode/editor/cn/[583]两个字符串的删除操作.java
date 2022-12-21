package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution583 {
    // 定义：s1[0..i-1] 和 s2[0..j-1] 的 minDistance 次数为 dp[i][j]
    // 目标：s1[0..m-1] 和 s2[0..n-1] 的 minDistance 次数，即 dp[m][n]
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                //相等的话，不用删除操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    //不相等，则两个字符至少要删一个
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
