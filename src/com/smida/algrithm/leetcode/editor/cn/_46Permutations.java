package com.smida.algrithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 全排列
 * //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [1,2,3]
 * //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [0,1]
 * //输出：[[0,1],[1,0]]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [1]
 * //输出：[[1]]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 6
 * // -10 <= nums[i] <= 10
 * // nums 中的所有整数 互不相同
 * //
 * // Related Topics 数组 回溯
 * // 👍 2042 👎 0
 */
public class _46Permutations {
    public static final Logger LOGGER = Logger.getLogger("");

    public static void main(String[] args) {
        Solution solution = new _46Permutations().new Solution();
        List<List<Integer>> res = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 思路：递归法，问题转换为先固定第一个字符，求剩余字符的排列；求剩余字符排列时跟原问题一样。
         * (1) 遍历出所有可能出现在第一个位置的字符（即：依次将第一个字符同后面所有字符交换）；
         * (2) 固定第一个字符，求后面字符的排列（即：在第1步的遍历过程中，插入递归进行实现）。
         * 需要注意的几点：
         * (1) 先确定递归结束的条件，例如本题中可设begin == str.size() - 1;
         */
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            return permute(res, 0, nums);
        }

        private List<List<Integer>> permute(List<List<Integer>> res, int begin, int[] nums) {
            if (begin < 0 || begin >= nums.length) {
                return res;
            }
            if (begin == nums.length - 1) {
                List<Integer> ll = new ArrayList<>();
                for (int num : nums) {
                    ll.add(num);
                }
                res.add(ll);
                return res;
            }
            for (int i = begin; i < nums.length; i++) {
                swap(nums, begin, i);
                permute(res, begin + 1, nums);
                swap(nums, begin, i);
            }
            return res;
        }

        private void swap(int[] nums, int begin, int i) {
            int tem = nums[begin];
            nums[begin] = nums[i];
            nums[i] = tem;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}