package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 不包含本位置的累乘数组
 * <p>
 * arr=[2,3,1,4]，返回[12,8,24,6]
 */
public class Problem_22_MultiplyExceptOwn {
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] res1 = product1(arr);
        printArray(res1);
        int[] res2 = product2(arr);
        printArray(res2);
    }

    //不用除法
    private static int[] product2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        int[] res = new int[arr.length];
        res[0] = arr[0];
        //res里先存从左到右的阶乘
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i-1]*arr[i];
        }
        //tmp依次保存从右到左的阶乘
        int tmp = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            res[i] = res[i-1]*tmp;
            tmp *= arr[i];
        }
        res[0] = tmp;
        return res;
    }
    //用除法
    private static int[] product1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        int[] res = new int[arr.length];
        int count0 = 0;
        int multi = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else {
                multi *= arr[i];
            }
        }
        if (count0 > 1) {
            return res;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                res[i] = multi;
            } else {
                res[i] = multi / arr[i];
            }
        }
        return res;
    }
}
