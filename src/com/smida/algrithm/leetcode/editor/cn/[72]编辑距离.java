package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution72 {
    //dp ij 为单词1 0..i-1 转化为 单词2 0..j-1 时的最少操作数
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        //初始值
        for (int j = 0; j < l2 + 1; j++) {
            //0行为空字符串编辑成w2的次数，只能不断插入操作
            dp[0][j] = j;
        }
        for (int i = 0; i < l1 + 1; i++) {
            //0列类似0行，只能不断删除操作
            dp[i][0] = i;
        }
        //开始递推结果
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                //若 i 和 j的字符相同，则不需要操作，等于 i-1 j-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                //否则，取操作数最小值
                int min = Integer.MAX_VALUE;
                //删除
                min = Math.min(dp[i - 1][j] + 1, min);
                //插入
                min = Math.min(dp[i][j - 1] + 1, min);
                //替换操作，从 i-1 j-1
                min = Math.min(dp[i - 1][j - 1] + 1, min);
                dp[i][j] = min;
            }
        }
        return dp[l1][l2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
