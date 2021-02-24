package com.smida.algrithm.book_zuo.chapter_1_stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈结构
 * 找出一个数组各个位置下，该位置两边距离最近的小于该位置数字的下标，无则为-1
 * 用栈，栈顶->栈底从大到小，存下标，出栈时出栈元素下方即为左小位置，当前位置即为右小位置
 */
public class Problem_08_SortStack {
    //数组中元素不重复
    public static int[][] getNearLessNoRepeat(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int index = stack.pop();
                int leftLessInd = stack.isEmpty() ? -1 : stack.peek();
                res[index][0] = leftLessInd;
                res[index][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int leftLessInd = stack.isEmpty() ? -1 : stack.peek();
            res[index][0] = leftLessInd;
            res[index][1] = -1;
        }
        return res;
    }

    //数组中元素重复
    public static int[][] getNearLessRepeat(int[] arr) {
        if (null == arr || arr.length < 1) {
            return null;
        }
        Stack<List<Integer>> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> indexList = stack.pop();
                int leftLessInd = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer index : indexList) {
                    res[index][0] = leftLessInd;
                    res[index][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> indexList = stack.pop();
            int leftLessInd = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer index : indexList) {
                res[index][0] = leftLessInd;
                res[index][1] = -1;
            }
        }
        return res;
    }

    public static void printArr(int[][] arr) {
        System.out.println("{");
        for (int i = 0; i < arr.length; i++) {
            int[] innerArr = arr[i];
            System.out.print("{");
            for (int j = 0; j < innerArr.length; j++) {
                System.out.print("[" + innerArr[j] + "]");
            }
            System.out.print("}");
            System.out.println();
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 4, 1, 5, 6, 2, 7};
        int[] arr2 = new int[]{3, 1, 3, 4, 3, 5, 3, 2, 2};
        printArr(getNearLessNoRepeat(arr1));
        printArr(getNearLessRepeat(arr2));
    }
}
