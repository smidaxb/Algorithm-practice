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
            if (tmpArr[ind1] < tmpArr[ind2]) {
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


    //forTest
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4, 6, 2, 7, 8, 1 };
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
//        System.out.println(getSmallSum(arr));

    }
}
