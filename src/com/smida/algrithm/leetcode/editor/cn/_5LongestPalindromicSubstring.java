package com.smida.algrithm.leetcode.editor.cn;

/**
 * 最长回文子串
 * //给你一个字符串 s，找到 s 中最长的回文子串。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：s = "babad"
 * //输出："bab"
 * //解释："aba" 同样是符合题意的答案。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：s = "cbbd"
 * //输出："bb"
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= s.length <= 1000
 * // s 仅由数字和英文字母组成
 * //
 * // Related Topics 字符串 动态规划
 * // 👍 5052 👎 0
 */
public class _5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new _5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("abccccdddadddbaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //马拉车太复杂，处理下简单中心扩展
        public String longestPalindrome(String s) {
            String T = preProcess(s);
            int n = T.length();
            int[] P = new int[n];
            for (int i = 0; i < n; i++) {
                int pv = 0;
                while ((i + pv) < n && (i - pv) >= 0 && T.charAt(i + pv) == T.charAt(i - pv)) {
                    P[i] = pv;
                    pv++;
                }
            }
            int ind = 0;
            int val = 0;
            for (int i = 0; i < n; i++) {
                if (P[i] > val) {
                    val = P[i];
                    ind = i;
                }
            }
            int start = (ind - val) / 2;
            int end = start + val;
            return s.substring(start, end);
        }

        // abc -->  ^#a#b#c#$
        public String preProcess(String s) {
            int n = s.length();
            if (n == 0) {
                return "^$";
            }
            String ret = "^";
            for (int i = 0; i < n; i++) {
                ret += "#" + s.charAt(i);
            }
            ret += "#$";
            return ret;
        }

        // 马拉车算法
        // i i_mirror 以C为中心的一对下标  i_mirror = 2 * C - i
        //T：改变后的原串  P：对应位置最大回文串长度  R：当前位置向右拓展半径  C：拓展中心
        public String longestPalindrome2(String s) {
            String T = preProcess(s);
            int n = T.length();
            int[] P = new int[n];
            int C = 0, R = 0;
            for (int i = 1; i < n - 1; i++) {
                int i_mirror = 2 * C - i;
                if (R > i) {
                    P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
                } else {
                    P[i] = 0;// 等于 R 的情况
                }

                // 碰到之前讲的三种情况时候，需要利用中心扩展法
                while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                    P[i]++;
                }

                // 判断是否需要更新 R
                if (i + P[i] > R) {
                    C = i;
                    R = i + P[i];
                }

            }

            // 找出 P 的最大值
            int maxLen = 0;
            int centerIndex = 0;
            for (int i = 1; i < n - 1; i++) {
                if (P[i] > maxLen) {
                    maxLen = P[i];
                    centerIndex = i;
                }
            }
            int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
            return s.substring(start, start + maxLen);
        }

        public String longestPalindrome3(String s) {
            if (null == s || s.length() < 2) {
                return s;
            }
            String res = "";
            int max = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                int left = i;
                int right = i;
                //直接把相同元素走完
                while (right < s.length() - 1 && s.charAt(right + 1) == s.charAt(left)) {
                    right++;
                }
                //接着再两头扩展
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}