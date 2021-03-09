package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

/**
 * 最长递增子序列
 * 如[2 1 5 3 6 4 8 9 7] 返回 [1 3 4 8 9]
 * dp[i]为i位置最大递增子序列长度，dp[0] = 1,dp[i] = max(1,dp[k]+1 dp[k]<dp[i] k<i )
 * 从dp数组中找到最大值，从后往前找递减1的同下标元素，即为子序列
 */
public class Problem_05_LongestIncrSequence {


    //标准答案
    public static int[] lis1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }

    private static int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    private static int[] generateLIS(int[] arr, int[] dp) {
        int maxLen = 0;
        int maxInd = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxInd = i;
            }
        }
        int[] lis = new int[maxLen];
        lis[--maxLen] = arr[maxInd];
        for (int i = maxInd; i >= 0; i--) {
            if (arr[i] < arr[maxInd] && dp[i] == dp[maxInd] - 1) {
                lis[--maxLen] = arr[i];
                maxInd = i;
            }
        }
        return lis;
    }

    //时间复杂度nlogn，没看懂
    public static int[] lis2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp2(arr);
        return generateLIS(arr, dp);
    }

    public static int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
        printArray(arr);
        printArray(lis1(arr));
        printArray(lis2(arr));

    }
}
