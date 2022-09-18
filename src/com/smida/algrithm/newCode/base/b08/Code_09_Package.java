package com.smida.algrithm.newCode.base.b08;

/**
 * 背包问题
 */
public class Code_09_Package {

    /**
     * 暴力递归
     * 跟打印子序列很像，从第一个数开始，选择包含与不包含，在最后一个物品走完后判断价值
     */
    public static int package1(int[] weights, int[] values, int bag) {
        return process1(weights, values, 0, 0, bag);
    }

    public static int process1(int[] weights, int[] values, int i, int alreadyweight, int bag) {
        if (i == weights.length) {
            return 0;
        }
        if (alreadyweight + weights[i] > bag) {
            return process1(weights, values, i + 1, alreadyweight, bag);
        }
        return Math.max(values[i] + process1(weights, values, i + 1, alreadyweight + weights[i], bag),
                process1(weights, values, i + 1, alreadyweight, bag));
    }


    /**
     * 动态规划思路一
     */
    public static int package2(int[] weight, int[] value, int bag) {
        int[][] dp = new int[weight.length + 1][bag + 1];
        for (int i = weight.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + weight[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], value[i] + dp[i + 1][j + weight[i]]);
                }
            }
        }
        return dp[0][0];
    }

    public static int package2Promote(int[] weight, int[] value, int bag) {
        int itemCount = weight.length;
        int[] dp = new int[bag + 1];
        //初始化最后一行(尾部物品)
        for (int j = 0; j < bag + 1; j++) {
            if (j + weight[itemCount - 1] <= bag) {
                dp[j] = value[itemCount - 1];
            }
        }
        for (int i = itemCount - 2; i >= 0; i--) {
            //这里要倒着来，防止先生成的覆盖上一行
            for (int j = 0; j < bag + 1; j++) {
                if (j + weight[i] <= bag) {
                    dp[j] = Math.max(dp[j], value[i] + dp[j + weight[i]]);
                }
            }
        }
        return dp[0];
    }

    /**
     * 动态规划思路二
     */
    public static int package3(int[] weight, int[] value, int bag) {
        int itemCount = weight.length;
        int[][] dp = new int[itemCount][bag + 1];
        int res = 0;
        for (int i = 0; i < itemCount; i++) {
            for (int j = 0; j < bag + 1; j++) {
                //先生成第一行
                if (i == 0) {
                    if (j >= weight[i]) {
                        dp[i][j] = value[i];
                        res = value[i];
                    }
                    continue;
                }
                if (j >= weight[i]) {
                    //重量够，判断放物品i 和 不放物品i 哪个值大
                    dp[i][j] = Math.max(value[i] + dp[i - 1][j - weight[i]],
                            dp[i - 1][j]);
                } else {
                    //重量不够放，就取上一行的值(不放物品i)
                    dp[i][j] = dp[i - 1][j];
                }
                res = res < dp[i][j] ? dp[i][j] : res;
            }
        }
        p1(dp);
        return res;
    }

    public static int package3Promote(int[] weight, int[] value, int bag) {
        int itemCount = weight.length;
        int[] dp = new int[bag + 1];
        int res = 0;
        for (int i = 0; i < itemCount; i++) {
            //这里要倒着来，防止先生成的覆盖上一行
            for (int j = bag; j >= 0; j--) {
                //先生成第一行
                if (i == 0) {
                    if (j >= weight[i]) {
                        dp[j] = value[i];
                        res = value[i];
                    }
                    continue;
                }
                if (j >= weight[i]) {
                    //重量够，判断放物品i 和 不放物品i 哪个值大
                    dp[j] = Math.max(value[i] + dp[j - weight[i]], dp[j]);
                }
                res = res < dp[j] ? dp[j] : res;
            }
            p2(dp);
        }
        return res;
    }

    public static void p1(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void p2(int dp[]) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] weight = {3, 2, 4, 7};
        int[] value = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(package1(weight, value, bag));

        System.out.println(package2(weight, value, bag));
        System.out.println(package2Promote(weight, value, bag));
        System.out.println(package3(weight, value, bag));
        System.out.println(package3Promote(weight, value, bag));

    }

}
