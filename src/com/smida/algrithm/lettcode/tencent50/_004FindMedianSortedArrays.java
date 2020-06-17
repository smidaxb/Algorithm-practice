package com.smida.algrithm.lettcode.tencent50;

/**
 * 04.求中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class _004FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = (null == nums1 ? 0 : nums1.length) + (null == nums2 ? 0 : nums2.length);
        if (size == 0) {
            return 0.0;
        }
        int ind1, ind2 = ind1 = 0;
        int num1, num2 = num1 = 0;
        ind2 = size / 2;
        ind1 = size % 2 == 1 ? ind2 : ind2 - 1;
        int count = 0;
        int l1, l2 = l1 = 0;
        while ((null != nums1 && null != nums2) && (l1 < nums1.length || l2 < nums2.length)) {
            int tmp;
            if (l1 < nums1.length) {
                if (l2 < nums2.length) {
                    tmp = nums1[l1] < nums2[l2] ? nums1[l1++] : nums2[l2++];
                } else {
                    tmp = nums1[l1++];
                }
            } else {
                tmp = nums2[l2++];
            }
            if (count == ind1) {
                num1 = tmp;
            }
            if (count == ind2) {
                num2 = tmp;
                return (num1 + num2) * 1.0 / 2;
            }
            count++;
        }
        if (null != nums1 && nums1.length > 0) {
            return (nums1[ind1] + nums1[ind2]) * 1.0 / 2;
        } else {
            return (nums2[ind1] + nums2[ind2]) * 1.0 / 2;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1};
        int[] b = new int[]{};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
