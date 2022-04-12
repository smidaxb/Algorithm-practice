package com.smida.algrithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * //
 * // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * //
 * // 你可以按任意顺序返回答案。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [2,7,11,15], target = 9
 * //输出：[0,1]
 * //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [3,2,4], target = 6
 * //输出：[1,2]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [3,3], target = 6
 * //输出：[0,1]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 2 <= nums.length <= 104
 * // -109 <= nums[i] <= 109
 * // -109 <= target <= 109
 * // 只会存在一个有效答案
 * //
 * //
 * // 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 * // Related Topics 数组 哈希
 * // 👍 14067 👎 0
 */
public class _1TwoSum {
    public static void main(String[] args) {
        Solution solution = new _1TwoSum().new Solution();
        int[] a = new int[]{2, 7, 11, 15};
        solution.twoSum(a, 9);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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

}