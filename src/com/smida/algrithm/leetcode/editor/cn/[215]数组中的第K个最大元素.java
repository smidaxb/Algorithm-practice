package com.smida.algrithm.leetcode.editor.cn;

import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution215 {

    public int findKthLargest(int[] nums, int k) {
//        return findKthLargest1(nums, k);
        return findKthLargest2(nums, k);
    }

    //解法一，用小顶堆
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    //解法二，用快排的partition找
    public int findKthLargest2(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        int p = partition(nums, l, r);
        k = nums.length - k;
        while (p != k) {
            if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
            p = partition(nums, l, r);
        }
        return nums[p];
    }

    //把 p 放中间，左边 <= p , 右边 > p
    private int partition(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int i = l, j = r;
        int p = nums[l];
        while (i < j) {
            //左指针移动到第一个比 p 大的位置
            while (i < r && nums[i] <= p) {
                i++;
            }
            //右指针移动到第一个 小于等于 p的位置
            while (j > l && nums[j] > p) {
                j--;
            }
            if (i < j) {
                //交换
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int tmp = nums[l];
        nums[l] = nums[j];
        nums[j] = tmp;
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
