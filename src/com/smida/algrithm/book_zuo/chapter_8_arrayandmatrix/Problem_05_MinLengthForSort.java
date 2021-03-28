package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 求需排序的最短子数组长度
 * 如 arr=1,5,3,4,2,6,7 返回 4，因为只有5,3,4,2需要排序
 * <p>
 * 左到右，找小于当前最大值的最右边的rInd
 * 右到左，找大于当前最小值的最左边的lInd
 * 返回rInd-lInd+1
 */
public class Problem_05_MinLengthForSort {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 4, 2, 6, 7};
        System.out.println(getMinLength(arr1));
        System.out.println(getMinLengthMy(arr1));
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        System.out.println(getMinLength(arr));
        System.out.println(getMinLengthMy(arr));

    }

    private static int getMinLengthMy(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int lInd = 0, rInd = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else {
                rInd = i;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                lInd = i;
            }
        }
        return rInd - lInd + 1;
    }

    public static int getMinLength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[arr.length - 1];
        int noMinIndex = -1;
        for (int i = arr.length - 2; i != -1; i--) {
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(min, arr[i]);
            }
        }
        if (noMinIndex == -1) {
            return 0;
        }
        int max = arr[0];
        int noMaxIndex = -1;
        for (int i = 1; i != arr.length; i++) {
            if (arr[i] < max) {
                noMaxIndex = i;
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }
}
