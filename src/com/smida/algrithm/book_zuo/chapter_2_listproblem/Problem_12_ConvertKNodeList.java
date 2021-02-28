package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

import java.util.Stack;

/**
 * 翻转单链表每k个节点
 */
public class Problem_12_ConvertKNodeList {
    //用栈，k空间复杂度
    public static Node convertKNodeList1(Node head, int k) {
        if (null == head || k < 1) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        int step = 0;
        Node p = head;
        Node node = null;
        while (null != p) {
            step++;
            stack.push(p);
            p = p.next;
            if (step % k == 0||null==p) {
                while (!stack.isEmpty()) {
                    if (null == node) {
                        head = stack.peek();
                        node = stack.pop();
                    } else {
                        node.next = stack.pop();
                        node=node.next;
                    }
                }
                node.next=null;
            }
        }
        return head;
    }

    //1空间复杂度
    public static Node convertKNodeList2(Node head, int k) {
        if (null == head || k < 1) {
            return head;
        }
        int step = 0;
        Node pre = null;
        Node cur = head;
        Node next;
        Node preLast=null;
        Node partLast=null;
        head = null;
        while (null != cur) {
            //partList 保存单轮k步中的第一个节点
            if (step % k == 0) {
                partLast = cur;
            }
            step++;
            //将当前节点cur倒序指向前节点pre，并将pre，cur依次后移一步
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            //走完单轮k步或走到队尾时，此时pre走到了单轮头节点，令上一轮的尾部指向该轮头结点
            if (step % k == 0||null == cur) {
                if (head == null) {
                    head = pre;
                }else {
                    preLast.next = pre;
                }
                //保存尾结点，并令pre为空进行下一轮
                preLast = partLast;
                pre = null;
            }
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
        Node head = null;
        int K = 3;
        printLinkedList(head);
        head = convertKNodeList1(head, K);
        printLinkedList(head);
        head = convertKNodeList2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        K = 3;
        printLinkedList(head);
        head = convertKNodeList1(head, K);
        printLinkedList(head);
        head = convertKNodeList2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 2;
        printLinkedList(head);
        head = convertKNodeList1(head, K);
        printLinkedList(head);
        head = convertKNodeList2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 3;
        printLinkedList(head);
        head = convertKNodeList1(head, K);
        printLinkedList(head);
        head = convertKNodeList2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        K = 2;
        printLinkedList(head);
        head = convertKNodeList1(head, K);
        printLinkedList(head);
        head = convertKNodeList2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        K = 3;
        printLinkedList(head);
        head = convertKNodeList1(head, K);
        printLinkedList(head);
        head = convertKNodeList2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

    }
}
