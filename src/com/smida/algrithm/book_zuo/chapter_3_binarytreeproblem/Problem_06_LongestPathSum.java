package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

import java.util.HashMap;

/**
 * 二叉树累加和最大长度
 */
public class Problem_06_LongestPathSum {
    

	public static int getMaxLength(TreeNode head, int sum) {
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		sumMap.put(0, 0); // important
		return preOrder(head, sum, 0, 1, 0, sumMap);
	}

	public static int preOrder(TreeNode head, int sum, int preSum, int level,
			int maxLen, HashMap<Integer, Integer> sumMap) {
		if (head == null) {
			return maxLen;
		}
		int curSum = preSum + head.value;
		if (!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}
		if (sumMap.containsKey(curSum - sum)) {
			maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
		}
		maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
		maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);
		if (level == sumMap.get(curSum)) {
			sumMap.remove(curSum);
		}
		return maxLen;
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
		String val = to + head.value + to;
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
		TreeNode head = new TreeNode(-3);
		head.left = new TreeNode(3);
		head.right = new TreeNode(-9);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(0);
		head.left.right.left = new TreeNode(1);
		head.left.right.right = new TreeNode(6);
		head.right.left = new TreeNode(2);
		head.right.right = new TreeNode(1);
		printTree(head);
//		System.out.println(getMaxLength(head, 2));
		System.out.println(getMaxLength(head, -9));

	}

}
