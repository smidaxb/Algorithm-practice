package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 有序数组的partition调整
 * 给定arr=[1,2,2,3,3,4,4,4,5,5]
 * 调整之后[1,2,3,4,5,...]
 *
 * 用cur代表当前元素，nextInd代表下一个调整到的位置
 * 若arr[i]!=cur 则 swap i,nextInd   nextInd++
 *
 * 进阶，一个数组，只有0 1 2三种元素，给丫排序
 * 走三遍，第一遍0，第二遍1，第三遍2
 */
public class Problem_23_PartitionArray {
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9 };
        printArray(arr1);
        leftUnique(arr1);
        printArray(arr1);

        System.out.println();

        int[] arr2 = { 2, 1, 2, 0, 1, 1, 2, 2, 0 };
        printArray(arr2);
        mySort(arr2);
        printArray(arr2);

    }

    private static void leftUnique(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int cur = arr[0];
        int nextInd = 1;
        for (int i = 0; i < arr.length; i++) {
            if (cur != arr[i]) {
                cur = arr[i];
                swap(arr, nextInd, i);
                nextInd++;
            }
        }
    }

    private static void mySort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int cur;
        int nextInd=0;
        for (int i = 0; i < 2; i++) {
            cur = i;
            for (int j = nextInd; j < arr.length; j++) {
                if (arr[j] == cur) {
                    swap(arr,nextInd,j);
                    nextInd++;
                }
            }
        }
    }
}
