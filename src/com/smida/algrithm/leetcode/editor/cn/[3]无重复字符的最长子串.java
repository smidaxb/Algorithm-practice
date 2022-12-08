package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String str) {
        //初始化窗口计数 及 所需题目计数
        Set<Character> window = new HashSet<>();

        int left = 0, right = 0;
        int res = 0;
        int curCount = 0;
        while (right < str.length()) {
            Character c = str.charAt(right);
            right++;
            //判断是否达到valid条件
            while (window.contains(c)) {
                window.remove(str.charAt(left++));
                curCount--;
            }
            curCount++;
            window.add(c);
            res = curCount > res ? curCount : res;

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
