package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution560 {
    public int subarraySum(int[] nums, int k) {
        return subarraySum2(nums, k);
    }

    //用 累加和 暴力递归
    public int subarraySum1(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 0; j < i; j++) {
                //可转化为 j小于i时 找 preSum[j] 等于 preSum[i]-k 的个数
                if (preSum[i] - preSum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    //根据上边的转化，用hash表动态记录某个累加和出现的次数
    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        //key 为前缀和，value为出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        //空数组也算
        map.put(0, 1);
        int sumIPlus1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sumIPlus1 = sumIPlus1 + nums[i];
            int sumJ = sumIPlus1 - k;
            if (null != map.get(sumJ)) {
                res += map.get(sumJ);
            }
            int sumIVal = map.get(sumIPlus1) == null ? 0 : map.get(sumIPlus1);
            sumIVal++;
            map.put(sumIPlus1, sumIVal);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
