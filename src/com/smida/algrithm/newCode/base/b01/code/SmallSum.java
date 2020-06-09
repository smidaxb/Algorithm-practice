package com.smida.algrithm.newCode.base.b01.code;

/**
 * 小和问题
 * CREATED BY yangyifan
 * Date: 2020/6/10
 */
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (null == arr || arr.length < 2) {
            return 0;
        }
        int[] tmpArr = new int[arr.length];
        return merge(arr, 0, arr.length - 1, tmpArr);
    }

    private static int merge(int[] arr, int left, int right, int[] tmpArr) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int part1 = merge(arr, left, mid, tmpArr);
        int part2 = merge(arr, mid + 1, right, tmpArr);
        int l1 = left, l2 = mid + 1, index = l1;
        int part3 = 0;
        while (l1 <= mid && l2 <= right) {
            part3 += arr[l1] < arr[l2] ? (arr[l1] * (right - l2 + 1)) : 0;
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
        return part1 + part2 + part3;
    }


    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
