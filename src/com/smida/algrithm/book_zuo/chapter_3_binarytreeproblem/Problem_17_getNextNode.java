package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

/**
 * 找一个节点的二叉树中序遍历的后继节点
 * 简单解法：找父节点一直找到根节点，然后中序遍历存起来，找下一个就好
 * 最优解：1、该节点有右子树，找右子树最左边的节点
 * 2、没有右子树 ：
 * 2-1 该节点是父节点的左子树，返回父节点
 * 2-2 该节点是父节点的右子树，找到父节点s和爷爷节点p，若s是p的左子树，返回p，否则一直往上找
 */
public class Problem_17_getNextNode {
    private static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }
    //标准答案
    public static Node getNextNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //My
    public static Node getNextNodeMy(Node node) {
        if (node == null) {
            return node;
        }
        if (null != node.right) {
            return getLeftMostMy(node.right);
        }
        Node parent = node.parent;
        while (null !=parent && parent.left != node) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    public static Node getLeftMostMy(Node node) {
        if (node == null) {
            return node;
        }
        while (null != node.left) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + getNextNodeMy(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + getNextNodeMy(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + getNextNodeMy(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + getNextNodeMy(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + getNextNodeMy(test).value);
        test = head;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + getNextNodeMy(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + getNextNodeMy(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + getNextNodeMy(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        System.out.println(test.value + " next: " + getNextNodeMy(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getNextNode(test));
        System.out.println(test.value + " next: " + getNextNodeMy(test));
    }
}
