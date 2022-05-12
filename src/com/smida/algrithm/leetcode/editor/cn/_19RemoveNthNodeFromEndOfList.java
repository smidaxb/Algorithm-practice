package com.smida.algrithm.leetcode.editor.cn;

import com.smida.algrithm.Node;

/**
 * 删除链表的倒数第 N 个结点
 * //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：head = [1,2,3,4,5], n = 2
 * //输出：[1,2,3,5]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：head = [1], n = 1
 * //输出：[]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：head = [1,2], n = 1
 * //输出：[1]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 链表中结点的数目为 sz
 * // 1 <= sz <= 30
 * // 0 <= Node.val <= 100
 * // 1 <= n <= sz
 * //
 * //
 * //
 * //
 * // 进阶：你能尝试使用一趟扫描实现吗？
 * // Related Topics 链表 双指针
 * // 👍 2026 👎 0
 */
public class _19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new _19RemoveNthNodeFromEndOfList().new Solution();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        printLinkedList(head1);
        printLinkedList(solution.removeNthFromEnd(head1,1));
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
    public static void printLinkedList(ListNode head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    class Solution {
        //toRemovePre会指向待删除的前一个节点，当前指针初始值为head
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode cur = head;
            ListNode toRemovePre = null;
            int step = 1;
            while (cur.next != null) {
                //等于n时令toRemovePre指向head，
                if (step == n) {
                    toRemovePre = head;
                } else if (step > n) {
                    //之后每一步也前进一步
                    toRemovePre = toRemovePre.next;
                }
                cur = cur.next;
                //step初始值为1，cur每前进一步step+1，循环走完为链表长度
                step++;
            }
            //若toRemovePre有值，移除后续一个节点
            if (null != toRemovePre) {
                toRemovePre.next = toRemovePre.next.next;
            } else if (step == n) {
                //若要删除的是头结点，特殊处理
                head = head.next;
            }
            return head;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}