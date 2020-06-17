package com.smida.algrithm.lettcode.tencent50;

import com.smida.algrithm.ListNode;

/**
 * 1.两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _002AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode head, pre = head = new ListNode(0);
        int preNum = 0;
        while (l1 != null || l2 != null || preNum != 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int val = num1 + num2 + preNum;
            preNum = 0;
            if (val >= 10) {
                preNum++;
                val = val % 10;
            }
            ListNode node = new ListNode(val);
            pre.next = node;
            pre = pre.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head.next;
    }

    public static void printList(ListNode node) {
        while (null != node) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(9);
        b.next = new ListNode(9);
        printList(a);
        printList(b);
        printList(addTwoNumbers(a, b));
    }
}
