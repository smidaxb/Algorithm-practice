package com.smida.algrithm.leetcode.editor.cn;

import com.smida.algrithm.Node;

/**
 * //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * //
 * // 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * //
 * // 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * //
 * // 示例：
 * //
 * // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * //输出：7 -> 0 -> 8
 * //原因：342 + 465 = 807
 * //
 * // Related Topics 链表 数学
 */
public class _2AddTwoNumbers {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(9);
        b.next = new Node(9);
        printList(a);
        printList(b);
        Solution solution = new _2AddTwoNumbers().new Solution();
        printList(solution.addTwoNumbers(a, b));
    }
    public static void printList(Node node) {
        while (null != node) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public Node addTwoNumbers(Node l1, Node l2) {
            if (l1 == null || l2 == null) {
                return null;
            }
            Node head, pre = head = new Node(0);
            int preNum = 0;
            while (l1 != null || l2 != null || preNum != 0) {
                int num1 = l1 != null ? l1.value : 0;
                int num2 = l2 != null ? l2.value : 0;
                int val = num1 + num2 + preNum;
                preNum = 0;
                if (val >= 10) {
                    preNum++;
                    val = val % 10;
                }
                Node node = new Node(val);
                pre.next = node;
                pre = pre.next;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}