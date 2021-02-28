package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

/**
 * 单链表选择排序
 */
public class Problem_16_ListSelectionSort {
    public static Node selectionSort(Node head) {
        if (null == head) {
            return null;
        }
        Node headNew = null;
        Node p = head;
        Node p2 = null;
        while (p.next !=null) {
            Node smallest = p;
            Node smallestPre = null;
            Node pre = null;
            //记录最小节点及其前节点
            while (null != p) {
                if (p.value < smallest.value) {
                    smallest = p;
                    smallestPre = pre;
                }
                pre = p;
                p = p.next;
            }
            //若最小节点的前节点为空，说明头结点为最小节点；删掉最小节点，连至新链表后
            if (null == smallestPre) {
                head = head.next;
            } else {
                smallestPre.next = smallest.next;
            }
            if (null == headNew) {
                headNew = smallest;
                p2 = headNew;
            } else {
                p2.next = smallest;
                p2 = p2.next;
                p2.next = null;
            }
            //最后将p重置到起始位置
            p = head;
        }
        if (null == headNew) {
            return p;
        }
        p2.next = p;
        p.next = null;
        return headNew;
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
        Node head = null;
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head = selectionSort(head);
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);
        head = selectionSort(head);
        printLinkedList(head);

    }
}
