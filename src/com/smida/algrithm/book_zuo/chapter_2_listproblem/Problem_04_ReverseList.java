package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.DoubleNode;
import com.smida.algrithm.Node;

/**
 * 翻转单/双向链表
 */
public class Problem_04_ReverseList {


    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node reverseListMy(Node head) {
        Node pre=null,next =null;
        Node cur = head;
        while (cur!=null){
            next = cur.next;
            cur.next=pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static DoubleNode reverseListMy(DoubleNode head) {
        DoubleNode pre=null,next =null;
        DoubleNode cur = head;
        while (cur!=null){
            next = cur.next;
            cur.next=pre;
            cur.last=next;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
//        printDoubleLinkedList(reverseList(head2));
        printDoubleLinkedList(reverseListMy(head2));

    }

}
