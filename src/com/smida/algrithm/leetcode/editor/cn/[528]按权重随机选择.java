package com.smida.algrithm.leetcode.editor.cn;

import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution528 {
    int[] w;
    int[] preSum;

    public Solution528(int[] w) {
        this.w = w;
        this.preSum = new int[w.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int rand = new Random().nextInt(preSum[preSum.length - 1]) + 1;

        //二分查找
        int l = 0, r = preSum.length - 1;
        int ind = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] > rand) {
                r = mid - 1;
            } else if (preSum[mid] < rand) {
                l = mid + 1;
            } else {
                ind = mid;
                break;
            }
        }
        ind = ind == -1 ? l : ind;
        return ind - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)
