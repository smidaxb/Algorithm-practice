package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

/**
 * 删除链表中间节点和a/b处的节点
 */
public class Problem_03_RemoveNodeByRatio {


    public static Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / (double) b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static Node removeByRatioMy(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int length = 0;
        Node p = head;
        while (null != p) {
            length++;
            p = p.next;
        }
        if (length < 2) {
            return head;
        }
        double ratio = a * 1.0 / b;
        int toDexInd = 0;
        for (int i = 1; i <= length; i++) {
            if (ratio <= i * 1.0 / length) {
                toDexInd = i;
                break;
            }
        }
        if (toDexInd == 1) {
            head = head.next;
            return head;
        }
        p = head;
        while (toDexInd-- > 2) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }


    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        printLinkedList(head);
        head = removeByRatioMy(head, 1, 2);
        printLinkedList(head);
        head = removeByRatioMy(head, 2, 5);
        printLinkedList(head);
        head = removeByRatioMy(head, 1, 3);
        printLinkedList(head);

//        printLinkedList(head);
//        head = removeMidNode(head);
//        printLinkedList(head);
//        head = removeByRatio(head, 2, 5);
//        printLinkedList(head);
//        head = removeByRatio(head, 1, 3);
//        printLinkedList(head);


    }

}
