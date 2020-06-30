package com.smida.algrithm.lettcode.tencent50;

/**
 * 43. 字符串相乘(大数相乘)
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class _043Mltiply {
    /**
     * 思路：从最低位开始，算出所有的位数的值，最后加起来
     */
    public static String multiply(String num1, String num2) {
        if (null == num1 || null == num2 || num1.length() == 0 || num2.length() == 0) {
            return null;
        }

        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        if (arr1[0] - '0' == 0 || arr2[0] - '0' == 0) {
            return "0";
        }
        revert(arr1);
        revert(arr2);
        int[] tmpArr = new int[arr1.length + arr2.length];
        int maxInd = 0;
        for (int i = 0; i < arr1.length; i++) {
            int n1 = arr1[i] - '0';
            for (int j = 0; j < arr2.length; j++) {
                int n2 = arr2[j] - '0';
                int num = tmpArr[i + j] + n1 * n2;
                if (maxInd < i + j) {
                    maxInd = i + j;
                }
                tmpArr[i + j] = num;
            }
        }
        int pre = 0;
        for (int i = 0; i <= maxInd; i++) {
            int num = tmpArr[i] + pre;
            pre = num / 10;
            tmpArr[i] = num % 10;
        }
        if (pre > 0) {
            tmpArr[maxInd + 1] = pre;
            maxInd++;
        }
        StringBuilder res = new StringBuilder("");
        for (int i = maxInd; i >= 0; i--) {
            res.append(tmpArr[i]);
        }
        return res.toString();
    }

    public static void revert(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(multiply("11", "11"));
    }
}
