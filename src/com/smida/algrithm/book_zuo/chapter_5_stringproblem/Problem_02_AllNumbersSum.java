package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 字符串中数字子串求和
 * 胡烈小数点，负号连续出现偶数个为正
 * 如：str = a1cd2e33，返回36；str=a-1b--2c--d6e 返回7
 */
public class Problem_02_AllNumbersSum {

    //My
    public static int numSumMy(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int negativeCount = 0;
        int res = 0;
        int cur = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '-') {
                negativeCount++;
                continue;
            }
            if ((c < '0' || c > '9')) {
                cur = negativeCount % 2 == 0 ? cur : -cur;
                res += cur;
                cur = 0;
                negativeCount = 0;
                continue;
            }
            cur = cur * 10 + c - '0';
        }
        if (cur != 0) {
            cur = negativeCount % 2 == 0 ? cur : -cur;
            res += cur;
        }
        return res;
    }

    public static int numSum(String str) {
        if (str == null) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (charArr[i] == '-') {
                    if (i - 1 > -1 && charArr[i - 1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }

    public static void main(String[] args) {
        String test = "1K-100ABC500D-T--100F200G!!100H---300";
        System.out.println(numSum(test));
        System.out.println(numSumMy(test));
    }

}
