package com.smida.algrithm.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution160 {
    // 若是判断是否相交，返回交点，其实甚至可能有环的，两个链表有两个还的相交入口
    // 所以是要先判断是否有环，一个有一个没有肯定不相交
    // 都无环，看能不能走到一个终点，能的话俩链表长度一减，俩指针就能做题
    // 都有环，找一个环里的点，另一个环走一圈判断是否是同一个环，是同一个环，随便返回一个交点


    //本题已经确定有交点且无环，只看上边第三点后半段即可
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = getLen(headA);
        int lb = getLen(headB);
        ListNode longList, shortList;
        if (la > lb) {
            longList = headA;
            shortList = headB;
        } else {
            longList = headB;
            shortList = headA;
        }
        int n = Math.abs(la - lb);
        for (int i = 0; i < n; i++) {
            longList = longList.next;
        }
        while (longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }

    public int getLen(ListNode head) {
        if (null == head) {
            return 0;
        }
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    //方法二：
}
//leetcode submit region end(Prohibit modification and deletion)
