package com.smida.algrithm.leetcode.editor.cn;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * //
 * // 如果数组中不存在目标值 target，返回 [-1, -1]。
 * //
 * // 进阶：
 * //
 * //
 * // 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [5,7,7,8,8,10], target = 8
 * //输出：[3,4]
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [5,7,7,8,8,10], target = 6
 * //输出：[-1,-1]
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [], target = 0
 * //输出：[-1,-1]
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 0 <= nums.length <= 105
 * // -109 <= nums[i] <= 109
 * // nums 是一个非递减数组
 * // -109 <= target <= 109
 * //
 * // Related Topics 数组 二分查找
 * // 👍 1691 👎 0
 */
public class _34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new _34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] res = solution.searchRange(new int[]{7}, 7);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //把简单的二分查找改一下
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[2];
            int lInd = 0, rInd = nums.length - 1;
            int resInd = -1;
            while (lInd <= rInd) {
                int mid = (lInd + rInd) / 2;
                if (nums[mid] == target) {
                    resInd = mid;
                    break;
                } else if (nums[mid] > target) {
                    rInd = mid - 1;
                } else if (nums[mid] < target) {
                    lInd = mid + 1;
                }
            }
            int lRes = resInd, rRes = resInd;
            res[0] = lRes;
            res[1] = rRes;
            if (resInd != -1) {
                while (lRes >= 0 && nums[lRes] == target) {
                    res[0] = lRes;
                    lRes--;
                }
                while (rRes < nums.length && nums[rRes] == target) {
                    res[1] = rRes;
                    rRes++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}