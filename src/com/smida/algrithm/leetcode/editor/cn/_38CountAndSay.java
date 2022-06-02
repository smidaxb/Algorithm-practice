package com.smida.algrithm.leetcode.editor.cn;

/**
 * 外观数列
 * //给定一个正整数 n ，输出外观数列的第 n 项。
 * //
 * // 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * //
 * // 你可以将其视作是由递归公式定义的数字字符串序列：
 * //
 * //
 * // countAndSay(1) = "1"
 * // countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * //
 * //
 * // 前五项如下：
 * //
 * //
 * //1.     1
 * //2.     11
 * //3.     21
 * //4.     1211
 * //5.     111221
 * //第一项是数字 1
 * //描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * //描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * //描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * //描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * //
 * //
 * // 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成
 * //一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 * //
 * // 例如，数字字符串 "3322251" 的描述如下图：
 * //
 * //
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：n = 1
 * //输出："1"
 * //解释：这是一个基本样例。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：n = 4
 * //输出："1211"
 * //解释：
 * //countAndSay(1) = "1"
 * //countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * //countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * //countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= n <= 30
 * //
 * // Related Topics 字符串
 * // 👍 903 👎 0
 */
public class _38CountAndSay {
    public static void main(String[] args) {
        Solution solution = new _38CountAndSay().new Solution();
        System.out.println(solution.countAndSay(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            //第一次直接返回
            if (n == 1) {
                return "1";
            }
            //从第二次开始，挨个计算
            StringBuilder res = new StringBuilder("1");
            for (int i = 2; i <= n; i++) {
                StringBuilder sb = new StringBuilder();
                String str = res.toString();
                //pre 代表在统计的数字，count 代表个数
                char pre = str.charAt(0);
                int count = 1;
                //从第二个字符开始，第一个字符已被统计
                for (int j = 1; j < str.length(); j++) {
                    char cur = str.charAt(j);
                    if (cur == pre) {
                        count++;
                    } else {
                        //字符改变，将统计结果添加进去
                        sb.append(count).append(pre);
                        count = 1;
                        pre = cur;
                    }
                }
                sb.append(count).append(pre);
                res = sb;
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}