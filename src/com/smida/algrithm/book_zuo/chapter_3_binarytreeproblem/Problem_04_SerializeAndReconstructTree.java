package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树序列化反序列化
 * 比如   1
 *   2       3
 * 4   5        6
 * 前序序列化：1!2!4!5!3!#!6!
 * 层次序列化：1!2!3!4!5!#!6!
 */
public class Problem_04_SerializeAndReconstructTree {
    

	public static String serialByPre(TreeNode head) {
		if (head == null) {
			return "#!";
		}
		String res = head.val + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}

	public static TreeNode reconByPreString(String preStr) {
		String[] values = preStr.split("!");
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i != values.length; i++) {
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}

	public static TreeNode reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		TreeNode head = new TreeNode(Integer.valueOf(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}

	public static String serialByLevel(TreeNode head) {
		if (head == null) {
			return "#!";
		}
		String res = head.val + "!";
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			if (head.left != null) {
				res += head.left.val + "!";
				queue.offer(head.left);
			} else {
				res += "#!";
			}
			if (head.right != null) {
				res += head.right.val + "!";
				queue.offer(head.right);
			} else {
				res += "#!";
			}
		}
		return res;
	}

	public static TreeNode reconByLevelString(String levelStr) {
		String[] values = levelStr.split("!");
		int index = 0;
		TreeNode head = generateTreeNodeByString(values[index++]);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (head != null) {
			queue.offer(head);
		}
		TreeNode node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateTreeNodeByString(values[index++]);
			node.right = generateTreeNodeByString(values[index++]);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return head;
	}

	public static TreeNode generateTreeNodeByString(String val) {
		if (val.equals("#")) {
			return null;
		}
		return new TreeNode(Integer.valueOf(val));
	}

	// for test -- print tree
	public static void printTree(TreeNode head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(TreeNode head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.val + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		TreeNode head = null;
		printTree(head);

		String pre = serialByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByPreString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);

		String level = serialByLevel(head);
		System.out.println("serialize tree by level: " + level);
		head = reconByLevelString(level);
		System.out.print("reconstruct tree by level, ");
		printTree(head);

		System.out.println("====================================");

		head = new TreeNode(1);
		printTree(head);

		pre = serialByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByPreString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);

		level = serialByLevel(head);
		System.out.println("serialize tree by level: " + level);
		head = reconByLevelString(level);
		System.out.print("reconstruct tree by level, ");
		printTree(head);

		System.out.println("====================================");

		head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.right.right = new TreeNode(5);
		printTree(head);

		pre = serialByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByPreString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);

		level = serialByLevel(head);
		System.out.println("serialize tree by level: " + level);
		head = reconByLevelString(level);
		System.out.print("reconstruct tree by level, ");
		printTree(head);

		System.out.println("====================================");

		head = new TreeNode(100);
		head.left = new TreeNode(21);
		head.left.left = new TreeNode(37);
		head.right = new TreeNode(-42);
		head.right.left = new TreeNode(0);
		head.right.right = new TreeNode(666);
		printTree(head);

		pre = serialByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByPreString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);

		level = serialByLevel(head);
		System.out.println("serialize tree by level: " + level);
		head = reconByLevelString(level);
		System.out.print("reconstruct tree by level, ");
		printTree(head);

		System.out.println("====================================");

	}
}
