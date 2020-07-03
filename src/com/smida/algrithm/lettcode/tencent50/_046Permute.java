package com.smida.algrithm.lettcode.tencent50;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _046Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return res;
        }
        permute(res, 0, nums.length - 1, nums);
        return res;
    }

    private static void permute(List<List<Integer>> res, int startIndex, int endIndex, int[] nums) {
        if (startIndex == endIndex) {
            List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
            System.out.println(arr);
            res.add(arr);
        }
        for (int i = startIndex; i <= endIndex; i++) {
            swap(nums, startIndex, i);
            permute(res, startIndex + 1, endIndex, nums);
            swap(nums, startIndex, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        permute(new int[]{1,2});
        System.out.println("======================================");
        permute(new int[]{1,2,3});
    }
}
