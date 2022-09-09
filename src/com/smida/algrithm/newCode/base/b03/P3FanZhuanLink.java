package com.smida.algrithm.newCode.base.b03;

import com.smida.algrithm.DoubleNode;
import com.smida.algrithm.Node;

/**
 * 反转单向、双向链表
 * 要求空间复杂度1，时间复杂度n
 *
 * @author YYF
 * @date 2022/9/8 20:27.
 */
public class P3FanZhuanLink {
    /**
     * 反转单向链表
     * 要求时间复杂度n，空间复杂度1
     * 思路：搞pre,cur俩节点，pre指null,cur指表头，while(cur!=null) ne= cur.next cur.next=pre pre=cur cur=ne
     * 循环结束后 返回pre
     */
    public static Node ReverseNode(Node head) {
        Node pre = null;
        Node cur = head;
        while (null != cur) {
            Node ne = cur.next;
            cur.next = pre;
            pre = cur;
            cur = ne;
        }
        return pre;
    }

    /**
     * 反转双向链表
     * 要求时间复杂度n，空间复杂度1
     * 思路：搞pre,cur俩节点，pre指null,cur指表头,while(cur!=null)ne=cur.next cur.next=pre, cur.last=ne pre=cur cur=ne
     * 循环结束 cur.n=pre cur.p=null 处理好最后一个节点
     */
    public static DoubleNode ReverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode cur = head;
        while (null != cur) {
            DoubleNode ne = cur.next;
            cur.next = pre;
            cur.last = ne;
            pre = cur;
            cur = ne;
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
        head1 = ReverseNode(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(ReverseDoubleNode(head2));

    }
}
