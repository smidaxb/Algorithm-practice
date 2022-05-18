package com.smida.algrithm.leetcode.editor.cn;

import java.util.*;

/**
 * 合并K个升序链表
 * //给你一个链表数组，每个链表都已经按升序排列。
 * //
 * // 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * //输出：[1,1,2,3,4,4,5,6]
 * //解释：链表数组如下：
 * //[
 * //  1->4->5,
 * //  1->3->4,
 * //  2->6
 * //]
 * //将它们合并到一个有序链表中得到。
 * //1->1->2->3->4->4->5->6
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：lists = []
 * //输出：[]
 * //
 * //
 * // 示例 3：
 * //
 * // 输入：lists = [[]]
 * //输出：[]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // k == lists.length
 * // 0 <= k <= 10^4
 * // 0 <= lists[i].length <= 500
 * // -10^4 <= lists[i][j] <= 10^4
 * // lists[i] 按 升序 排列
 * // lists[i].length 的总和不超过 10^4
 * //
 * // Related Topics 链表 分治 堆（优先队列） 归并排序
 * // 👍 1948 👎 0
 */
public class _23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new _23MergeKSortedLists().new Solution();
        List<ListNode> listNodes = new ArrayList<>();
        ListNode head1 = new ListNode(-10);
        head1.next = new ListNode(-6);
        head1.next.next = new ListNode(-7);
        printLinkedList(head1);
        ListNode head2 = new ListNode(-10);
        head2.next = new ListNode(-8);
        head2.next.next = new ListNode(8);
        printLinkedList(head2);
//        ListNode head3 = new ListNode(1);
//        head3.next = new ListNode(2);
//        head3.next.next = new ListNode(3);
//        printLinkedList(head3);
        listNodes.add(head1);
        listNodes.add(head2);
//        listNodes.add(head3);
        printLinkedList(solution.mergeKLists1(new ListNode[]{head1,head2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void printLinkedList(ListNode head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    class Solution {
        //分治
        public ListNode mergeKLists(ListNode[] lists) {
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
            return mergeTwoLists(mergeKListsSpan(lists, left, mid), mergeKListsSpan(lists, mid + 1, right));
        }

        /**
         * 021合并两个有序链表
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (null == l1 || null == l2) {
                return null == l1 ? l2 : l1;
            }
            ListNode resPre = new ListNode(0);
            ListNode cur = resPre;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l1 != null || l2 != null) {
                ListNode tmp = l1 != null ? l1 : l2;
                while (tmp != null) {
                    cur.next = new ListNode(tmp.val);
                    cur = cur.next;
                    tmp = tmp.next;
                }
            }
            return resPre.next;
        }


        //用优先级队列
        class Status implements Comparable<Status> {
            int val;
            ListNode ptr;

            Status(int val, ListNode ptr) {
                this.val = val;
                this.ptr = ptr;
            }

            @Override
            public int compareTo(Status status2) {
                return this.val - status2.val;
            }
        }

        PriorityQueue<Status> queue = new PriorityQueue<Status>();

        public ListNode mergeKLists1(ListNode[] lists) {
            for (ListNode node: lists) {
                if (node != null) {
                    queue.offer(new Status(node.val, node));
                }
            }
            ListNode head = new ListNode(0);
            ListNode tail = head;
            while (!queue.isEmpty()) {
                Status f = queue.poll();
                tail.next = f.ptr;
                tail = tail.next;
                if (f.ptr.next != null) {
                    queue.offer(new Status(f.ptr.next.val, f.ptr.next));
                }
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}