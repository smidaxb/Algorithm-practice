package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 自然数排序
 */
public class Problem_14_SortNaturalNumberArray {


    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 1, 6, 9, 3, 7, 5, 4};
        sort1(arr);
        printArray(arr);
        arr = new int[]{8, 2, 1, 6, 9, 3, 7, 5, 4};
        sort2(arr);
        printArray(arr);

    }

    /**
     * 找到不是位置的就换到那个位置，从那个位置接着找
     */
    private static void sort1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            while (arr[i] != i + 1) {
                int n = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                tmp = n;
            }
        }
    }

    /**
     * 找到不是位置的就把那个位置缓过来，从当前位置接着找
     */
    private static void sort2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                int tmp = arr[i];
                arr[i] = arr[tmp - 1];
                arr[tmp - 1] = tmp;
            }
        }
    }
}
