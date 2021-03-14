package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 给一个字符串，如果符合日常书写整数，且在int范围内，返回整数值，否则返回0、
 * 123返回123
 * 023返回0
 * a12返回0
 * 214783648 溢出，返回0
 * -123 返回 -123
 */
public class Problem_05_StringToInt {
    //My
    public static int convertMy(String str) {
        if (str == null || str.equals("")) {
            return 0; // can not convert
        }
        char[] arr = str.toCharArray();
        //valid
        int s = 0;
        boolean isNegative = false;
        if (arr[0] == '-') {
            isNegative = true;
            s = 1;
        }
        if (arr[s] == '0') {
            return 0;
        }
        for (int i = s; i < arr.length; i++) {
            if (arr[i] < '0' || arr[i] > '9') {
                return 0;
            }
        }
        //toInt
        int res = 0;
        int max = Integer.MAX_VALUE;
        int tenPosition = max / 10;
        //负数比正数多一个位置，以负数算
        int singlePosition = max % 10 + 1;
        for (int i = s; i < arr.length; i++) {
            int cur = arr[i] - '0';
            //如果这步走完就要比最大值要大了，溢出
            if (res > tenPosition) {
                return 0;
            }
            if (res == tenPosition) {
                //如果已经走到最大值的长度，要判断
                if (i != arr.length - 1) {
                    return 0;
                }
                if (cur > singlePosition) {
                    return 0;
                }
                if (!isNegative && singlePosition == cur) {
                    return 0;
                }
            }
            res = res * 10 + cur;
        }
        return isNegative ? -res : res;
    }

    //标准答案
    public static int convert(String str) {
        if (str == null || str.equals("")) {
            return 0; // can not convert
        }
        char[] chas = str.toCharArray();
        if (!isValid(chas)) {
            return 0; // can not convert
        }
        boolean posi = chas[0] == '-' ? false : true;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = posi ? 0 : 1; i < chas.length; i++) {
            cur = '0' - chas[i];
            if ((res < minq) || (res == minq && cur < minr)) {
                return 0; // can not convert
            }
            res = res * 10 + cur;
        }
        if (posi && res == Integer.MIN_VALUE) {
            return 0; // can not convert
        }
        return posi ? -res : res;
    }

    public static boolean isValid(char[] chas) {
        if (chas[0] != '-' && (chas[0] < '0' || chas[0] > '9')) {
            return false;
        }
        if (chas[0] == '-' && (chas.length == 1 || chas[1] == '0')) {
            return false;
        }
        if (chas[0] == '0' && chas.length > 1) {
            return false;
        }
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] < '0' || chas[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "2147483647"; // max in java
        System.out.println(convert(test1));
        System.out.println(convertMy(test1));

        String test2 = "-2147483648"; // min in java
        System.out.println(convert(test2));
        System.out.println(convertMy(test2));

        String test3 = "2147483648"; // overflow
        System.out.println(convert(test3));
        System.out.println(convertMy(test3));

        String test4 = "-2147483649"; // overflow
        System.out.println(convert(test4));
        System.out.println(convertMy(test4));

        String test5 = "-123";
        System.out.println(convert(test5));
        System.out.println(convertMy(test5));

    }
}
