package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution516 {
    //对子序列问题，dp[i][j]有两种思路
    //1.涉及两个字符串/数组时（比如最长公共子序列），dp 数组的含义如下：
    //在子数组arr1[0..i]和子数组arr2[0..j]中，我们要求的子序列（最长公共子序列）长度为dp[i][j]。
    //2.只涉及一个字符串/数组时（比如本文要讲的最长回文子序列），dp 数组的含义如下：
    //在子数组array[i..j]中，我们要求的子序列（最长回文子序列）的长度为dp[i][j]。
    //此题用第二种思路
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        //当i和j相等时，回文肯定为1，当i>j时，下限i到上限j的字符串不存在，回文子序列长度为0
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
            for (int j = dp.length - 1; j > i; j--) {
                dp[i][j] = 0;
            }
        }
        //i往左走,上一个阶段是i+1，j往右走，上一个阶段是j-1
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                //若相等，回文长度则为上一个阶段+2
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else {//若不等,回文长度为包括i 或 包括j两种情况中回文子串较大值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
