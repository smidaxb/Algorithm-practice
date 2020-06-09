package com.smida.algrithm.lettcode;

import com.smida.algrithm.ListNode;

/**
 * @author Created by YangYifan on 2020/6/9.
 */
public class TencentTop50 {
    /**
     * 1.两数相加
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        int val1 = 0;
        int bit1 = 0;
        while (l1 != null) {
            if (bit1 == 0) {
                val1 += l1.val;
                continue;
            }
            val1 += l1.val * 10 * bit1;
            bit1++;
        }
        int val2 = 0;
        int bit2 = 0;
        while (l2 != null) {
            if (bit2 == 0) {
                val2 += l2.val;
                continue;
            }
            val2 += l2.val * 10 * bit2;
            bit2++;
        }
        int sum = val1 + val2;
        String sumStr = String.valueOf(sum);
        ListNode resPre, pre = resPre = new ListNode(0);
        for (int i = sumStr.length() - 1; i >= 0; i++) {
            ListNode node = new ListNode(sumStr.charAt(i) - '0');
            pre.next = node;
            pre = pre.next;
        }
        return resPre.next;
    }
}
