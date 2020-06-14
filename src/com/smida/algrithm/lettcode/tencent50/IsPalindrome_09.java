package com.smida.algrithm.lettcode.tencent50;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class IsPalindrome_09 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] arr = String.valueOf(x).toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 进阶:
     * <p>
     * 你能不将整数转为字符串来解决这个问题吗？
     */
    public static boolean isPalindromeWithOutStr(int x) {
        if (x < 0) {
            return false;
        }
        int num = 0;
        int tmp = x;
        while (tmp != 0) {
            num = 10 * num + (tmp % 10);
            tmp = tmp/10;
        }
        return num == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(0));
        System.out.println("==============================================================");
        System.out.println(isPalindromeWithOutStr(121));
        System.out.println(isPalindromeWithOutStr(-121));
        System.out.println(isPalindromeWithOutStr(10));
        System.out.println(isPalindromeWithOutStr(0));
    }
}
