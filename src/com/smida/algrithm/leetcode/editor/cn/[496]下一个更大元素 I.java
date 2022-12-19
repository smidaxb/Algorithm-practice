package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution496 {
    //用栈从后往前，记之前比当前大的数，没有就-1，并清空栈后入栈，有就栈顶，然后入栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] record = new int[nums2.length];
        int[] res = new int[nums1.length];
        //nums -> i
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack();
        for (int i = nums2.length - 1; i >= 0; i--) {
            map.put(nums2[i], i);
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                record[i] = stack.peek();
            }else {
                record[i] = -1;
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            res[i] = record[map.get(num)];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
