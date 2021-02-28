package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

/**
 * 删除单链表中值为k的节点
 */
public class Problem_14_RemoveGivenValue {
    public static Node removeGivenValue(Node head, int k) {
        if (null == head) {
            return null;
        }
        while (head.value == k) {
            head = head.next;
        }
        Node p = head;
        Node pre = head;
        while (null != p) {
            if (p.value == k) {
                pre.next = p.next;
            }else {
                pre = p;
            }
            p=p.next;
        }
        return head;
    }

    public static Node removeGivenValueMy(Node head, int k) {
        if (null == head) {
            return null;
        }
        Node p = head;
        Node pre = null;
        while (null != p) {
            if (p.value == k) {
                if (head == p) {
                    head = head.next;
                } else {
                    pre.next = p.next;
                    p = p.next;
                    continue;
                }
            }
            pre = p;
            p = p.next;
        }
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
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next = new Node(1);
        head = removeGivenValue(head, 3);
        printLinkedList(head);
    }
}
