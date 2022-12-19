package com.smida.algrithm.leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution503 {
    //同496，循环数组把原数组跑两次就行了
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int[] record = new int[nums.length * 2];
        int[] numsArr = new int[nums.length * 2];
        for (int i = 0; i < numsArr.length; i++) {
            numsArr[i] = nums[i % nums.length];
        }
        for (int i = numsArr.length-1; i >=0 ; i--) {
            while (!stack.isEmpty() && numsArr[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                record[i] = stack.peek();
            }else {
                record[i] = -1;
            }
            stack.push(numsArr[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = record[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
