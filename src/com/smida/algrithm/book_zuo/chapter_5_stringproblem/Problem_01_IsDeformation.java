package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 判断两字符串是否互为变形词，即两字符串中出现的字符种类和数量均一样
 * 如str1=1234 str2=4321 str3=2223
 */
public class Problem_01_IsDeformation {
    public static void main(String[] args) {
        String A = "abcabcabc";
        String B = "bcacbaacb";
        System.out.println(isDeformation(A, B));
        A = "dsfafd232";
        System.out.println(isDeformation(A, B));
        A = "哈abcde|\"\\/?";
        B = "哈a?bcde|\"\\/";
        System.out.println(isDeformation(A, B));
    }

    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0 || str1.length() != str2.length()) {
            return false;
        }
        int len = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) > len) {
                len = str1.charAt(i);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(i) > len) {
                len = str2.charAt(i);
            }
        }
        int[] map = new int[len+1];
        System.out.println("len:"+len);
        for (int i = 0; i < str1.length(); i++) {
            int ind = str1.charAt(i);
            map[ind] += 1;
        }
        for (int i = 0; i < str2.length(); i++) {
            int ind = str2.charAt(i);
            if (map[ind] == 0) {
                return false;
            }
            map[ind]--;
        }
        return true;
    }

}
