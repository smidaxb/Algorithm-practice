package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    //dp i 以i坐标结尾的连续子数组的最大和
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            //若以i-1结尾的累加和为负值，则num[i]自成子数组即最大
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                //否则就加上前值
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    //空间优化
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int res = dp;
        for (int i = 1; i < nums.length; i++) {
            //若以i-1结尾的累加和为负值，则num[i]自成子数组即最大
            if (dp < 0) {
                dp = nums[i];
            } else {
                //否则就加上前值
                dp += nums[i];
            }
            res = Math.max(dp, res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
