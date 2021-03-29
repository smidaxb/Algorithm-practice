package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 求小和
 * <p>
 * 和求逆序对差不多，都用归并排序的思想
 */
public class Problem_13_SmallSum {
    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int s = 0;
        int e = arr.length - 1;
        int[] tmpArr = new int[arr.length];
        //分段排序，先直接整体一段
        partSort(arr, tmpArr, s, e);
    }

    private static void partSort(int[] arr, int[] tmpArr, int s, int e) {
        if (s == e) {
            return;
        }
        int mid = s + (e - s) / 2;
        //整体分两半
        partSort(arr, tmpArr, s, mid);
        partSort(arr, tmpArr, mid + 1, e);
        //排好序后归并
        merge(arr, tmpArr, s, mid, e);
    }

    private static void merge(int[] arr, int[] tmpArr, int s, int mid, int e) {
        int ind = s;
        int ind1 = s;
        int e1 = mid;
        int ind2 = mid + 1;
        int e2 = e;
        //将要排序的两部分都拷贝到临时数组中
        for (int i = s; i <= e; i++) {
            tmpArr[i] = arr[i];
        }
        //归并
        while (ind1 <= e1 && ind2 <= e2) {
            if (tmpArr[ind1] <= tmpArr[ind2]) {
                arr[ind++] = tmpArr[ind1++];
            } else {
                arr[ind++] = tmpArr[ind2++];
            }
        }
        if (ind1 <= e1) {
            while (ind1 <= e1) {
                arr[ind++] = tmpArr[ind1++];
            }
        } else {
            while (ind2 <= e2) {
                arr[ind++] = tmpArr[ind2++];
            }
        }
    }

    /**
     * 小和
     */
    public static int smallSum(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int s = 0;
        int e = arr.length - 1;
        int[] tmpArr = new int[arr.length];
        //分段计算，先直接整体一段
        return partSmallSum(arr, tmpArr, s, e);
    }

    private static int partSmallSum(int[] arr, int[] tmpArr, int s, int e) {
        if (s == e) {
            return 0;
        }
        int mid = s + (e - s) / 2;
        //整体分两半,最后归并也计算在内
        return partSmallSum(arr, tmpArr, s, mid)
                + partSmallSum(arr, tmpArr, mid + 1, e)
                + mergeSmallSum(arr, tmpArr, s, mid, e);
    }

    private static int mergeSmallSum(int[] arr, int[] tmpArr, int s, int mid, int e) {
        int ind = s;
        int ind1 = s;
        int e1 = mid;
        int ind2 = mid + 1;
        int e2 = e;
        int res = 0;
        //将要排序的两部分都拷贝到临时数组中
        for (int i = s; i <= e; i++) {
            tmpArr[i] = arr[i];
        }
        //归并
        while (ind1 <= e1 && ind2 <= e2) {
            if (tmpArr[ind1] <= tmpArr[ind2]) {
                res += tmpArr[ind1] * (e2 - ind2 + 1);
                arr[ind++] = tmpArr[ind1++];
            } else {
                arr[ind++] = tmpArr[ind2++];
            }
        }
        if (ind1 <= e1) {
            while (ind1 <= e1) {
                arr[ind++] = tmpArr[ind1++];
            }
        } else {
            while (ind2 <= e2) {
                arr[ind++] = tmpArr[ind2++];
            }
        }
        return res;
    }

    /**
     * 标准答案
     */
    public static int getSmallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return func(arr, 0, arr.length - 1);
    }

    public static int func(int[] s, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        return func(s, l, mid) + func(s, mid + 1, r) + merge(s, l, mid, r);
    }

    public static int merge(int[] s, int left, int mid, int right) {
        int[] h = new int[right - left + 1];
        int hi = 0;
        int i = left;
        int j = mid + 1;
        int smallSum = 0;
        while (i <= mid && j <= right) {
            if (s[i] <= s[j]) {
                smallSum += s[i] * (right - j + 1);
                h[hi++] = s[i++];
            } else {
                h[hi++] = s[j++];
            }
        }
        for (; (j < right + 1) || (i < mid + 1); j++, i++) {
            h[hi++] = i > mid ? s[j] : s[i];
        }
        for (int k = 0; k != h.length; k++) {
            s[left++] = h[k];
        }
        return smallSum;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    //forTest
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 6, 2, 7, 8, 1};
        int[] arr2 = {3, 1, 2, 4, 6, 2, 7, 8, 1};
        int[] arr3 = {3, 1, 2, 4, 6, 2, 7, 8, 1};
        System.out.println(getSmallSum(arr));
        System.out.println(smallSum(arr2));
        printArray(arr3);
        mergeSort(arr3);
        printArray(arr3);
    }
}
