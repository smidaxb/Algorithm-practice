package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 1、翻转字符串，要求时间复杂n，空间复杂1
 * 输入 i love you  返回 you love i
 * <p>
 * 2、给一个字符串数组和一个整数size，将大小为size的左半区右半区交换，要求时间复杂n，空间复杂1
 * 输入 1234567 4 返回5671234
 */
public class Problem_11_ReverseString {
    //My
    public static void rotateWordMy(char[] chas) {
        reverseMy(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chas.length; i++) {
            if (i == 0 || chas[i - 1] == ' ') {
                l = i;
            } else if (i == chas.length - 1 || chas[i + 1] == ' ') {
                r = i;
            } else if (chas[i] == ' ') {
                reverseMy(chas, l, r);
                l = -1;
                r = -1;
            }
        }
        if (l != r) {
            reverseMy(chas, l, r);
        }
    }

    private static void reverseMy(char[] chas, int start, int end) {
        while (start < end) {
            char t = chas[start];
            chas[start] = chas[end];
            chas[end] = t;
            start++;
            end--;
        }
    }

    public static void rotateMy(char[] chas, int size) {
        reverseMy(chas, 0, size - 1);
        reverseMy(chas, size, chas.length - 1);
        reverseMy(chas, 0, chas.length - 1);
    }

    //标准答案
    public static void rotateWord(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        reverse(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ' ') {
                l = i == 0 || chas[i - 1] == ' ' ? i : l;
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
            }
            if (l != -1 && r != -1) {
                reverse(chas, l, r);
                l = -1;
                r = -1;
            }
        }
    }

    public static void reverse(char[] chas, int start, int end) {
        char tmp = 0;
        while (start < end) {
            tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
    }

    public static void rotate1(char[] chas, int size) {
        if (chas == null || size <= 0 || size >= chas.length) {
            return;
        }
        reverse(chas, 0, size - 1);
        reverse(chas, size, chas.length - 1);
        reverse(chas, 0, chas.length - 1);
    }

    public static void rotate2(char[] chas, int size) {
        if (chas == null || size <= 0 || size >= chas.length) {
            return;
        }
        int start = 0;
        int end = chas.length - 1;
        int lpart = size;
        int rpart = chas.length - size;
        int s = Math.min(lpart, rpart);
        int d = lpart - rpart;
        while (true) {
            exchange(chas, start, end, s);
            if (d == 0) {
                break;
            } else if (d > 0) {
                start += s;
                lpart = d;
            } else {
                end -= s;
                rpart = -d;
            }
            s = Math.min(lpart, rpart);
            d = lpart - rpart;
        }
    }

    public static void exchange(char[] chas, int start, int end, int size) {
        int i = end - size + 1;
        char tmp = 0;
        while (size-- != 0) {
            tmp = chas[start];
            chas[start] = chas[i];
            chas[i] = tmp;
            start++;
            i++;
        }
    }

    public static void main(String[] args) {
        char[] chas1 = {'d', 'o', 'g', ' ', 'l', 'o', 'v', 'e', 's', ' ', 'p',
                'i', 'g'};
        System.out.println(String.valueOf(chas1));
        rotateWord(chas1);
        System.out.println(String.valueOf(chas1));
        rotateWordMy(chas1);
        System.out.println(String.valueOf(chas1));

        char[] chas2 = {'1', '2', '3', '4', '5', 'A', 'B', 'C'};
        System.out.println(String.valueOf(chas2));
        rotate1(chas2, 5);
        System.out.println(String.valueOf(chas2));
        rotate2(chas2, 3);
        System.out.println(String.valueOf(chas2));
        rotateMy(chas2, 3);
        System.out.println(String.valueOf(chas2));

    }
}
