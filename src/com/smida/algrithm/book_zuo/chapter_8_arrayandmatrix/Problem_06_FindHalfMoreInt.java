package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 数组里找出现次大于一半的数，没有就打印提示信息
 */
public class Problem_06_FindHalfMoreInt {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 2, 1};
        printHalfMajor(arr);
        int[] arr1 = {1, 2};
        printHalfMajor(arr1);
    }

    private static void printHalfMajor(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int count = 0;
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                count++;
                cur = arr[i];
                continue;
            }
            if (arr[i] == cur) {
                count++;
            } else {
                count--;
            }
        }
        count =0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cur) {
                count++;
            }
        }
        if (count > arr.length / 2) {
            System.out.println(cur);
        }else {
            System.out.println("没找到");
        }
    }
}
