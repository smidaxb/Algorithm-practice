package com.smida.algrithm.leetcode.editor.cn;

/**
 * 两数相除
 * //给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * //
 * // 返回被除数 dividend 除以除数 divisor 得到的商。
 * //
 * // 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * //
 * //
 * //
 * // 示例 1:
 * //
 * // 输入: dividend = 10, divisor = 3
 * //输出: 3
 * //解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * //
 * // 示例 2:
 * //
 * // 输入: dividend = 7, divisor = -3
 * //输出: -2
 * //解释: 7/-3 = truncate(-2.33333..) = -2
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 被除数和除数均为 32 位有符号整数。
 * // 除数不为 0。
 * // 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * //
 * // Related Topics 位运算 数学
 * // 👍 901 👎 0
 */
public class _29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new _29DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(7,-1));
        System.out.println(1<<31);
        System.out.println(~(1 << 31));
        System.out.println(1<<30);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int top = 1 << 30;

        public int divide(int dividend, int divisor) {
            int sign = 1, ans = 0;
            if (dividend == (1 << 31)) { // 边界值处理
                if (divisor == -1) {
                    return ~(1 << 31); // 溢出处理
                }
                if (divisor > 0) {
                    dividend += divisor; // ans不溢出就降值处理
                } else {
                    dividend -= divisor;
                }
                ans = 1;
            }
            if (divisor == (1 << 31)) {
                return ans; // 除数边界值处理
            }
            if ((dividend | divisor) < 0 && (dividend ^ divisor) < 0) {
                sign = -1;
            }
            // 全改为正数做
            if (dividend < 0) {
                dividend = -dividend;
            }
            if (divisor < 0) {
                divisor = -divisor;
            }
            // 通过移位计算值, 有点类似辗转相除法,
            // 一个例子: 1024 / 3 = 3 * 2^8 + 3 * 2^6 + 3 * 2^4 + 3 * 2^2 + 3 * 2^1 + 1(省略)
            while (dividend >= divisor) {
                int m = 1, div = divisor;
                while (div < top && (div << 1) <= dividend) {
                    div <<= 1;
                    m <<= 1;
                }
                ans += m;
                dividend -= div;
            }
            if (sign < 0) {
                return -ans;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}