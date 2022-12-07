package com.smida.algrithm.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
class Solution206 {

    public ListNode reverseList(ListNode head) {
        return reverseList3(head);
    }

    //循环.pre，cur，next依次反转
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //把后边的链表反转
        ListNode reverseHead = reverseList2(head.next);
        //然后令下一个节点指回头
        head.next.next = head;
        //头作为新链表的尾，指向null
        head.next = null;
        return reverseHead;
    }

    //栈
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode pre = new ListNode(-1);
        cur = pre;
        while (!stack.isEmpty()) {
            ListNode n = stack.pop();
            cur.next = n;
            cur = cur.next;
        }
        cur.next = null;
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
