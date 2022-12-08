package com.smida.algrithm.leetcode.editor.cn;

import com.smida.algrithm.leetcode.editor.cn.Difference;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Difference df = new Difference(new int[1001]);
        for (int[] trip : trips) {
            df.rangeAdd(trip[1], trip[2] - 1, trip[0]);
        }
        for (int i : df.obtainAddNum()) {
            if (i > capacity) {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
