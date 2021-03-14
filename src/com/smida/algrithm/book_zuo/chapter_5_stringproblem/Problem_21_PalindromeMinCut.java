package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 切成回文字符串最少切几次
 * aba 切0次
 * acdcdcdad 切成 a cdcdc dad 切3次
 */
public class Problem_21_PalindromeMinCut {

    //My

    public static int minCutMy(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] arr = str.toCharArray();
        //cut[i]代表从str[i~len-1]要切几次
        //d[i][j]代表str[i~j]是不是回文字符串
        int[] cut = new int[str.length() + 1];
        cut[str.length()] = -1;//0==cut[len-1],cut[len-1]=cut[len]+1,则cut[len]=-1
        boolean[][] d = new boolean[str.length()][str.length()];
        for (int i = arr.length - 1; i >= 0; i--) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                //当arr[i]等于arr[j]，且i==j或者i+1==j或确认str[i+1~j-1]为回文时
                if (arr[i] == arr[j] && (j - i < 2 || d[i + 1][j - 1])) {
                    d[i][j] = true;
                    cut[i] = Math.min(cut[i], cut[j + 1] + 1);
                }
            }
        }
        return cut[0];
    }


    //standard
    public static int minCut(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int len = chas.length;
        int[] dp = new int[len + 1];
        dp[len] = -1;
        boolean[][] p = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (chas[i] == chas[j] && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    // for test
    public static String getRandomStringOnlyAToD(int len) {
        int range = 'D' - 'A' + 1;
        char[] charArr = new char[(int) (Math.random() * (len + 1))];
        for (int i = 0; i != charArr.length; i++) {
            charArr[i] = (char) ((int) (Math.random() * range) + 'A');
        }
        return String.valueOf(charArr);
    }

    public static void main(String[] args) {
        int maxLen = 10;
        int testTimes = 5;
        String str = null;
        for (int i = 0; i != testTimes; i++) {
            str = getRandomStringOnlyAToD(maxLen);
            System.out.print("\"" + str + "\"" + " : ");
            System.out.print(minCut(str));
            System.out.println("  " + minCutMy(str));
        }

    }
}
