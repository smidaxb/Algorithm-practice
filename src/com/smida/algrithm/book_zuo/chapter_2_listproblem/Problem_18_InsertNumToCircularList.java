package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

/**
 * 向升序单循环链表插入值为num的节点
 */
public class Problem_18_InsertNumToCircularList {


    public static Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }

    public static Node insertNumMy(Node head, int num) {
        Node n = new Node(num);
        if (null == head) {
        	n.next = n;
            return n;
        }
        Node p = head;
        while (p.next != head) {
            p = p.next;
        }
        Node end = p;
		if (num > end.value) {
			n.next = end.next;
			end.next = n;
			return head;
		}
        while (true) {
            if (p.next.value < num) {
                p = p.next;
            } else {
                n.next = p.next;
                p.next = n;
                break;
            }
        }
		if (n.next == head) {
			return n;
		}
		return head;
    }

    public static void printCircularList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNum(head, 2);
        printCircularList(head);
        head = insertNum(head, 1);
        printCircularList(head);
        head = insertNum(head, 4);
        printCircularList(head);
        head = insertNum(head, 3);
        printCircularList(head);
        head = insertNum(head, 5);
        printCircularList(head);
        head = insertNum(head, 0);
        printCircularList(head);

    }

}
