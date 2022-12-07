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
class Solution234 {
    //思路一，弄个栈
    //思路二，将链表后半段反转，俩指针走一轮判断完再反转回来
    //思路三，直接用系统栈，递归走到最后一个节点，将其与第一个节点比较，然后栈往上走，第一个节点往next走
    ListNode judgeHead;

    public boolean isPalindrome(ListNode head) {
        judgeHead = head;
        return isPalindromeSub(head);
    }

    public boolean isPalindromeSub(ListNode curHead) {
        if (curHead == null) {
            return true;
        }
        boolean res = isPalindromeSub(curHead.next);
        res = res && judgeHead.val == curHead.val;
        judgeHead = judgeHead.next;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
