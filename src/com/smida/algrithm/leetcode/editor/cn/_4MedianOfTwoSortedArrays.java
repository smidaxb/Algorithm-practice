package com.smida.algrithm.leetcode.editor.cn;

/**
 * 寻找两个正序数组的中位数
 * //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * //
 * // 算法的时间复杂度应该为 O(log (m+n)) 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums1 = [1,3], nums2 = [2]
 * //输出：2.00000
 * //解释：合并数组 = [1,2,3] ，中位数 2
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums1 = [1,2], nums2 = [3,4]
 * //输出：2.50000
 * //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * //
 * //
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // nums1.length == m
 * // nums2.length == n
 * // 0 <= m <= 1000
 * // 0 <= n <= 1000
 * // 1 <= m + n <= 2000
 * // -106 <= nums1[i], nums2[i] <= 106
 * //
 * // Related Topics 数组 二分查找 分治
 * // 👍 5312 👎 0
 */
public class _4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new _4MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //先merge成一个数组，然后根据数组长度是奇数是偶数找中位数
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i = 0, j = 0, k = 0;
            int[] arr = new int[nums1.length + nums2.length];
            while (i < nums1.length || j < nums2.length) {
                int val;
                if (i < nums1.length && j < nums2.length) {
                    if (nums1[i] > nums2[j]) {
                        val = nums2[j];
                        j++;
                    } else {
                        val = nums1[i];
                        i++;
                    }
                } else if (i < nums1.length) {
                    val = nums1[i];
                    i++;
                } else {
                    val = nums2[j];
                    j++;
                }
                arr[k++]=val;
            }
            if (k % 2 == 1) {
                return arr[k / 2];
            }else {
                return (arr[k / 2] + arr[k / 2 - 1]) / 2.0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}