package com.smida.algrithm.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 三数之和
 * //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
 * //复的三元组。
 * //
 * // 注意：答案中不可以包含重复的三元组。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [-1,0,1,2,-1,-4]
 * //输出：[[-1,-1,2],[-1,0,1]]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = []
 * //输出：[]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [0]
 * //输出：[]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 0 <= nums.length <= 3000
 * // -105 <= nums[i] <= 105
 * //
 * // Related Topics 数组 双指针 排序
 * // 👍 4753 👎 0
 */
public class _15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new _15ThreeSum().new Solution();
        System.out.println(JSON.toJSONString(solution.threeSum(new int[]{0})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //先将数组排序，从左端取一个数，在其右端的剩余数组中双指针求三数和，为零存入set去重
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length == 0 || nums.length < 3) {
                return Collections.EMPTY_LIST;
            }
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int ind = 0;
            Set<String> set = new HashSet<>();
            while (ind < nums.length) {
                //此处第一个数如果和之前重复就跳过
                if (ind > 0 && nums[ind] == nums[ind - 1] || nums[ind] > 0) {
                    ind++;
                    continue;
                }
                int val = nums[ind];
                int l = ind + 1, r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] + val == 0) {
                        //key防止相同的结果出现
                        String key = val + "," + nums[l] + "," + nums[r];
                        if (!set.contains(key)) {
                            set.add(key);
                            List<Integer> list = new ArrayList<>(3);
                            list.add(val);
                            list.add(nums[l]);
                            list.add(nums[r]);
                            res.add(list);
                        }
                        l++;
                        continue;
                    } else {
                        if (nums[l] + nums[r] + val > 0) {
                            r--;
                        } else {
                            l++;
                        }
                    }
                }
                ind++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}