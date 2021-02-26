package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

/**
 * 两个单链表相交的一系列问题
 * 两表有可能有环，有可能无环，有可能相交，有可能不相交
 * 相交返回节点，不想交返回null
 */
public class Problem_11_FindFirstIntersectNode {
    public static Node findFirstIntersectNode(Node head1, Node head2) {
        //首先判断两链表是否有环
        boolean h1Circle = haveCircle(head1);
        boolean h2Circle = haveCircle(head2);
        //一个有环一个无环必不相交
        if (h1Circle != h2Circle) {
            return null;
        }
        //若有环,找出环开始的初始节点
        Node c = null;
        if (!h1Circle) {
            c = getCircleFirstNode(head1);
        }
        int l1 = 0, l2 = 0;
        Node p1 = head1, p2 = head2;
        while (p1 != c) {
            l1++;
            p1 = p1.next;
        }
        while (p2 != c) {
            l2++;
            p2 = p2.next;
        }
        int headStep = l1 - l2;
        Node lh,sh;
        if (headStep >= 0) {
            
        }
        return null;
    }

    //是否有环
    public static boolean haveCircle(Node head) {
        if (null == head) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //找出环开始的节点
    public static Node getCircleFirstNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
