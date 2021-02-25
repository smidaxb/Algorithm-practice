package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

/**
 * 翻转部分单链表
 * pre=from-1，post=to+1
 * 翻转后，让pre.next = new head,new tail.next=post
 */
public class Problem_05_ReversePartList {

    //标准答案
    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    //My
    public static Node reversePartMy(Node head, int from, int to) {
        Node p = head;
        int len = 0;
        Node pre = null;
        Node post = null;
        while (null != p) {
            len++;
            //初始化pre和post
            pre = (from - 1 == len) ? p : pre;
            post = (to + 1 == len) ? p : post;
            p = p.next;
        }
        if (null == head || from < 1 || to > len) {
            return head;
        }
        //使node1为from
        Node node1 = null != pre ? pre.next : head;
        p = node1.next;
        Node next = null;
        //使from.next = post
        node1.next = post;
        //翻转部分，翻转后node1走到了to
        while (p != post) {
            next = p.next;
            p.next = node1;
            node1 = p;
            p = next;
        }
        //pre==null，则from从head开始，此时to即是新head
        if (null == pre) {
            return node1;
        }
        //令pre.next = to,返回原head
        pre.next = node1;
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
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = reversePartMy(head1, 1, 3);
        printLinkedList(head1);
        head1 = reversePartMy(head1, 2, 3);
        printLinkedList(head1);

    }

}
