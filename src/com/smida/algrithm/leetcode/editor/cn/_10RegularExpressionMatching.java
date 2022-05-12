package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 正则表达式匹配
 * //给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * //
 * //
 * // '.' 匹配任意单个字符
 * // '*' 匹配零个或多个前面的那一个元素
 * //
 * //
 * // 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：s = "aa", p = "a"
 * //输出：false
 * //解释："a" 无法匹配 "aa" 整个字符串。
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入：s = "aa", p = "a*"
 * //输出：true
 * //解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：s = "ab", p = ".*"
 * //输出：true
 * //解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= s.length <= 20
 * // 1 <= p.length <= 30
 * // s 只包含从 a-z 的小写字母。
 * // p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * // 保证每次出现字符 * 时，前面都匹配到有效的字符
 * //
 * // Related Topics 递归 字符串 动态规划
 * // 👍 2966 👎 0
 */
public class _10RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new _10RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("aaaaa", "a*"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp用于计算在s的sInd~sLen-1 与 p的pInd~pLen-1能否匹配
        public boolean isMatch(String s, String p) {
            //map中存储已计算过的sInd,pInd下的结果，避免重复计算，加速
            Map<String, Boolean> map = new HashMap<>();
            return dp(map, s, 0, p, 0);
        }

        public boolean dp(Map<String, Boolean> map, String s, int sInd, String p, int pInd) {
            boolean res = false;
            //map里有，直接返回
            String key = sInd + "," + pInd;
            if (Objects.nonNull(map.get(key))) {
                return map.get(key);
            }
            //表达式串走完，字符串必须走完
            int pLen = p.length();
            int sLen = s.length();
            if (pInd == pLen) {
                return sInd == sLen;
            }
            //字符串走完，由于条件中保证每次出现字符 * 时，前面都匹配到有效的字符，因此表达式必须是多个x*结构组成
            if (sInd == sLen) {
                if ((pLen - pInd) % 2 != 0) {
                    return false;
                }
                while (pInd < pLen) {
                    if (p.charAt(pInd + 1) != '*') {
                        return false;
                    }
                    pInd += 2;
                }
                return true;
            }
            //都没走完，进行判断.若当前字段能匹配到
            if (s.charAt(sInd) == p.charAt(pInd) || p.charAt(pInd) == '.') {
                //两种情况，第一种:后边的是*，则可以匹配0到n个，此处只配0个或1个，多个由后续递归判断
                if (pInd + 1 < pLen && p.charAt(pInd + 1) == '*') {
                    res = dp(map, s, sInd, p, pInd + 2) || dp(map, s, sInd + 1, p, pInd);
                } else {//第二种，两边都往后移一位
                    res = dp(map, s, sInd + 1, p, pInd + 1);
                }
            }else if (pInd + 1 < pLen && p.charAt(pInd + 1) == '*') {
                //若当前字段没能匹配到，可在表达式下一位为*时，取0个，匹配后续表达式;若不为*则没配上
                res = dp(map, s, sInd, p, pInd + 2);
            }
            map.put(key, res);
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}