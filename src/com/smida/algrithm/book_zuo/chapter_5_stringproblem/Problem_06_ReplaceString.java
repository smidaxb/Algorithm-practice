package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 替换字符创中连续出现的指定字符串
 * str=123abcabc   from=abc to=X   返回123X
 */

public class Problem_06_ReplaceString {
    //My
    public static String replaceMy(String str, String from, String to) {
        if (null == str || null == from || null == to || str.length() == 0 || from.length() == 0) {
            return str;
        }
        char[] arr = str.toCharArray();
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s == from.length()) {
                while (s > 0) {
                    arr[i - s] = 0;
                    s--;
                }
            }
            if (arr[i] == from.charAt(s)) {
                s++;
            } else {
                s = 0;
            }
        }
        if (s == from.length()) {
            while (s > 0) {
                arr[arr.length - s] = 0;
                s--;
            }
        }
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (i == 0 || arr[i - 1] != 0) {
                    builder.append(to);
                }
                continue;
            } else {
                builder.append(arr[i]);
            }
        }
        return builder.toString();
    }


    //标准答案
    public static String replace(String str, String from, String to) {
        if (str == null || from == null || str.equals("") || from.equals("")) {
            return str;
        }
        char[] chas = str.toCharArray();
        char[] chaf = from.toCharArray();
        int match = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == chaf[match++]) {
                if (match == chaf.length) {
                    clear(chas, i, chaf.length);
                    match = 0;
                }
            } else {
                if (chas[i] == chaf[0]) {
                    i--;
                }
                match = 0;
            }
        }
        String res = "";
        String cur = "";
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != 0) {
                cur = cur + String.valueOf(chas[i]);
            }
            if (chas[i] == 0 && (i == 0 || chas[i - 1] != 0)) {
                res = res + cur + to;
                cur = "";
            }
        }
        if (!cur.equals("")) {
            res = res + cur;
        }
        return res;
    }

    public static void clear(char[] chas, int end, int len) {
        while (len-- != 0) {
            chas[end--] = 0;
        }
    }

    public static void main(String[] args) {
        String str = "abc1abcabc1234abcabcabc5678";
        String from = "abc";
        String to = "XXXXX";
        System.out.println(replace(str, from, to));
        System.out.println(replaceMy(str, from, to));

        str = "abc";
        from = "123";
        to = "X";
        System.out.println(replace(str, from, to));
        System.out.println(replaceMy(str, from, to));

    }

}
