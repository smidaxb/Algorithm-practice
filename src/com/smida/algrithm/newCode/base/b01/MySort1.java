package com.smida.algrithm.newCode.base.b01;

import com.smida.algrithm.newCode.SortUtil;

/**
 * b01
 * CREATED BY yangyifan
 * Date: 2020/6/9
 */
public class MySort1 {
    private static int anInt;

    /**
     * 1.冒泡排序
     * 时间复杂度：
     * 1+2+。。。+n -------> O(n^2)
     * 加入判断交换次数改进后，若初始有序则只需遍历一次：O(n)
     */
    public static void BubbleSort(int[] arr) {
        //空数组或单元素直接返回
        if (null == arr || arr.length < 2) {
            return;
        }
        //从最后一位开始递减
        for (int endInd = arr.length - 1; endInd >= 0; endInd--) {
            int swapCount = 0;
            //每次会有一个元素到达终点位置
            for (int startInd = 0; startInd < endInd; startInd++) {
                if (arr[startInd] > arr[startInd + 1]) {
                    SortUtil.swap(arr, startInd, startInd + 1);
                    swapCount++;
                }
            }
            //若某次没有交换，说明元素有序，直接结束
            if (swapCount == 0) {
                break;
            }
        }
    }

    /**
     * 2.选择排序
     * 时间复杂度：
     * 1+2+。。。+n -------> O(n^2)
     */
    public static void selectionSort(int[] arr) {
        //空数组或单元素直接返回
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minInd = i;
            //每次找到最小值放到i上
            for (int j = i; j < arr.length; j++) {
                minInd = arr[j] < arr[minInd] ? j : minInd;
            }
            SortUtil.swap(arr, i, minInd);
        }
    }

    /**
     * 3.插入排序
     * 时间复杂度：
     * 最坏1+2+。。。+n -------> O(n^2)
     * 最好O(n)
     */
    public static void InsertionSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 3.归并排序
     * 时间复杂度：
     * n*log(n)
     * 空间复杂度n
     */
    public static void MergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int[] tmpArr = new int[arr.length];
        merge(arr, 0, arr.length - 1, tmpArr);
    }

    private static void merge(int[] arr, int left, int right, int[] tmpArr) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        merge(arr, left, mid, tmpArr);
        merge(arr, mid + 1, right, tmpArr);
        int l1 = left, l2 = mid + 1, index = l1;
        while (l1 <= mid && l2 <= right) {
            tmpArr[index++] = arr[l1] < arr[l2] ? arr[l1++] : arr[l2++];
        }
        while (l1 <= mid) {
            tmpArr[index++] = arr[l1++];
        }
        while (l2 <= right) {
            tmpArr[index++] = arr[l2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = tmpArr[i];
        }
    }

    /**
     * 小和问题/逆序对问题
     */
    public static int smallSum(int[] arr) {
        if (null == arr || arr.length < 2) {
            return 0;
        }
        int[] tmpArr = new int[arr.length];
        return smallSum(arr, 0, arr.length - 1, tmpArr);
    }

    private static int smallSum(int[] arr, int left, int right, int[] tmpArr) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int smallSumL = smallSum(arr, left, mid, tmpArr);
        int smallSumR = smallSum(arr, mid + 1, right, tmpArr);
        int smallSumMerge = 0;
        int index = left;
        int left1 = left, left2 = mid + 1;
        while (left1 <= mid && left2 <= right) {
            //小于算小和，大于可算逆序对
            smallSumMerge += arr[left1] < arr[left2] ? (right - left2 + 1) * arr[left1] : 0;
            //正常merge
            tmpArr[index++] = arr[left1] > arr[left2] ? arr[left2++] : arr[left1++];
        }
        while (left1 <= mid) {
            tmpArr[index++] = arr[left1++];
        }
        while (left2 <= right) {
            tmpArr[index++] = arr[left2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = tmpArr[i];
        }
        return anInt;
    }
}
