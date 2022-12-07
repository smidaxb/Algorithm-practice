package com.smida.algrithm.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //删除倒数第n个，就要找到倒数第n+1个节点，然后把next删了就行
        ListNode res = head,pre = head,fast = head;
        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
