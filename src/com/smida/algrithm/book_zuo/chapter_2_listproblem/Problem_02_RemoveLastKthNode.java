package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.DoubleNode;
import com.smida.algrithm.Node;

/**
 * 单、双向链表中，删除倒数第k个节点
 * 搞两个指针，后指针走完第k步时，前指针开始走
 */
public class Problem_02_RemoveLastKthNode {


    public static Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }

    public static Node removeLastKthNodeMy(Node head, int lastKth) {
        if (null == head || lastKth < 1) {
            return null;
        }
        Node pre = head;
        Node post = null;
        int count = 0;
        while (pre != null) {
            pre = pre.next;
            if (count == lastKth) {
                post = head;
            }
            if (null != post) {
                post = post.next;
            }
            count++;
        }
        if (null == post) {
            head = head.next;
            return head;
        }
        post.next = post.next.next;
        return head;
    }

    public static DoubleNode removeLastKthNodeMY(DoubleNode head, int lastKth) {
        if (null == head || lastKth < 1) {
            return null;
        }
        DoubleNode pre = head;
        DoubleNode post = null;
        int count = 0;
        while (pre != null) {
            pre = pre.next;
            if (count == lastKth) {
                post = head;
            }
            if (null != post) {
                post = post.next;
            }
            count++;
        }
        if (null == post) {
            head = head.next;
            if (null != head.next) {
                head.next.last = head;
            }
            return head;
        }
        post.next = post.next.next;
        if (null != post.next) {
            post.next.last = post;
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
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        printLinkedList(head1);
//        head1 = removeLastKthNode(head1, 3);
        head1 = removeLastKthNodeMy(head1, 3);
        // head1 = removeLastKthNode(head1, 6);
        // head1 = removeLastKthNode(head1, 7);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        head2.next.next.next.next = new DoubleNode(5);
        head2.next.next.next.next.last = head2.next.next.next;
        head2.next.next.next.next.next = new DoubleNode(6);
        head2.next.next.next.next.next.last = head2.next.next.next.next;
        printDoubleLinkedList(head2);
//        head2 = removeLastKthNode(head2, 3);
        head2 = removeLastKthNodeMY(head2, 3);
        // head2 = removeLastKthNode(head2, 6);
        // head2 = removeLastKthNode(head2, 7);
        printDoubleLinkedList(head2);

    }

}
