package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 调整数组，令数组的奇数下标都是奇数 或 偶数下标都是偶数
 * <p>
 * 1、even=0代表第一个偶数下标，odd=1代表第一个奇数下标
 * 2、取出arr[len-1]，奇数就和arr[odd]互换，偶数就和arr[even]互换，然后令odd或even +=2
 * 3、当odd和even均不大于len时重复执行第2步
 */
public class Problem_15_EvenInEvenOddInOdd {
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 2, 4, 6};
        printArray(arr);
        modify(arr);
        printArray(arr);
    }

    private static void modify(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int even = 0, odd = 1;
        while (even < arr.length && odd < arr.length) {
            int val = arr[arr.length - 1];
            if ((val & 1) == 1) {
                swap(arr, odd, arr.length - 1);
                odd += 2;
            } else {
                swap(arr, even, arr.length - 1);
                even += 2;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[b] ^ arr[a];
        arr[a] = arr[a] ^ arr[b];
    }
}
