package com.smida.algrithm.leetcode.editor.cn;

/**
 * 差分数组工具类
 *
 * @author YYF
 * @date 2022-12-08 13:37
 */
public class DifferenceArr {
    int[] nums;
    int[] diffs;

    //构造函数
    public DifferenceArr(int[] nums) {
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
