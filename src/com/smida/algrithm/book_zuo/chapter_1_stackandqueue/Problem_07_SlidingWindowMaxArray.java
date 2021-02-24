package com.smida.algrithm.book_zuo.chapter_1_stackandqueue;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组(滑动窗口最大值)
 * 用双端队列，队列里记下标，队空或者比队尾小就入，大于等于队尾就一直弹出再入
 * 还要判断队头的下标还在不在滑动窗口中，不在了就出队
 */
public class Problem_07_SlidingWindowMaxArray {
    //标准答案
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static int[] getMaxWindowMy(int[] arr, int w) {
        if (null == arr || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> indexMaxQue = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int resIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            //若indexMaxQue不为空且队尾下标元素小于等于当前元素，从队尾弹出
            while (!indexMaxQue.isEmpty() && arr[indexMaxQue.peekLast()] <= arr[i]) {
                indexMaxQue.pollLast();
            }
            //当前下标入队
            indexMaxQue.addLast(i);
            //若indexMaxQue队首元素下标不在当前窗口中，出队
            while (!indexMaxQue.isEmpty() && indexMaxQue.peekFirst() + w <= i) {
                indexMaxQue.pollFirst();
            }
            //若当前已能够容下完整窗口，将队首元素放入最大值队列中
            if (w - i < 2) {
                res[resIndex++] = arr[indexMaxQue.peekFirst()];
            }
        }
        return res;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        printArray(getMaxWindow(arr, w));
        printArray(getMaxWindowMy(arr,w));

    }

}
