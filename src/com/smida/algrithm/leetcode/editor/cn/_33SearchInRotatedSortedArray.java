package com.smida.algrithm.leetcode.editor.cn;

/**
 * 搜索旋转排序数组
 * //整数数组 nums 按升序排列，数组中的值 互不相同 。
 * //
 * // 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
 * //k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
 * //,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * //
 * // 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [4,5,6,7,0,1,2], target = 0
 * //输出：4
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [4,5,6,7,0,1,2], target = 3
 * //输出：-1
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [1], target = 0
 * //输出：-1
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 5000
 * // -10^4 <= nums[i] <= 10^4
 * // nums 中的每个值都 独一无二
 * // 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * // -10^4 <= target <= 10^4
 * //
 * //
 * //
 * //
 * // 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 * // Related Topics 数组 二分查找
 * // 👍 2081 👎 0
 */
public class _33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new _33SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{3, 4}, 3));
        System.out.println(solution.binSearch(new int[]{3, 4}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (null == nums || nums.length == 0) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                    //如果mid在第一段
                } else if (nums[mid] > nums[right]) {
                    //如果target在第一段左边界--mid之间
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    //如果mid在第二段
                } else {
                    //如果target在第二段mid到右边界之间
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }

        //二分查找
        public int binSearch(int[] nums, int target) {
            int lInd = 0, rInd = nums.length - 1;
            while (lInd <= rInd) {
                int mid = (lInd + rInd) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    rInd = mid - 1;
                } else if (nums[mid] < target) {
                    lInd = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}