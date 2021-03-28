package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 给定一个数组和整数k，求数组中所有子数组中元素相加为k的最长子数组长度
 * 如：arr=1,2,1,1,1 k=3 和为k的最长子数组为1,1,1 返回3
 * <p>
 * left=right=0,sum=0,maxLen=0
 * 如果sumArr[left,right]=k，且r-l+1>maxLen 更新maxLen，然后left++
 * 如果sumArr[left,right]<k，令right++，right不能大于等于数组长度
 * 如果sumArr[left,right]>k，令left++
 */
public class Problem_10_LongestSumSubArrayLengthInPositiveArray {
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] generatePositiveArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 10) + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int len = 20;
        int k = 15;
        int[] arr = generatePositiveArray(len);
        printArray(arr);
        System.out.println(getMaxLength(arr, k));
    }

    private static int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int l = 0, r = 0, sum = 0;
        int maxLen = 0;
        while (r < arr.length) {
            if (l == r) {
                sum = arr[l];
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, r - l + 1);
                sum -= arr[l];
                l++;
            } else if (sum < k && (r + 1 < arr.length)) {
                r++;
                sum += arr[r];
            } else {
                sum -= arr[l];
                l++;
            }
            if (l > r) {
                r = l;
            }
        }
        return maxLen;
    }

}
