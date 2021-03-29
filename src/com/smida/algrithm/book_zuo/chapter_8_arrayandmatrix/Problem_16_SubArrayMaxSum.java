package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 求子数组最大累加和
 * <p>
 * arr=[1,-2,3,5,-2,6,-1]，包含最大累加和的子数组 [3,5,-2,6]，返回12
 * cur记录当前累加和，如果为负就重新开始
 * max记录最大的cur值，返回max
 */
public class Problem_16_SubArrayMaxSum {
    public static void main(String[] args) {
        int[] arr1 = {-2, -3, -5, 40, -10, -10, 100, 1};
        System.out.println(maxSum(arr1));

        int[] arr2 = {-2, -3, -5, 0, 1, 2, -1};
        System.out.println(maxSum(arr2));

        int[] arr3 = {-2, -3, -5, -1};
        System.out.println(maxSum(arr3));

    }

    private static int maxSum(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int cur = 0,max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur > max) {
                max = cur;
            }
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}
