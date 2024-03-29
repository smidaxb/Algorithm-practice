package com.smida.algrithm.book_zuo.chapter_9_others;

import java.util.Arrays;

/**
 * 在两个长度相等的有序数组里找一共的上中位数
 */
public class Problem_26_FindUpMedian {
    /**
     * 标准答案
     */
    public static int getUpMedian(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            throw new RuntimeException("Your arr is invalid!");
        }
        int start1 = 0;
        int end1 = arr1.length - 1;
        int start2 = 0;
        int end2 = arr2.length - 1;
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (start1 < end1) {
            mid1 = (start1 + end1) / 2;
            mid2 = (start2 + end2) / 2;
            // 元素个数为奇数，offset为0，元素个数为偶数，offset为1。
            offset = ((end1 - start1 + 1) & 1) ^ 1;
            if (arr1[mid1] > arr2[mid2]) {
                end1 = mid1;
                start2 = mid2 + offset;
            } else if (arr1[mid1] < arr2[mid2]) {
                start1 = mid1 + offset;
                end2 = mid2;
            } else {
                return arr1[mid1];
            }
        }
        return Math.min(arr1[start1], arr2[start2]);
    }

    // For test, this method is inefficient but absolutely right
    public static int findForTest(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            throw new RuntimeException("Your arr is invalid!");
        }
        int[] arrAll = new int[arr1.length + arr2.length];
        for (int i = 0; i != arr1.length; i++) {
            arrAll[i * 2] = arr1[i];
            arrAll[i * 2 + 1] = arr2[i];
        }
        Arrays.sort(arrAll);
        return arrAll[(arrAll.length / 2) - 1];
    }

    public static int[] generateSortedArray(int len, int maxValue) {
        int[] res = new int[len];
        for (int i = 0; i != len; i++) {
            res[i] = (int) (Math.random() * (maxValue + 1));
        }
        Arrays.sort(res);
        return res;
    }

    public static void printArray(int[] arr) {


    }

    public static void main(String[] args) {
        int len = 10;
        int maxValue1 = 20;
        int maxValue2 = 50;
        int[] arr1 = generateSortedArray(len, maxValue1);
        int[] arr2 = generateSortedArray(len, maxValue2);
        printArray(arr1);
        printArray(arr2);
        System.out.println(getUpMedian(arr1, arr2));
        System.out.println(getUpMedianMy(arr1, arr2));
        System.out.println(findForTest(arr1, arr2));

    }

    /**
     * My
     */
    public static int getUpMedianMy(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            throw new RuntimeException("Your arr is invalid!");
        }
        int ind = (arr1.length + arr2.length) / 2;
        int a1i = 0, a2i = 0;
        int i = 0, res = 0;
        while (a1i < arr1.length && a2i < arr2.length) {
            i++;
            res = arr1[a1i] > arr2[a2i] ? arr2[a2i++] : arr1[a1i++];
            if (i == ind) {
                return res;
            }
        }
        return res;
    }

}
