package com.smida.algrithm.leetcode.editor.cn;
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
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return reverseBetweenCur(head, left, right);
    }

    //递归解法，转化为 left位置前的链表，连上 从left位置开始反转前 r-l 个节点的链表
    public ListNode reverseBetweenCur(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseNList(head, right - left + 1);
        }
        ListNode reverseHead = reverseBetween(head.next, left - 1, right - 1);
        head.next = reverseHead;
        return head;
    }

    //递归反转链表前n个节点,对比递归反转整个链表206，就只是base case变成了判断是不是第n个节点
    ListNode next;

    public ListNode reverseNList(ListNode head, int n) {
        if (n == 1) {
            next = head.next;
            return head;
        }
        //把后n-1个链表节点反转
        ListNode reverseHead = reverseNList(head.next, n - 1);
        //然后令下一个节点指回头
        head.next.next = head;
        //头作为反转部分链表的尾，指向原next
        head.next = next;
        return reverseHead;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
