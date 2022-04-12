package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: s = "abcabcbb"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: s = "bbbbb"
 * //输出: 1
 * //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * //
 * //
 * // 示例 3:
 * //
 * //
 * //输入: s = "pwwkew"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 0 <= s.length <= 5 * 104
 * // s 由英文字母、数字、符号和空格组成
 * //
 * // Related Topics 哈希表 字符串 滑动窗口
 * // 👍 7358 👎 0
 */
public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new _3LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("tmmzuxt");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //Set判断重复，滑动窗口，记最大值和当前值，右移发现重复字符，则左边移动到相同字符后
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>(s.length());
            int l = 0, r = 0;
            int res = 0, cur = 0;
            while (r < s.length()) {
                Character c = s.charAt(r);
                if (set.contains(c)) {
                    while (!c.equals(s.charAt(l))) {
                        //不同字符走出窗口要从判重set中移除
                        set.remove(s.charAt(l));
                        l++;
                        cur--;
                    }
                    //同一个字符，窗口右端已经补上，不用减1
                    l++;
                } else {
                    set.add(c);
                    cur++;
                    res = cur > res ? cur : res;
                }
                r++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}