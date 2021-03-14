package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 新类型：小写，大写+小写，大写+大写
 * 给一个str，k，返回k所在字符代表的新类型
 * aaAbAcAA 5 返回Ac
 */
public class Problem_19_FindNewTypeChar {

    public static String pointNewMyChar(String s, int k) {
        if (s == null || s.equals("") || k < 0 || k >= s.length()) {
            return "";
        }
        char[] arr = s.toCharArray();
        int curh = 0;//代表目前新类型开头
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                curh = i;
            } else {
                if ((curh == i - 1 && arr[i-1] >= 'a' && arr[i-1] <= 'z') || curh == i - 2) {
                    curh = i;
                }
            }
            if (k == i) {
                if (curh == i) {
                    res += arr[i];
                    String a = (arr[i] >= 'a' && arr[i] <= 'z') ? "" : String.valueOf(arr[i + 1]);
                    res += a;
                } else {
                    res += arr[i - 1];
                    res += arr[i];
                }
                break;
            }
        }
        return res;
    }

    public static String pointNewchar(String s, int k) {
        if (s == null || s.equals("") || k < 0 || k >= s.length()) {
            return "";
        }
        char[] chas = s.toCharArray();
        int uNum = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (!isUpper(chas[i])) {
                break;
            }
            uNum++;
        }
        if ((uNum & 1) == 1) {
            return s.substring(k - 1, k + 1);
        }
        if (isUpper(chas[k])) {
            return s.substring(k, k + 2);
        }
        return String.valueOf(chas[k]);
    }

    public static boolean isUpper(char ch) {
        return !(ch < 'A' || ch > 'Z');
    }

    public static void main(String[] args) {
        String str = "aaABCDEcBCg";
		System.out.println(str);
        System.out.println(pointNewchar(str, 7));
        System.out.println(pointNewMyChar(str, 7));
        System.out.println(pointNewchar(str, 4));
        System.out.println(pointNewMyChar(str, 4));
        System.out.println(pointNewchar(str, 10));
        System.out.println(pointNewMyChar(str, 10));

    }

}
