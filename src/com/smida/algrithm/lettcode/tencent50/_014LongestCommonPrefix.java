package com.smida.algrithm.lettcode.tencent50;

/**
 * 14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class _014LongestCommonPrefix {
    /**
     * O（mn）
     */
    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < minLen; i++) {
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (tmp != strs[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(tmp);
        }
        return res.toString();
    }

    public static String longestCommonPrefixO2n(String[] strs) {
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

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefixO2n(new String[]{"flowers", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefixO2n(new String[]{"dog", "racecar", "car"}));
    }
}
