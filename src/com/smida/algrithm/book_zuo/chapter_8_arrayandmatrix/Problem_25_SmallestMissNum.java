package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

import sun.security.util.BitArray;

/**
 * 求数组中未出现的最小正数
 * 如[-1,0,2,3]返回1
 * 如[1,2,5,6]返回3
 */
public class Problem_25_SmallestMissNum {
    /**
     * 标准答案
     * arr[0~l]代表已规整的部分,如[1,2,3,...]
     * r从最后向前遍历，l从前往后
     * 如果arr[l]=l+1，说明符合规整，l++
     * 如果arr[l]<=l，说明为0或负数或已规整过的重复元素；如果arr[l]>r，说明元素超过可能规整的最大位置； 把该元素换到最右边，并r--
     * 其他情况说明元素可以规整到后边其他位置，将其换到其应在的位置：交换 l 和 arr[l]-1的位置
     */
    public static int missNum(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            if (arr[l] == l + 1) {
                l++;
            } else if (arr[l] <= l || arr[l] > r) {
                arr[l] = arr[--r];
            } else {
                swap(arr, l, arr[l] - 1);
            }
        }
        return l + 1;
    }


    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 2,1,1,1, 5, 4};
        System.out.println(missNum(arr));
        System.out.println(missNumMy(arr));
    }

    /**
     * My
     * 先找出数组中最小正数，不是1就直接返回1
     * 对1-N
     * 用另一个数组bitArr(长度比数组长度长1)，记录i+1是否在数组中，遍历数组，比数组长度大就跳过
     * 遍历bitArr，找第一个为空的，返回i+1
     */
    public static int missNumMy(int[] arr) {
        int minNature = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1) {
                continue;
            }
            if (arr[i] < minNature) {
                minNature = arr[i];
            }
        }
        if (minNature != 1) {
            return 1;
        }
        BitArray bitArr = new BitArray(arr.length + 1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr.length || arr[i] < 1) {
                continue;
            }
            bitArr.set(arr[i] - 1, true);
        }
        for (int i = 0; i < bitArr.length(); i++) {
            if (!bitArr.get(i)) {
                return i + 1;
            }
        }
        return 0;
    }
}
