package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Difference df = new Difference(new int[n]);
        for (int[] booking : bookings) {
            df.rangeAdd(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return df.obtainAddNum();
    }
}

class Difference {
    int[] nums;
    int[] diffs;

    //构造函数
    public Difference(int[] nums) {
        this.nums = nums;
        this.diffs = generateDiffs(nums);
    }

    //构成查分数组
    private int[] generateDiffs(int[] nums) {
        int[] diffs = new int[nums.length];
        diffs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diffs[i] = nums[i] - nums[i - 1];
        }
        return diffs;
    }

    //范围加减
    public void rangeAdd(int lInd, int rInd, int toAdd) {
        diffs[lInd] += toAdd;
        if (rInd + 1 < diffs.length) {
            diffs[rInd + 1] -= toAdd;
        }
    }

    //获取改变后的数组
    public int[] obtainAddNum() {
        int[] res = new int[nums.length];
        res[0] = diffs[0];
        for (int i = 1; i < diffs.length; i++) {
            res[i] = res[i - 1] + diffs[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
