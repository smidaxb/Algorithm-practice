package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

/**
 * 打印有序链表的公有部分
 * 因为有序，则先比较两个链表，找到相同的第一项
 */
public class Problem_01_PrintSortedListCommonPart {

    //标准答案
    public static void printCommonPart(Node head1, Node head2) {
        System.out.print("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void printCommonPartMy(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return;
        }
        Node p1 = head1;
        Node p2 = head2;
        System.out.print("Common Part：");
        while (null != p1 && null != p2) {
            if (p1.value==p2.value){
                System.out.print(p1.value+" ");
            } else if (p1.value > p2.value) {
                p2=p2.next;
                continue;
            }
            p1=p1.next;
        }
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(6);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);
        printCommonPartMy(node1,node2);
    }
}
