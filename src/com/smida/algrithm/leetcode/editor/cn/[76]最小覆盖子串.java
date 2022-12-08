package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution76 {
    public String minWindow(String str, String judge) {
        //初始化窗口计数 及 所需题目计数
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : judge.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        String res = "";
        int valid = 0;
        while (right < str.length()) {
            //右侧走到符合条件
            Character c = str.charAt(right);
            right++;
            //判断是否达到valid条件
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            //判断，把true改成缩小条件
            while (need.size() == valid) {
                //判断下valid的题设条件
                if (right - left < len) {
                    len = right - left;
                    res = str.substring(left, right);
                }
                //缩小窗口
                c = str.charAt(left);
                if (need.containsKey(c)) {
                    if (need.get(c).equals(window.get(c))) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }
                left++;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
