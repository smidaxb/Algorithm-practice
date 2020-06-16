package com.smida.algrithm.lettcode.tencent50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        Integer pre = null;
        Integer cur = null;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = nums[i];
            if (cur.equals(pre)) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if ((nums[left] + nums[right] + cur) == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (left < right && (nums[left] == nums[left + 1] || nums[right] == nums[right - 1])) {
                        if (nums[left] == nums[left + 1]) {
                            left++;
                        }
                        if (nums[right] == nums[right - 1]) {
                            right--;
                        }
                    }
                    left++;
                    right--;
                } else if ((nums[left] + nums[right] + cur) < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            pre = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
    }
}
