package com.smida.algrithm.leetcode.editor.cn;
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
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        //分组，比如k=2，b就要走到第3个
        for (int i = 0; i < k; i++) {
            //只有够k个才会翻转一次
            if (b==null){ return head;}
            b = b.next;
        }
        //翻转k个,得到新的头结点
        ListNode preGroupHead = reverse(a, b);
        //处理后续的链表，连接起来
        ListNode postGroupsHead = reverseKGroup(b,k);
        a.next = postGroupsHead;
        return preGroupHead;
    }

    //迭代反转链表head 到 b节点之间的节点,对比递归反转整个链表206，只是把null变成了b

    public ListNode reverse(ListNode head, ListNode b) {
        ListNode pre = null, cur = head;
        while (cur != b){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
