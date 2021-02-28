package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import com.smida.algrithm.Node;

/**
 * 给一个单链表中间的节点，不给表头，删除这个节点
 */
public class Problem_17_RemoveNodeWired {

	public static void removeNodeWired(Node node) {
		if (null == node) {
			return;
		}
		if (node.next == null) {
			throw new RuntimeException("can not del last node");
		}
		node.value = node.next.value;
		node.next = node.next.next;
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
		head.next = new Node(2);
		head.next.next = new Node(3);
		Node node = head;
		printLinkedList(head);
		removeNodeWired(node);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		node = head.next;
		printLinkedList(head);
		removeNodeWired(node);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		node = head.next.next;
		printLinkedList(head);
		removeNodeWired(node);
		printLinkedList(head);

	}

}
