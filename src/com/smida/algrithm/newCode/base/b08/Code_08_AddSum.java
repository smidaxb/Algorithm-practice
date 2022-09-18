package com.smida.algrithm.newCode.base.b08;

public class Code_08_AddSum {

    /**
     * 暴力递归
     * 跟打印子序列很像，从第一个数开始，选择包含与不包含，在最后一个数走完后判断true or false
     */
    public static boolean addSum1(int[] arr, int aim) {
        return process1(arr, 0, aim, 0);
    }

    private static boolean process1(int[] arr, int ind, int aim, int sum) {
        //走到最后直接判断
        if (ind == arr.length) {
            return sum == aim;
        }
        //没走到最后，判断加本数/不加本数两个路径
        return process1(arr, ind + 1, aim, 0) || process1(arr, ind + 1, aim, sum + arr[ind]);
    }


    /**
     * 动态规划
     * 矩阵大小 arrLen,aim+1，行下标代表第几个数，列代表上一步的累加和，
     * m[x][aim]肯定是true，最后一行除了aim列全为false, 从最后一行向上推
     * 列下标减去当前行数字值的列会为ture(代表加上这个数后为ture)
     * 为true的列上边肯定也为true(代表不加上边这个数)
     * 递推看0,0的值
     */
    public static boolean addSum2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length][aim + 1];
        //初始化
        for (int i = 0; i < arr.length; i++) {
            dp[i][aim] = true;
        }
        //倒推
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < aim+1; j++) {
                //不为ture的点不用考虑
                if (dp[i][j] != true) {
                    continue;
                }
                //减去当前值仍在数组中的话，将该点及其上方均标记true
                int addInd = j - arr[i];
                if (addInd >= 0) {
                    for (int k = i; k >= 0; k--) {
                        dp[k][addInd] = true;
                    }
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 动态规划空间优化
     */
    public static boolean addSum3(int[] arr, int aim) {
        boolean[] dp = new boolean[aim + 1];
        //初始化
        dp[aim] = true;
        //倒推
        for (int i = arr.length - 1; i >= 0; i--) {
            //这里要倒着来，防止先生成的覆盖上一行
            for (int j = 0; j < aim+1; j++) {
                //不为ture的点不用考虑
                if (dp[j] != true) {
                    continue;
                }
                //减去当前值仍在数组中的话，将该点标记true
                //等效于
                int addInd = j - arr[i];
                if (addInd >= 0) {
                    dp[addInd] = true;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8};
        int aim = 12;
        System.out.println(addSum1(arr, aim));
        System.out.println(addSum2(arr, aim));
        System.out.println(addSum3(arr, aim));
    }

}
