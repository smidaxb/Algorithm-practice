package com.smida.algrithm.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { thisO.val = val; this.next = next; }
 * }
 */
class Solution23 {
    //用小顶堆
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> smallHeap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (ListNode list : lists) {
            smallHeap.add(list);
        }

        ListNode pre = new ListNode(-1), p = pre;
        while (!smallHeap.isEmpty()) {
            p.next = smallHeap.poll();
            p = p.next;
            if (p.next != null) {
                smallHeap.add(p.next);
            }
        }
        return pre.next;
    }

    //分治
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int left = 0;
        int right = lists.length - 1;
        ListNode l1 = mergeKListsSpan(lists, left, right);
        return l1;
    }

    private ListNode mergeKListsSpan(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        return new Solution21().mergeTwoLists(mergeKListsSpan(lists, left, mid), mergeKListsSpan(lists, mid + 1, right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
