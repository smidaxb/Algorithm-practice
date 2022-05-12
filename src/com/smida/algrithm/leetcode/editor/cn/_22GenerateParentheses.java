package com.smida.algrithm.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 括号生成
 * //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：n = 3
 * //输出：["((()))","(()())","(())()","()(())","()()()"]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：n = 1
 * //输出：["()"] ()() (())
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= n <= 8
 * //
 * // Related Topics 字符串 动态规划 回溯
 * // 👍 2633 👎 0
 */
public class _22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new _22GenerateParentheses().new Solution();
        System.out.println(JSON.toJSONString(solution.generateParenthesis(8)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //从1开始，后续扩展就是加一对括号放在原的每一个空隙之间，下边用方括号说明
        //如 () -->> []() ([]) ()[] ，再放回set中去重
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            res.add("()");
            if (n == 1) {
                return res;
            }
            final String pair = "()";
            for (int i = 2; i <= n; i++) {
                Set<String> set = new HashSet<>();
                res.forEach(str -> {
                    str = trans(str);
                    for (int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) == '|') {
                            String t = str.substring(0, j) + pair;
                            if (j < str.length() - 1) {
                                t += str.substring(j + 1);
                            }
                            t = t.replaceAll("\\|", "");
                            set.add(t);
                        }
                    }
                });
                res = new ArrayList<>(set);
            }
            return res;
        }

        private String trans(String str) {
            StringBuilder sb = new StringBuilder("|");
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i)).append("|");
            }
            return sb.toString();
        }

        List<String> list=new ArrayList();
        public List<String> generateParenthesis2(int n) {
            StringBuilder sb=new StringBuilder();
            //执行深度优先遍历，搜索可能的结果
            dfs(n,n,sb);
            return list;
        }

        private void dfs(int left,int right,StringBuilder sb){
            if(left<0||right<0){
                return;
            }
            // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
            if(right<left){
                return;
            }
            // 括号摆完，加入
            if(left==0&&right==0){
                list.add(sb.toString());
                return;
            }
            //走左子树
            sb.append('(');
            dfs(left-1,right,sb);
            //sb是同一个对象在参数中传入，在这里减掉下层递归时添加的结果，恢复到传入时状态
            sb.deleteCharAt(sb.length()-1);

            sb.append(')');
            dfs(left,right-1,sb);
            sb.deleteCharAt(sb.length()-1);

        }

        //做减法
        public List<String> generateParenthesis1(int n) {
            List<String> res = new ArrayList<>();
            // 特判
            if (n == 0) {
                return res;
            }


            dfs("", n, n, res);
            return res;
        }

        /**
         * @param curStr 当前递归得到的结果
         * @param left   左括号还有几个可以使用
         * @param right  右括号还有几个可以使用
         * @param res    结果集
         */
        private void dfs(String curStr, int left, int right, List<String> res) {
            // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
            // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
            if (left == 0 && right == 0) {
                res.add(curStr);
                return;
            }


            if (left > right) {
                return;
            }

            if (left > 0) {
                dfs(curStr + "(", left - 1, right, res);
            }

            if (right > 0) {
                dfs(curStr + ")", left, right - 1, res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}