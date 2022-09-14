package com.smida.algrithm.newCode.base.b03;

import com.smida.algrithm.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表相交一系列问题
 * 1、判断是否有环，是则返回环出口
 * 2、判断是否相交，是则返回第一个相交点 2-1判断俩无环链表... 2-2判断俩有环链表...
 *
 * @author YYF
 * @date 2022/9/13 23:45.
 */
public class P3TwoLinkJoin {
    //1-1用map判断是否有环，有则返回环出口
    public static Node getLoopWithMap(Node head) {
        //遍历，将已有节点存在一个set中，若遍历到了null则无环，否则第一个已存在的节点即为环入口
        Set<Node> set = new HashSet<>();
        Node cur = head;
        while (null != cur) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur=cur.next;
        }
        return null;
    }

    //1-2 俩指针一个走快(两步一次)一个走慢(一步一次)，若有环两指针会相遇
    // 此时让快指针从链表头一次一步的走，两指针将在环入口相遇
    public static Node getLoop(Node head) {
        Node fast = head, slow = head;
        boolean beLoop = false;
        //判断是否有环
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                beLoop = true;
                break;
            }
        }
        //找环入口点
        if (beLoop) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }

    //2判断相交，返回交点
    public static Node judgeJoin(Node h1, Node h2) {
        if (null == h1 || null == h2) {
            return null;
        }
        //判断是否有环
//        Node loop1 = getLoopWithMap(h1);
        Node loop1 = getLoop(h1);
        Node loop2 = getLoop(h2);
        //一个有环一个无环，不可能相交
        if ((null != loop1 && null == loop2) || (null == loop1 && null != loop2)) {
            return null;
        }
        //两个都无环，2-1
        if (null == loop1 && null == loop2) {
//           return judgeJoinNoLoopWithMap(h1, h2);
            return judgeJoinNoLoop(h1, h2);
        }
        //两个都有环，2-2
        return judgeJoinLoop(h1, loop1, h2, loop2);
    }


    //2-1-1 判断无环链表的交点，用map
    //搞个set存h1所有节点，挨个遍历h2，第一个包含的就是相交点
    private static Node judgeJoinNoLoopWithMap(Node h1, Node h2) {
        Set<Node> set = new HashSet<>();
        Node cur = h1;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = h2;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //2-1-2 判断无环链表的交点
    //先计算俩链表的长度，然后长的那条先走几步，之后一直走到结束，碰到相同即相交
    private static Node judgeJoinNoLoop(Node h1, Node h2) {
        Node cur = h1;
        int len1 = 0, len2 = 0;
        while (cur != null) {
            len1++;
            cur = cur.next;
        }
        cur = h2;
        while (cur != null) {
            len2++;
            cur = cur.next;
        }
        int abs = Math.abs(len1 - len2);
        Node hLong = h1;
        Node hShort = h2;
        if (len1 < len2) {
            hLong = h2;
            hShort = h1;
        }
        while (abs != 0) {
            hLong = hLong.next;
            abs--;
        }
        while (hLong != null && hShort != null) {
            if (hLong == hShort) {
                return hLong;
            }
            hLong = hLong.next;
            hShort = hShort.next;
        }
        return null;
    }

    // 2-2有环链表判断相交
    private static Node judgeJoinLoop(Node h1, Node loop1, Node h2, Node loop2) {
        //若俩入口一样，说明同一个环，将入口看做最后一个节点，剩余部分同无环判断相交
        if (loop1 == loop2) {
            Node tmp = loop1.next;
            //令入口指向null，变成两个无环链表，判断后还原
            loop1.next = null;
            Node res =  judgeJoinNoLoop(h1, h2);
//            Node res =  judgeJoinNoLoopWithMap(h1, h2);
            loop1.next = tmp;
            return res;
        }
        //不一样的话，将其中一个入口走一圈，看看有没有和另一个入口相等的时候，有则随便返回一个入口
        Node cur = loop1;
        do {
            if (cur == loop2) {
                return loop1;
            }
            cur = cur.next;
        } while (cur != loop1);

        return null;
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
        System.out.println(judgeJoin(head1, head2).value);

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
        System.out.println(judgeJoin(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(judgeJoin(head1, head2).value);

    }
}
