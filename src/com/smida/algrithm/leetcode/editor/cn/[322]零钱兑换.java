package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution322 {
    public int coinChange(int[] coins, int amount) {
//        memos = new int[amount + 1];
//        return coinChange1(coins, amount);
//        return coinChange2(coins, amount);=
        return coinChange3(coins, amount);
    }

    //暴力递归
    public int coinChange1(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            //先算子问题，子问题无解，continue
            int subRes = coinChange1(coins, amount - coin);
            if (subRes == -1) {
                continue;
            }
            //比较当前用最少硬币数
            res = Math.min(res, 1 + subRes);
        }
        if (Integer.MAX_VALUE == res) {
            return -1;
        }
        return res;
    }

    private int[] memos;

    //递归,带备忘录
    public int coinChange2(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memos[amount] != 0) {
            return memos[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            //先算子问题，子问题无解，continue
            int subRes = coinChange2(coins, amount - coin);
            if (subRes == -1) {
                continue;
            }
            //比较当前用最少硬币数
            res = Math.min(res, 1 + subRes);
        }
        if (Integer.MAX_VALUE == res) {
            res = -1;
        }
        memos[amount] = res;
        return res;
    }


    //构造dp数组，迭代
    public int coinChange3(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount+1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        if (dp[amount] == amount+1) {
            return -1;
        }
        return dp[amount];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
