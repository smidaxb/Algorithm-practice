package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除单链表中值重复出现的节点
 * 用hash表，时间复杂度n
 */
public class Problem_13_RemoveRepeat {
    public static Node removeRepeat(Node head) {
        if (null == head) {
            return null;
        }
        Node p = head;
        Map<Integer, Integer> hashMap = new HashMap<>();
        Node pre = null;
        while (null != p) {
            if (null == hashMap.get(p.value)) {
                hashMap.put(p.value, p.value);
                pre = p;
            } else {
                if (p == head) {
                    head = head.next;
                }else{
                    pre.next = p.next;
                }
            }
            p = p.next;
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
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRepeat(head);
        printLinkedList(head);

    }
}
