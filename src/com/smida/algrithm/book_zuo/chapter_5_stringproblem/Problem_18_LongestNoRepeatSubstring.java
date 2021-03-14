package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 找最长无重复子串
 * 给定aabcdd 返回4
 */
public class Problem_18_LongestNoRepeatSubstring {
    //My
    //用map记录上一次遍历到该值的下标
    //pre记录本次最大的开始位置的前一位，默认-1，i-pre即为当前最大长度，记录最大的一个
    //遍历到i时，看pre和map(i)，哪个大就说明以当前i结束的最大不重复子串从哪个开始，设为新的pre值
    public static int maxUniqueMy(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int pre = -1;
        int[] map = new int[1000];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            pre = Math.max(pre, map[str.charAt(i)]);
            int curLen = i - pre;
            max = Math.max(curLen, max);
            map[str.charAt(i)] = i;
        }
        return max;
    }

    //Standard
    public static int maxUnique(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i != chas.length; i++) {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }

    // for test
    public static String getRandomString(int len) {
        char[] str = new char[len];
        int base = 'a';
        int range = 'z' - 'a' + 1;
        for (int i = 0; i != len; i++) {
            str[i] = (char) ((int) (Math.random() * range) + base);
        }
        return String.valueOf(str);
    }

    // for test
    public static String maxUniqueString(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = -1;
        int pre = -1;
        int cur = 0;
        int end = -1;
        for (int i = 0; i != chas.length; i++) {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            if (cur > len) {
                len = cur;
                end = i;
            }
            map[chas[i]] = i;
        }
        return str.substring(end - len + 1, end + 1);
    }

    public static void main(String[] args) {
        String str = getRandomString(20);
        System.out.println(str);
        System.out.println(maxUnique(str));
        System.out.println(maxUniqueMy(str));
        System.out.println(maxUniqueString(str));
    }
}
