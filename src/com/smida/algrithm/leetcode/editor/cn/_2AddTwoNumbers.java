package com.smida.algrithm.leetcode.editor.cn;


import java.util.Objects;

/**
 * 两数相加
 * //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * //
 * // 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * //
 * // 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：l1 = [2,4,3], l2 = [5,6,4]
 * //输出：[7,0,8]
 * //解释：342 + 465 = 807.
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：l1 = [0], l2 = [0]
 * //输出：[0]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * //输出：[8,9,9,9,0,0,0,1]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 每个链表中的节点数在范围 [1, 100] 内
 * // 0 <= Node.val <= 9
 * // 题目数据保证列表表示的数字不含前导零
 * //
 * // Related Topics 递归 链表 数学
 * // 👍 7867 👎 0
 */
public class _2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new _2AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode ln = solution.addTwoNumbers(l1, new ListNode(9));
        System.out.println(ln);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //挺像归并排序的，两个链表一块走完，最后有进位的话再加一个节点就行
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int preSum = 0;
            ListNode head = new ListNode();
            ListNode preNode = head;
            while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
                int v1 = Objects.isNull(l1) ? 0 : l1.val;
                int v2 = Objects.isNull(l2) ? 0 : l2.val;
                int sum = v1 + v2 + preSum;
                if (sum > 9) {
                    preSum = 1;
                } else {
                    preSum = 0;
                }
                ListNode cur = new ListNode(sum % 10);
                preNode.next = cur;
                preNode = cur;
                if (Objects.nonNull(l1)) {
                    l1 = l1.next;
                }
                if (Objects.nonNull(l2)) {
                    l2 = l2.next;
                }
            }
            if (preSum > 0) {
                preNode.next = new ListNode(preSum % 10);
            } else {
                preNode.next = null;
            }
            return head.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}