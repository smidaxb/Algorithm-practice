package com.smida.algrithm.leetcode.editor.cn;

import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        int r = k - 1;
        int tmpMax = nums[l];
        int tmpMaxInd = l;
        for (int i = l; i <= r; i++) {
            if (tmpMax <= nums[i]) {
                tmpMax = nums[i];
                tmpMaxInd = i;
            }
        }
        res[l] = tmpMax;
        while (l <= nums.length - k) {
            if (++r < nums.length && nums[r] >= tmpMax) {
                tmpMax = nums[r];
                tmpMaxInd = r;
            }
            if (l++ == tmpMaxInd && l <= nums.length - k) {
                tmpMax = Integer.MIN_VALUE;
                for (int i = l; i <= r; i++) {
                    if (tmpMax <= nums[i]) {
                        tmpMax = nums[i];
                        tmpMaxInd = i;
                    }
                }
            }
            if (l < res.length) {
                res[l] = tmpMax;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
