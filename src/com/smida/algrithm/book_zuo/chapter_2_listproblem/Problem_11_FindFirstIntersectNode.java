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
        //若有环,找出环开始的初始节点,否则以null为终点
        Node c = null;
        if (h1Circle) {
            c = getCircleFirstNode(head1);
            Node c2 = getCircleFirstNode(head2);
            boolean sameCircle = judgeSameCircle(c, c2);
            //若不是一个环，说明不相交
            if (!sameCircle) {
                return null;
            } else if (c != c2) {//若是一个环，且俩入环口不一样，返回链表二的入环口
                return c2;
            }
        }
        //l1 l2分别为链表长度(两无环)或到环起始节点长度(两有环)
        int l1 = 0, l2 = 0;
        Node p1 = head1, p2 = head2;
        while (p1 != c && null != p1) {
            l1++;
            p1 = p1.next;
        }
        while (p2 != c && null != p2) {
            l2++;
            p2 = p2.next;
        }
        int headStep = l1 - l2;
        Node lh = head1, sh = head2;
        if (headStep < 0) {
            lh = head2;
            sh = head1;
        }
        int step = 0;
        while (step < Math.abs(l1 - l2)) {
            lh = lh.next;
            step++;
        }
        step = 0;
        int shortLen = l1 < l2 ? l1 : l2;
        while (null != lh && null != sh && step < shortLen) {
            if (lh == sh) {
                return lh;
            }
            lh = lh.next;
            sh = sh.next;
            step++;
        }
        return null;
    }

    private static boolean judgeSameCircle(Node c, Node c2) {
        Node p = c.next;
        while (p != c) {
            if (p == c2) {
                return true;
            }
            p = p.next;
        }
        return c == c2;
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
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(findFirstIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(findFirstIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(findFirstIntersectNode(head1, head2).value);

        System.out.println();
    }
}
