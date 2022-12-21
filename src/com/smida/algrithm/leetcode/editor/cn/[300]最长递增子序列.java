package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashMap;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution300 {
    //dp[i] 为从左到右下标i处，子序列最长的值，若值相同大小，则后边的数必小于等于前边的数
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 1;
        dp[0] = 1;
        map.put(dp[0], 0);//key：序列值 value：对应最大ind
        for (int i = 1; i < nums.length; i++) {
            //若比当前最大子序列值还大，则直接加一，存位置即可
            if (nums[i] > nums[map.get(res)]) {
                dp[i] = dp[map.get(res)] + 1;
                map.put(dp[i], i);
                res++;
                continue;
            }
            //否则比较小一位的子序列值，比较到当前值大于该位置数字为止
            //若k走到了0，说明前边没有比它小的值
            int k = res - 1;
            while (k >= 1) {
                if (nums[i] <= nums[map.get(k)]) {
                    k--;
                } else {
                    break;
                }
            }
            //更新当前位置的子序列最长值
            dp[i] = k + 1;
            map.put(k + 1, i);
        }
        return res;//这里res也就是dp数组的最大值
    }


    //dp[i] 为从左到右下标i处，子序列最长的值 无map优化解法
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;//这里res也就是dp数组的最大值
    }
}
//leetcode submit region end(Prohibit modification and deletion)
