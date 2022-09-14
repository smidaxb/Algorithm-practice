package com.smida.algrithm.newCode.base.b03;

import com.smida.algrithm.Node;

import static com.smida.algrithm.book_zuo.chapter_2_listproblem.Problem_08_ListPartition.swap;

/**
 * 荷兰国旗链表版
 * 思路：
 * 空间复杂度n：弄个数组，常规的荷兰国旗解法
 * 空间复杂度1：六个指针分别指向小于/等于/大于三个链表的头尾，最后再串起来
 *
 * @author YYF
 * @date 2022/9/13 17:19.
 */
public class P3NetherLandsFlagLinkList {
    public static Node methodN(Node head, Integer value) {
        //将链表放进数组
        int len = 0;
        Node cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        Node[] arr = new Node[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = head;
            head = head.next;
        }
        //常规荷兰国旗解法
        partition(arr, value);
        head = null;
        for (Node node : arr) {
            if (head == null) {
                head = node;
                cur = head;
            }else {
                cur.next = node;
                cur = cur.next;
            }
        }
        cur.next = null;
        return head;
    }


    private static void partition(Node[] arr, Integer value) {
        int less = -1;
        int big = arr.length;
        int curInd = 0;
        while (curInd != big) {
            if (arr[curInd].value == value) {
                curInd++;
            } else if (arr[curInd].value < value) {
                swap(arr,++less,curInd++);
            }else {
                swap(arr,--big,curInd);
            }
        }
    }


    public static Node method1(Node head, Integer value) {
        Node lh = null;
        Node lt= null;
        Node eh= null;
        Node et= null;
        Node bh= null;
        Node bt= null;
        Node cur = head;
        while (null != cur) {
            if (cur.value == value) {
                if (eh == null){
                    eh = cur;
                    et = cur;
                }else {
                    et.next = cur;
                    et = cur;
                }
            }else if (cur.value < value) {
                if (lh == null){
                    lh = cur;
                    lt = cur;
                }else {
                    lt.next = cur;
                    lt = cur;
                }
            }else {
                if (bh == null){
                    bh = cur;
                    bt = cur;
                }else {
                    bt.next = cur;
                    bt = cur;
                }
            }
            cur = cur.next;
        }
        head = new Node(0);
        cur = head;
        if (null != lh) {
            cur.next = lh;
            cur = lt;
        }
        if (null != eh) {
            cur.next = eh;
            cur=et;
        }
        if (null != bh) {
            cur.next = bh;
            cur = bt;
        }
        cur.next = null;
        return head.next;
    }



    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
//        head1 = methodN(head1, 5);
        head1 = method1(head1, 5);
        printLinkedList(head1);

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
