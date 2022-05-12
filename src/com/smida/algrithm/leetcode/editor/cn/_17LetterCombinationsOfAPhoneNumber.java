package com.smida.algrithm.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * //
 * // 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * //
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：digits = "23"
 * //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：digits = ""
 * //输出：[]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：digits = "2"
 * //输出：["a","b","c"]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 0 <= digits.length <= 4
 * // digits[i] 是范围 ['2', '9'] 的一个数字。
 * //
 * // Related Topics 哈希表 字符串 回溯
 * // 👍 1893 👎 0
 */
public class _17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new _17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(JSON.toJSONString(solution.letterCombinations("2344")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) {
                return res;
            }
            //先把第一个字符串放入初始List
            String originAdd = getStr(digits.charAt(0) - '0');
            for (int i = 0; i < originAdd.length(); i++) {
                res.add("" + originAdd.charAt(i));
            }
            //后续字符串循环加入List中
            for (int i = 1; i < digits.length(); i++) {
                res = addStr(res, getStr(digits.charAt(i) - '0'));
            }
            return res;
        }

        private List<String> addStr(List<String> oldRes, String toAdd) {
            List<String> res = new ArrayList<>();
            for (String s : oldRes) {
                for (int i = 0; i < toAdd.length(); i++) {
                    res.add(s + toAdd.charAt(i));
                }
            }
            return res;
        }

        public String getStr(int i) {
            switch (i) {
                case 2:
                    return "abc";
                case 3:
                    return "def";
                case 4:
                    return "ghi";
                case 5:
                    return "jkl";
                case 6:
                    return "mno";
                case 7:
                    return "pqrs";
                case 8:
                    return "tuv";
                case 9:
                    return "wxyz";
                default:
                    return "";
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}