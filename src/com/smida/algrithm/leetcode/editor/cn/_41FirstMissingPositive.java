package com.smida.algrithm.leetcode.editor.cn;

/**
 * 缺失的第一个正数
 * //给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * //请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [1,2,0]
 * //输出：3
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [3,4,-1,1]
 * //输出：2
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [7,8,9,11,12]
 * //输出：1
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 5 * 105
 * // -231 <= nums[i] <= 231 - 1
 * //
 * // Related Topics 数组 哈希表
 * // 👍 1476 👎 0
 */
public class _41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new _41FirstMissingPositive().new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1, 2, 8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //如果数组长为n，那结果肯定在1~n中
        //将数组中1~n外全部置为一个大于n的正数，1~n(绝对值)的数字标记在下标(1~n)-1中，再把此处值置负
        //返回第一个大于0的下标值+1
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }
            for (int i = 0; i < n; i++) {
                int val = Math.abs(nums[i]);
                if (val <= n) {
                    nums[val - 1] = -Math.abs(nums[val - 1]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}