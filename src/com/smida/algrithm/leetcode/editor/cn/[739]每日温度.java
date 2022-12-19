package com.smida.algrithm.leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution739 {
    //原理同496
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indStack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= temperatures[i]) {
                stack.pop();
                indStack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = indStack.peek() - i;
            }else {
                res[i] = 0;
            }
            stack.push(temperatures[i]);
            indStack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
