package com.smida.algrithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    //本人思路：先排序，后两边往中间找
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                res[0] = findInd(copy, nums[i], true);
                res[1] = findInd(copy, nums[j], false);
                return res;
            } else if (sum < target) {
                i++;
                continue;
            } else {
                j--;
                continue;
            }
        }
        return res;
    }

    public int findInd(int[] nums, int target, boolean asc) {
        if (asc) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
        } else {
            for (int i = nums.length-1; i >= 0; i--) {
                if (nums[i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }

    //good solution 用map，存值和位置，从左到右一遍过
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(m.containsKey(temp)){
                res[1] = i;
                res[0] = m.get(temp);
            }
            m.put(nums[i],i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
