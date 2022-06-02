package com.smida.algrithm.leetcode.editor.cn;

import javax.xml.stream.FactoryConfigurationError;
import java.util.HashMap;
import java.util.Map;

/**
 * 通配符匹配
 * //给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * //
 * // '?' 可以匹配任何单个字符。
 * //'*' 可以匹配任意字符串（包括空字符串）。
 * //
 * //
 * // 两个字符串完全匹配才算匹配成功。
 * //
 * // 说明:
 * //
 * //
 * // s 可能为空，且只包含从 a-z 的小写字母。
 * // p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * //
 * //
 * // 示例 1:
 * //
 * // 输入:
 * //s = "aa"
 * //p = "a"
 * //输出: false
 * //解释: "a" 无法匹配 "aa" 整个字符串。
 * //
 * // 示例 2:
 * //
 * // 输入:
 * //s = "aa"
 * //p = "*"
 * //输出: true
 * //解释: '*' 可以匹配任意字符串。
 * //
 * //
 * // 示例 3:
 * //
 * // 输入:
 * //s = "cb"
 * //p = "?a"
 * //输出: false
 * //解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * //
 * //
 * // 示例 4:
 * //
 * // 输入:
 * //s = "adceb"
 * //p = "*a*b"
 * //输出: true
 * //解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * //
 * //
 * // 示例 5:
 * //
 * // 输入:
 * //s = "acdcb"
 * //p = "a*c?b"
 * //输出: false
 * // Related Topics 贪心 递归 字符串 动态规划
 * // 👍 887 👎 0
 */
public class _44WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new _44WildcardMatching().new Solution();
        System.out.println(solution.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"
                ,"a*******b"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            Map<String, Boolean> map = new HashMap<>();
            return isMatch(s, 0, p, 0,map);
        }

        private boolean isMatch(String s, int sInd, String p, int pInd,Map<String, Boolean> map) {
            String key = sInd + "_" + pInd;
            if (null != map.get(key)) {
                return map.get(key);
            }
            //s走完
            if (sInd >= s.length()) {
                if (pInd < p.length()) {
                    //p没走完且不为*，f
                    while (pInd < p.length()) {
                        if (p.charAt(pInd) != '*') {
                            return false;
                        }
                        pInd++;
                    }
                    //p没走完且均为*，t
                    return true;
                } else {//p也走完，t
                    return true;
                }
            }
            //s没走完p走完，f
            if (pInd >= p.length() && sInd < s.length()) {
                return false;
            }
            boolean res = false;
            //都没走完
            //若p当前是*,可匹配0或多个
            if (p.charAt(pInd) == '*') {
                res =  isMatch(s, sInd, p, pInd + 1,map) || isMatch(s, sInd + 1, p, pInd,map);
                //匹配一个的情况
            } else if (p.charAt(pInd) == '?' || (p.charAt(pInd) == s.charAt(sInd))) {
                res =  isMatch(s, sInd + 1, p, pInd + 1,map);
            }
            map.put(key, res);
            return res;
        }

        //动态规划
        public boolean isMatch1(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            //初始化第一行
            for (int i = 1; i <= n; ++i) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            //逐行判断
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    //*可以匹配0个或多个
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}