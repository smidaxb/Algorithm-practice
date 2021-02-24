package com.smida.algrithm.lettcode.tencent50;

import com.smida.algrithm.Node;

/**
 * 1.两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _002AddTwoNumbers {

    public static Node addTwoNumbers(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        Node head, pre = head = new Node(0);
        int preNum = 0;
        while (l1 != null || l2 != null || preNum != 0) {
            int num1 = l1 != null ? l1.value : 0;
            int num2 = l2 != null ? l2.value : 0;
            int val = num1 + num2 + preNum;
            preNum = 0;
            if (val >= 10) {
                preNum++;
                val = val % 10;
            }
            Node node = new Node(val);
            pre.next = node;
            pre = pre.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head.next;
    }

    public static void printList(Node node) {
        while (null != node) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(9);
        b.next = new Node(9);
        printList(a);
        printList(b);
        printList(addTwoNumbers(a, b));
    }
}
