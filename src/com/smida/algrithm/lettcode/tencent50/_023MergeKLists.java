package com.smida.algrithm.lettcode.tencent50;

import com.smida.algrithm.ListNode;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class _023MergeKLists {
    /**
     * 常规
     * O(m*n)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode resPre = new ListNode(0);
        ListNode cur = resPre;
        boolean[] empty = new boolean[lists.length];
        int emptySize = 0;
        while (emptySize < lists.length) {
            int min = Integer.MAX_VALUE;
            int minInd = -1;
            for (int i = 0; i < lists.length; i++) {
                if (empty[i]) {
                    continue;
                }
                ListNode l = lists[i];
                if (l == null) {
                    empty[i] = true;
                    emptySize++;
                    continue;
                }
                if (min > l.val) {
                    min = l.val;
                    minInd = i;
                }
            }
            if (minInd == -1) {
                return null;
            }
            lists[minInd] = lists[minInd].next;
            if (lists[minInd] == null) {
                empty[minInd] = true;
                emptySize++;
            }
            cur.next = new ListNode(min);
            cur = cur.next;
        }
        return resPre.next;
    }

    /**
     * 分治
     * O(log2(m)*n)
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int left = 0;
        int right = lists.length - 1;
        int mid = (left + right) / 2;
        ListNode l1 = mergeKLists2(lists, left, mid);
        ListNode l2 = mergeKLists2(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeKLists2(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = (left+right)/2;
        return mergeTwoLists(mergeKLists2(lists, left, mid), mergeKLists2(lists, mid + 1, right));
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
}
