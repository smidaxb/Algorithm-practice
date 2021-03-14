package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 去掉字符串中刚好连续k个0
 * 如a00b，k=2，返回ab；abc000，，k=2。返回abc000
 */
public class Problem_03_RemoveKZeros {

    //My
    public static String removeKZerosMy(String str, int k) {
        if (null == str || str.length() == 0 || k < 1) {
            return str;
        }
        char[] arr = str.toCharArray();
        //count 记录连续0的个数
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] == '0') {
                count++;
            } else {
                if (count == k) {
                    while (count > 0) {
                        arr[i - count] = 0;
                        count--;
                    }
                }
                count = 0;
            }
        }
        //可能str最后刚好为k个0，需要多判断一次
		if (count == k) {
			while (count > 0) {
				arr[arr.length - count] = 0;
				count--;
			}
		}
		return String.valueOf(arr);
    }

    public static String removeKZeros(String str, int k) {
        if (str == null || k < 1) {
            return str;
        }
        char[] chas = str.toCharArray();
        int count = 0, start = -1;
        for (int i = 0; i != chas.length; i++) {
            if (chas[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0)
                        chas[start++] = 0;
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            while (count-- != 0)
                chas[start++] = 0;
        }
        return String.valueOf(chas);
    }

    public static void main(String[] args) {
        String test1 = "0A0B0C00D0";
        System.out.println(removeKZeros(test1, 1));
        System.out.println(removeKZerosMy(test1, 1));

        String test2 = "00A00B0C00D0";
        System.out.println(removeKZeros(test2, 2));
        System.out.println(removeKZerosMy(test2, 2));

        String test3 = "000A00B000C0D00";
        System.out.println(removeKZeros(test3, 3));
        System.out.println(removeKZerosMy(test3, 3));

        String test4 = "0000A0000B00C000D0000";
        System.out.println(removeKZeros(test4, 4));
        System.out.println(removeKZerosMy(test4, 4));

        String test5 = "00000000";
        System.out.println(removeKZeros(test5, 5));
        System.out.println(removeKZerosMy(test5, 5));

    }

}
