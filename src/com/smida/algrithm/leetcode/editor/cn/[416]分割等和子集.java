package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum >> 1;
        //回溯
//        return sub(nums, 0, sum);
        //可转为背包，n个物品，重量为nums[i]，是否能装满容量为 sum/2 的背包
        return bag(nums, sum);
    }

    //dp[i][j] 为 遍历到物品i时，容量为j的背包能否装满
    private boolean bag(int[] nums, int sum) {
        int m = nums.length;
        boolean[][] dp = new boolean[m + 1][sum + 1];
        //背包为空全满，不为空时物品为空全空
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = true;
        }
        for (int j =1; j < sum + 1; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                //物品不进背包的结果同上一行
                boolean flag = dp[i - 1][j];
                //物品可以进背包的话计算进入背包能装满的情况
                if (j - nums[i - 1] >= 0) {
                    flag = flag || dp[i - 1][j - nums[i - 1]];
                }
                dp[i][j] = flag;
                if (j == sum && flag) {
                    return true;
                }
            }
        }
        return false;
    }


    Map<String, Boolean> map = new HashMap<>();

    private boolean sub(int[] nums, int i, int sum) {
        if (sum == 0) {
            return true;
        }
        //装超了或者没有物品了还没装满，返回false
        if (i == nums.length || sum < 0) {
            return false;
        }
        String key = i + "_" + sum;
        if (map.keySet().contains(key)) {
            return map.get(key);
        }
        //可选择装或不装两种情况
        boolean res = sub(nums, i + 1, sum - nums[i]) || sub(nums, i + 1, sum);
        map.put(key, res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
