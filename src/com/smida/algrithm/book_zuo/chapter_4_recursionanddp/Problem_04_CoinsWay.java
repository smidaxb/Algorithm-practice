package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

import java.util.HashMap;
import java.util.Map;

/**
 * 换钱方法数
 * arr为货币面值数组，aim为要凑出的钱数
 * 问题：不限制每个面值的货币数，求凑出aim的方法一共有几种
 * 解答：
 * 暴力递归：用0-i张arr0凑aim=用 其他张 arrk 凑 aim-（0-i）arr0
 * 递归优化：用map记录 arrk k>? 凑aim-（xxx）arrx 的种类数，避免重复计算
 * 动态规划：O(N*aim*aim)用dp[arr.len][aim+1]，dp[i][j]代表使用arr0-i的面值时，凑齐j的方法数
 * 则 dp[i][0]=1，第一行能凑齐是 1 其他是0
 * dp[i][j] = sum dp[i-1][j-y*arri] y>=0
 * 最后返回 dp[arr.len-1][aim]
 * 动态规划优化1：O(N*aim)
 * dp[i][j] = sum dp[i-1][j-y*arri] y>=0 = dp[i-1][j] + sum dp[i-1][j-arri-k*arri] k>=0 = dp[i-1][j] + dp[i][j-arri]
 * 动态规划优化2：O(N*aim),压缩dp数组为一维数组，空间复杂度为O(aim)
 */
public class Problem_04_CoinsWay {
    //My 暴力递归
    public static int coinsWayMy1(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        //recursion1代表求 用从arr[ind]开始的货币 凑成aim的方法数
        return recursion1(arr, 0, aim);
    }

    private static int recursion1(int[] arr, int ind, int aim) {
        if (ind == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        int counts = 0;
        while (counts * arr[ind] <= aim) {
            res += recursion1(arr, ind + 1, aim - counts * arr[ind]);
            counts++;
        }
        return res;
    }

    //My 暴力递归优化
    public static int coinsWayMy_good1(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        //recursion1代表求 用从arr[ind]开始的货币 凑成aim的方法数
        return recursion2(arr, 0, aim, map);
    }

    private static int recursion2(int[] arr, int ind, int aim, Map<String, Integer> map) {
        int res = 0;
        String key = ind + "_" + aim;
        if (null != map.get(key)) {
            res = map.get(key);
            return res;
        }
        if (ind == arr.length) {
            res = aim == 0 ? 1 : 0;
            map.put(key, res);
            return res;
        }
        int counts = 0;
        while (counts * arr[ind] <= aim) {
            res += recursion2(arr, ind + 1, aim - counts * arr[ind], map);
            counts++;
        }
        map.put(key, res);
        return res;
    }

    //动态规划1
    public static int coinsWayMy_ddp1(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        //第一列
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        //第一行
        for (int j = 1; j <= aim; j++) {
            if (j % arr[0] == 0) {
                dp[0][j] = 1;
            }
        }
        //后边各行
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                int count = 0;
                while (j - count * arr[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - count * arr[i]];
                    count++;
                }
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int coinsWayMy_ddp2(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        //第一列
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        //第一行
        for (int j = 1; j <= aim; j++) {
            if (j % arr[0] == 0) {
                dp[0][j] = 1;
            }
        }
        //后边各行
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j - arr[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
                }
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int coinsWayMy_ddp2_good(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        //第一列
        dp[0] = 1;
        //第一行
        for (int j = 1; j <= aim; j++) {
            if (j % arr[0] == 0) {
                dp[j] = 1;
            }
        }
        //后边各行
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j - arr[i] < 0) {
                    continue;
                }else {
                    dp[j] += dp[j - arr[i]];
                }
            }
        }
        return dp[aim];
    }

    //标准答案
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    public static int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int coins5(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        for (int j = 0; arr[0] * j <= aim; j++) {
            dp[arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }

    public static void main(String[] args) {
        int[] coins = {10, 5, 1, 25};
        int aim = 2000;

        long start = 0;
        long end = 0;
        System.out.println("===========暴力递归的方法===========");
        start = System.currentTimeMillis();
        System.out.println(coins1(coins, aim));
        end = System.currentTimeMillis();
        System.out.println(coinsWayMy1(coins, aim));
        System.out.println("cost time : " + (end - start) + "(ms)");

        aim = 20000;

        System.out.println("===========记忆搜索的方法===========");
        start = System.currentTimeMillis();
        System.out.println(coins2(coins, aim));
        end = System.currentTimeMillis();
//        System.out.println(coinsWayMy_good1(coins, aim));
        System.out.println("cost time : " + (end - start) + "(ms)");

        System.out.println("=====动态规划O(N*(aim^2))的方法=====");
        start = System.currentTimeMillis();
        System.out.println(coins3(coins, aim));
        end = System.currentTimeMillis();
        System.out.println(coinsWayMy_ddp1(coins, aim));
        System.out.println("cost time : " + (end - start) + "(ms)");

        System.out.println("=======动态规划O(N*aim)的方法=======");
        start = System.currentTimeMillis();
        System.out.println(coins4(coins, aim));
        end = System.currentTimeMillis();
        System.out.println(coinsWayMy_ddp2(coins, aim));
        System.out.println("cost time : " + (end - start) + "(ms)");

        System.out.println("====动态规划O(N*aim)的方法+空间压缩===");
        start = System.currentTimeMillis();
        System.out.println(coins5(coins, aim));
        end = System.currentTimeMillis();
        System.out.println(coinsWayMy_ddp2_good(coins, aim));
        System.out.println("cost time : " + (end - start) + "(ms)");

    }
}
