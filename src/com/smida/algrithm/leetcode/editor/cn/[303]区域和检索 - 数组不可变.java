package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int[] nums;
    //用累加和数组，第i位代表nums中0 ~ i-1加起来的值
    //也可解决 输入任意一个分数段，返回有多少同学的成绩在这个分数段内。
    int[] preSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
