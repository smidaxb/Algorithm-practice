package com.smida.algrithm.leetcode.editor.cn;

/**
 * 整数反转
 * //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * //
 * // 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
 * //假设环境不允许存储 64 位整数（有符号或无符号）。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：x = 123
 * //输出：321
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：x = -123
 * //输出：-321
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：x = 120
 * //输出：21
 * //
 * //
 * // 示例 4：
 * //
 * //
 * //输入：x = 0
 * //输出：0
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // -231 <= x <= 231 - 1
 * //
 * // Related Topics 数学
 * // 👍 3507 👎 0
 */
public class _7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new _7ReverseInteger().new Solution();
        System.out.println(solution.reverse(-58456611));
        System.out.println(-111%10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            String s = String.valueOf(x);
            //先判断符号
            Boolean beNegative = false;
            if ('-' == s.charAt(0)) {
                beNegative = true;
            }
            int res = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (0 == res && '0' == s.charAt(i)) {
                    continue;
                } else if ('-' == s.charAt(i)) {
                    continue;
                }
                int cur = s.charAt(i) - '0';
                //判断进位是否会越界，分别根据正负判断
                if ((beNegative && res * 1.0 / Integer.MIN_VALUE > 0.1) || (!beNegative && res * 1.0 / Integer.MAX_VALUE > 0.1)) {
                    return 0;
                }
                if (beNegative) {
                    res = res * 10 - cur;
                } else {
                    res = res * 10 + cur;
                }
            }
            return res;
        }
        //若可以存64位整数，则直接用long存了再强转int，不相等就返回0即可
        public int reverse1(int x) {
            long n = 0;
            while (x != 0) {
                n = n * 10 + x % 10;
                x = x / 10;
            }
            return (int) n == n ? (int) n : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}