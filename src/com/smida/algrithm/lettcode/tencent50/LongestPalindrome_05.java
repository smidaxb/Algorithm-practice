package com.smida.algrithm.lettcode.tencent50;

/**
 * 05最长回文字符串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome_05 {
    public static String longestPalindrome(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        String res = String.valueOf(s.charAt(0));
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int left = i;
            int right = i;
            while (right < s.length() - 1 && s.charAt(right + 1) == s.charAt(left)) {
                right++;
            }
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > max) {
                    res = s.substring(left, left + len);
                    max = len;
                }
                right++;
                left--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "avbbacccccaaacccccaaaa";
        System.out.println(longestPalindrome(a));
    }
}
