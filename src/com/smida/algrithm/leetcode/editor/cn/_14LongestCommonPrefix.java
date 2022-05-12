package com.smida.algrithm.leetcode.editor.cn;

/**
 * 最长公共前缀
 * //编写一个函数来查找字符串数组中的最长公共前缀。
 * //
 * // 如果不存在公共前缀，返回空字符串 ""。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：strs = ["flower","flow","flight"]
 * //输出："fl"
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：strs = ["dog","racecar","car"]
 * //输出：""
 * //解释：输入不存在公共前缀。
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= strs.length <= 200
 * // 0 <= strs[i].length <= 200
 * // strs[i] 仅由小写英文字母组成
 * //
 * // Related Topics 字符串
 * // 👍 2234 👎 0
 */
public class _14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new _14LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (null == strs || strs.length == 0) {
                return "";
            }
            StringBuilder res = new StringBuilder("");
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                        return res.toString();
                    }
                }
                res.append(strs[0].charAt(i));
            }
            return res.toString();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}