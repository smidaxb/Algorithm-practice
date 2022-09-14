package com.smida.algrithm.newCode.base.b03;

import com.smida.algrithm.Node;

import java.util.Stack;

/**
 * 判断链表是否回文结构
 */
public class P3HuiWenLinkList {
	// 用栈，空间复杂n
	public static boolean isPalindrome1(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	//找到中点，后半段链表逆序，然后判断完再还原链表,空间复杂度1
	public static boolean isPalindromeMy(Node head){
		if (head == null || head.next == null) {
			return true;
		}
		boolean res = true;
		//找到中点
		Node fast = head,slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//反转后半截
		Node postCur = slow.next;
		slow.next = null;
		Node pre = null;
		while (postCur != null) {
			Node next = postCur.next;
			postCur.next = pre;
			pre = postCur;
			postCur = next;
		}
		//指针指向两头，判断
		postCur = pre;
		slow = head;
		while (postCur != null && slow != null) {
			if (postCur.value != slow.value) {
				res = false;
				break;
			}
			postCur = postCur.next;
			slow = slow.next;
		}
		//还原链表
		postCur = pre;
		pre = null;
		while (postCur != null) {
			Node next = postCur.next;
			postCur.next = pre;
			pre = postCur;
			postCur = next;
		}
		return res;
	}

	// need O(1) extra space
//	public static boolean isPalindrome3(Node head) {
//		if (head == null || head.next == null) {
//			return true;
//		}
//		Node n1 = head;
//		Node n2 = head;
//		//n1走到中点，n2走到终点
//		while (n2.next != null && n2.next.next != null) { // find mid node
//			n1 = n1.next;
//			n2 = n2.next.next;
//		}
//		n2 = n1.next; // n2 -> right part first node
//		n1.next = null; // mid.next -> null
//		Node n3 = null;
//		//后半段反转
//		while (n2 != null) { // right part convert
//			n3 = n2.next; // n3 -> save next node
//			n2.next = n1; // next of right node convert
//			n1 = n2; // n1 move
//			n2 = n3; // n2 move
//		}
//		n3 = n1; // n3 -> save last node
//		n2 = head;// n2 -> left first node
//		boolean res = true;
//		while (n1 != null && n2 != null) { // check palindrome
//			if (n1.value != n2.value) {
//				res = false;
//				break;
//			}
//			n1 = n1.next; // left to mid
//			n2 = n2.next; // right to mid
//		}
//		//判断完后还原
//		n1 = n3.next;
//		n3.next = null;
//		while (n1 != null) { // recover list
//			n2 = n1.next;
//			n1.next = n3;
//			n3 = n1;
//			n1 = n2;
//		}
//		return res;
//	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Node head = null;
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.println(isPalindromeMy(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.println(isPalindromeMy(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.println(isPalindromeMy(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.println(isPalindromeMy(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.println(isPalindromeMy(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.println(isPalindromeMy(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.println(isPalindromeMy(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.println(isPalindromeMy(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.println(isPalindromeMy(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}

}
