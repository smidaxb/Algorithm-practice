package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

/**
 * 最长公共子序列
 * 两个string，如str1=1a2c3d4b56,str2=b1d23ca45b6a,返回123456或12c4b6
 * 用数组dp[M][N]，dp[i][j]为str1[0~i]和str2[0~j]两字符串的最长公共子序列长度
 * 从左到右，若str1[i]==str2[j]，则dp[i][j]=dp[i-1][j-1]+1，否则取max(dp[i-1][j],dp[i][j-1])
 * 根据dp从右下角往回找，每次找值减1的位置，即可得到子序列
 */
public class Problem_07_LCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "A1BC2D3EFGH45I6JK7LMN";
        String str2 = "12OPQ3RST4U5V6W7XYZ";
        System.out.println(lcse(str1, str2));

    }

    //My
    private static String lcse(String str1, String str2) {
        if (null == str1 || null == str2 || str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        int[][] dp = generateDp(str1, str2);
        return generateLCS(dp, str1);
    }

    private static String generateLCS(int[][] dp, String str1) {
        int m = dp.length;
        int n = dp[0].length;
        int len = dp[m - 1][n - 1];
        if (len < 1) {
            return "";
        }
        char[] chars = new char[len];
        int i = m - 1, j = n - 1;
        while (len > 0) {
            if (i > 0 && dp[i - 1][j] == dp[i][j]) {
                i--;
                continue;
            }
            if (j > 0 && dp[i][j - 1] == dp[i][j]) {
                j--;
                continue;
            }
            chars[--len] = str1.charAt(i);
            i--;
            j--;
        }
        return new String(chars);
    }

    private static int[][] generateDp(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        boolean eq = false;
        //首列和首行
        for (int i = 0; i < m; i++) {
            if (str1Arr[i] == str2Arr[0]) {
                eq = true;
            }
            if (eq) {
                dp[i][0] = 1;
            }
        }
        eq = false;
        for (int j = 0; j < n; j++) {
            if (str1Arr[0] == str2Arr[j]) {
                eq = true;
            }
            if (eq) {
                dp[0][j] = 1;
            }
        }
        //逐行
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (str1Arr[i] == str2Arr[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }
}
