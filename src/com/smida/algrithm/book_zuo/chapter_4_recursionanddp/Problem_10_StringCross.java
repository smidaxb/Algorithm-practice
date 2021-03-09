package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

/**
 * 字符串交错组成
 * str1，str2，aim，若aim包含且仅包含str1、str2中的所有字符，且顺序保持，则返回true
 * 如str1=ab str2=12 aim=a1b2
 */
public class Problem_10_StringCross {
    //My类似归并排序的解法
    private static boolean isCross(String str1, String str2, String aim) {
        if (null == str1 || null == str2 || null == aim || aim.length() == 0 || str1.length() == 0 || str2.length() == 0) {
            return false;
        }
        int ind1 = 0;
        int ind2 = 0;
        int inda = 0;
        while (ind1 < str1.length() && ind2 < str2.length() && inda < aim.length()) {
            if (str1.charAt(ind1) == aim.charAt(inda)) {
                ind1++;
                inda++;
                continue;
            }
            if (str2.charAt(ind2) == aim.charAt(inda)) {
                ind2++;
                inda++;
                continue;
            }
            return false;
        }
        while (ind1 < str1.length() && inda < aim.length()) {
            if (str1.charAt(ind1) == aim.charAt(inda)) {
                ind1++;
                inda++;
                continue;
            }
            return false;
        }
        while (ind1 < str1.length() && inda < aim.length()) {
            if (str2.charAt(ind2) == aim.charAt(inda)) {
                ind2++;
                inda++;
                continue;
            }
            return false;
        }
        return ind1 == str1.length() && ind2 == str2.length() && inda == aim.length();
    }

    public static void main(String[] args) {
        String str1 = "1234";
        String str2 = "abcd";
        String str3 = "abcdd";
        String aim = "1a23bcd4";
        System.out.println(isCross(str1, str2, aim));
        System.out.println(isCross(str1, str3, aim));

    }


}
