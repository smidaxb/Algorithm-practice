package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution494 {
    //回溯算法,带备忘录

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        return dp(nums, 0, target, map);

    }

    private int dp(int[] nums, int i, int target, HashMap<String, Integer> map) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        String key = i + "_" + target;
        Integer cache = map.get(key);
        if (null != cache) {
            return cache;
        }
        int val = nums[i];
        int r = dp(nums, i + 1, target + val, map) + dp(nums, i + 1, target - val, map);
        map.put(key, r);
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
