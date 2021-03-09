package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

/**
 * 最长公共子串
 * 两个string，如str1=1ab2345cd,str2=12345ef,返回2345
 * 用数组dp[M][N]，dp[i][j]为str1[0~i]和str2[0~j]两字符串的最长公共子串长度
 * 从左到右，若str1[i]==str2[j]，则dp[i][j]=dp[i-1][j-1]+1，否则取0
 * 根据dp从最大值往回斜左上找，即可得到子序列
 *
 * 优化：可直接斜右下依次找，可使空间复杂度为1
 */
public class Problem_08_LCommonSubstr {
    public static void main(String[] args) {
        String str1 = "ABC1234567DEFG";
        String str2 = "HIJKL1234567MNOP";
        System.out.println(lcsu(str1, str2));

    }

    //My
    private static String lcsu(String str1, String str2) {
        if (null == str1 || null == str2 || str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        int[][] dp = generateDp(str1, str2);
        return generateLCS(dp, str1);
    }

    private static String generateLCS(int[][] dp, String str1) {
        int m = dp.length;
        int n = dp[0].length;
        int maxi = 0,maxj = 0;
        int len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > dp[maxi][maxj]) {
                    maxi = i;
                    maxj = j;
                    len = dp[i][j];
                }
            }
        }
        if (len < 1) {
            return "";
        }
        char[] chars = new char[len];
        int i = maxi;
        while (len > 0) {
            chars[--len] = str1.charAt(i);
            i--;
        }
        return new String(chars);
    }

    private static int[][] generateDp(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        //首列和首行
        for (int i = 0; i < m; i++) {
            if (str1Arr[i] == str2Arr[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (str1Arr[0] == str2Arr[j]) {
                dp[0][j] = 1;
            }
        }
        //逐行
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (str1Arr[i] == str2Arr[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }
}
