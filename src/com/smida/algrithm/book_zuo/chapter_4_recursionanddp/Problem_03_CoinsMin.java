package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

/**
 * 换钱的最少货币数
 * arr为货币面值数组，aim为要凑出的钱数
 * <p>
 * 问题：不限制每个面值的货币数，求最少张数，凑不齐返回-1
 * 解答：用数组dp[arr.len][aim+1],dp[i][j]表示用arr 0-i 面值的货币凑齐 j 钱数所需最小张数
 * 则dp[i][0]为0，dp[0][j]取值要么是arr0的倍数j/arr0，要么设为无限大
 * dp[i][j] = min(dp[i-1][j-y*arri]+y y>=0) = min(0张：dp[i-1][j] , y张：dp[i-1][j-y*arri]+y y>=1)
 * min dp[i-1][j-y*arri]+y y>=1 = min dp[i-1][j-arri - k*arri]+k+1 k>=0 = dp[i][j-arri]+1
 * 即dp[i][j] = min (dp[i-1][j] , dp[i][j-arri]+1)
 * 走到最后返回dp[arr.len-1][aim] , 无限大返回-1
 * 优化：只用dp[aim+1]即可，第一遍同dp[i][0]，之后按行从左到右更新即可
 * <p>
 * 问题2：限制每种面值只能用一次，求最少张数，凑不齐返回-1
 * 解答：用数组dp[arri.len][aim+1],dp[i][j]表示用arr 0-i 面值的货币凑齐 j 钱数所需最小张数
 * 则dp[0][arr0]可取值为arr0的一倍1，其他设为无限大
 * 同理dp[i][arri]可取值为1，dp[i][j] = dp[i][j-arri]+1或无限大
 * 走到最后返回dp[arr.len-1][aim] ,无限大返回-1
 * 优化：只用dp[aim+1]即可，第一遍同dp[i][0]，之后按行从左到右更新即可
 */
public class Problem_03_CoinsMin {
    //My
    public static int minCoinsMy1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int arrLen = arr.length;
        int MAX = Integer.MAX_VALUE;
        int[][] dp = new int[arrLen][aim + 1];
        //第一列均为0
        //第一行
        for (int j = 1; j <= aim; j++) {
            if (j % arr[0] == 0) {
                dp[0][j] = j / arr[0];
            } else {
                dp[0][j] = MAX;
            }
        }
        //其他各行
        for (int i = 1; i < arrLen; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j - arr[i] < 0 || dp[i][j - arr[i]] == MAX) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - arr[i]] + 1);
                }
            }
        }
        return dp[arrLen - 1][aim] == MAX ? -1 : dp[arrLen - 1][aim];
    }

    public static int minCoinsMy1_good(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int arrLen = arr.length;
        int MAX = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        //第一列为0
        //第一行
        for (int j = 1; j <= aim; j++) {
            if (j % arr[0] == 0) {
                dp[j] = j / arr[0];
            } else {
                dp[j] = MAX;
            }
        }
        //其他各行
        for (int i = 1; i < arrLen; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j - arr[i] < 0 || dp[j - arr[i]] == MAX) {
                    continue;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        return dp[aim] == MAX ? -1 : dp[aim];
    }

    public static int minCoinsMy2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int arrLen = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[arrLen][aim + 1];
        //第一列为0
        //第一行
        for (int j = 1; j <= aim; j++) {
            if (j == arr[0]) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = max;
            }
        }
        //其他各行
        for (int i = 1; i < arrLen; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j - arr[i] < 0 || dp[i][j - arr[i]] == max) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - arr[i]] + 1);
                }
            }
        }
        return dp[arrLen - 1][aim] == max ? -1 : dp[arrLen - 1][aim];
    }

    public static int minCoinsMy2_good(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int arrLen = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        //第一列为0
        //第一行
        for (int j = 1; j <= aim; j++) {
            if (j == arr[0]) {
                dp[j] = 1;
            } else {
                dp[j] = max;
            }
        }
        //其他各行
        for (int i = 1; i < arrLen; i++) {
            for (int j = 1; j <= aim; j++) {
                if (j - arr[i] < 0 || dp[j - arr[i]] == max) {
                    continue;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        return dp[aim] == max ? -1 : dp[aim];
    }

    //标准答案
    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }

    public static int minCoins1_good(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[j] = max;
            if (j - arr[0] >= 0 && dp[j - arr[0]] != max) {
                dp[j] = dp[j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }

    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
        }
        if (arr[0] <= aim) {
            dp[0][arr[0]] = 1;
        }
        int leftup = 0; // 左上角某个位置的值
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                leftup = max;
                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
                    leftup = dp[i - 1][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(leftup, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }

    public static int minCoins2_good(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[j] = max;
        }
        if (arr[0] <= aim) {
            dp[arr[0]] = 1;
        }
        int leftup = 0; // 左上角某个位置的值
        for (int i = 1; i < n; i++) {
            for (int j = aim; j > 0; j--) {
                leftup = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    leftup = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(leftup, dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {100, 20, 5, 10, 2, 50, 1};
        int aim1 = 17019;
        System.out.println(minCoins1(arr1, aim1));
        System.out.println(minCoinsMy1(arr1, aim1));
        System.out.println(minCoins1_good(arr1, aim1));
        System.out.println(minCoinsMy1_good(arr1, aim1));

        int[] arr2 = {10, 100, 2, 5, 5, 5, 10, 1, 1, 1, 2, 100};
        int aim2 = 223;
        System.out.println(minCoins2(arr2, aim2));
        System.out.println(minCoinsMy2(arr2, aim2));
        System.out.println(minCoins2_good(arr2, aim2));
        System.out.println(minCoinsMy2_good(arr2, aim2));

    }
}
