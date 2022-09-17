package com.smida.algrithm.newCode.base.b07;

import java.util.PriorityQueue;

/**
 * 最小花费切金条
 * 给一个数组，里边是要切的金条分段长度，每切一次花费金钱为被切段的长度
 * <p>
 * 思路：用哈夫曼树，每次拿最短的两部分，算出花费再入树，循环
 *
 * @author YYF
 * @date 2022/9/17 18:12.
 */
public class P7LessCost {
    public static int method(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : arr) {
            heap.add(i);
        }
        int cost = 0;
        while (heap.size() > 1) {
            int val1 = heap.poll();
            int val2 = heap.poll();
            cost += val1 + val2;
            heap.add(val1 + val2);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9};
        System.out.println(method(arr));
    }
}
