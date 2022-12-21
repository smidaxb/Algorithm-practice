package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution518 {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++)
                if (j - coins[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i - 1]];//这个等同于下边的循环
                else
                    dp[i][j] = dp[i - 1][j];
        }
        return dp[n][amount];
    }

    //可转化为，有m种体积不同的物品和一个容量为amount的背包，每种物品个数无限，问能装满背包的方式有几种
    //dp[i][j] 为i种物品，在背包容量为为j时，能装满背包的方式数
    public int change1(int amount, int[] coins) {
        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];
        //初始化，第一列背包容量为0自然满，除第一个元素外第一行无物品全装不满
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                //总装满方式数为 放0-n个该物品所得的方式和加起来
                int type = 0;
                //0到多个
                int count = 0;
                int nextJ = j - (count * coins[i - 1]);
                while (nextJ >= 0) {
                    type += dp[i - 1][nextJ];
                    count++;
                    nextJ = j - (count * coins[i - 1]);
                }
                dp[i][j] = type;
            }
        }
        return dp[m][amount];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
