package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 问题1：给定字符串返回统计字符串 如str=aaabba 返回 a_3_b_2_a_1
 * 问题2：给定统计字符串cstr，再给定整数ind，返回原始字符串上的第ind个字符 如cstr=a_1_b_100 ind=10 返回b
 */
public class Problem_07_ConvertStringToCount {
    //My
    public static String getCountStrMy(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char preChar = 0;
        char separator = '_';
        int preCount = 0;
        char[] arr = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (preChar != arr[i]) {
                if (i != 0) {
                    builder.append(preChar);
                    builder.append(separator);
                    builder.append(preCount);
                    builder.append(separator);
                }
                preChar = arr[i];
                preCount = 1;
            } else {
                preCount++;
            }
        }
        builder.append(preChar);
        builder.append(separator);
        builder.append(preCount);
        return builder.toString();
    }

    public static char getIndCharOfOriginString(String cstr, int ind) {
        if (cstr == null || cstr.length() == 0) {
            return 0;
        }
        char[] arr = cstr.toCharArray();
        int curInd = 0;
        int curCount = 0;
        char curChar = 0;
        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            if (cur != '_' && (cur < '0' || cur > '9')) {
                if (curChar != 0) {
                    curInd += curCount;
                    curCount = 0;
                    if (curInd-1 >= ind) {
                        return curChar;
                    }
                }
                curChar = cur;
            } else if (cur == '_') {
                continue;
            } else {
                curCount = curCount * 10 + cur - '0';
            }
        }
        return curChar;
    }

    //标准答案
    public static String getCountString(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != chs[i - 1]) {
                res = concat(res, String.valueOf(num), String.valueOf(chs[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return concat(res, String.valueOf(num), "");
    }

    public static String concat(String s1, String s2, String s3) {
        return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
    }

    public static char getCharAt(String cstr, int index) {
        if (cstr == null || cstr.equals("")) {
            return 0;
        }
        char[] chs = cstr.toCharArray();
        boolean stage = true;
        char cur = 0;
        int num = 0;
        int sum = 0;
        for (int i = 0; i != chs.length; i++) {
            if (chs[i] == '_') {
                stage = !stage;
            } else if (stage) {
                sum += num;
                if (sum > index) {
                    return cur;
                }
                num = 0;
                cur = chs[i];
            } else {
                num = num * 10 + chs[i] - '0';
            }
        }
        return sum + num > index ? cur : 0;
    }

    public static void main(String[] args) {
        String str = "aaabbadddffc";
        String res = getCountString(str);
        System.out.println(str);
        System.out.println(res);
        System.out.println(getCountStrMy(str));
        System.out.println(getCharAt(res, 9));
        System.out.println(getIndCharOfOriginString(res, 9));

    }

}
