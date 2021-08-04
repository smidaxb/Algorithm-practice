package com.smida.algrithm.lettcode.tencent50;

import java.util.ArrayList;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class _053MaxSubArray {
    public static void maxSubArray(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> mSubArr = new ArrayList<>();
        int singleMax = 0;
        int globalMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((singleMax + nums[i]) > nums[i]) {
                singleMax = singleMax + nums[i];
            } else {
                singleMax = nums[i];
                mSubArr.clear();
            }
            mSubArr.add(nums[i]);
            if (singleMax > globalMax) {
                res.clear();
                res.addAll(mSubArr);
                globalMax = singleMax;
            }
        }
        System.out.println(res);
        System.out.println(res.stream().mapToInt(s -> s).sum());
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
