package com.smida.algrithm.leetcode.editor.cn;

import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    //用两个堆，大顶堆放小值，小顶堆放大值，每放一个数调整两堆元素个数相等或大顶堆多一个，中位数就是大顶堆顶，或两堆顶平均值
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.size()==0 || num <= maxHeap.peek()) {
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }
        adjust();
    }

    private void adjust() {
        while (maxHeap.size() > minHeap.size() + 1) {
            Integer num = maxHeap.poll();
            minHeap.add(num);
        }
        while (maxHeap.size() < minHeap.size()) {
            Integer num = minHeap.poll();
            maxHeap.add(num);
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
