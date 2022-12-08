package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 滑动窗口算法模板
 *
 * @author YYF
 * @date 2022-12-08 18:08
 */
public class SlideWindow {
    public void slideWindowHandle(String str,String judge) {
        //初始化窗口计数 及 所需题目计数
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : judge.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0,right =0;
        int valid = 0;
        while (right < str.length()) {
            Character c = str.charAt(right);
            right++;
            //判断是否达到valid条件
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            //判断，把true改成缩小条件
            while (true){
                //判断下valid与题设条件
                //...

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
    }
}
