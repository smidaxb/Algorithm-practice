package com.smida.algrithm.leetcode.editor.cn;

import java.util.Stack;

/**
 * 接雨水
 * //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //
 * //
 * //输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * //输出：6
 * //解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：height = [4,2,0,3,2,5]
 * //输出：9
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // n == height.length
 * // 1 <= n <= 2 * 104
 * // 0 <= height[i] <= 105
 * //
 * // Related Topics 栈 数组 双指针 动态规划 单调栈
 * // 👍 3474 👎 0
 */
public class _42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new _42TrappingRainWater().new Solution();
        System.out.println(solution.trap6(new int[]{4, 2, 0, 3, 2, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划：求某一列h水量，先算出其左右最长的柱子高度hL hR，若<=h则无水，若都>h则为min(hL,hR)-h，求出每个位置两边的最高值，即可求得
        public int trap(int[] height) {
            int res = 0;
            //求左/右两边数组
            int[] hL = new int[height.length];
            int[] hR = new int[height.length];
            for (int i = 1; i < height.length - 1; i++) {
                hL[i] = Math.max(height[i - 1], hL[i - 1]);
            }
            for (int i = height.length - 2; i > 0; i--) {
                hR[i] = Math.max(height[i + 1], hR[i + 1]);
            }
            //按列计算水量
            for (int i = 1; i < height.length - 1; i++) {
                int hi = height[i];
                if (hL[i] > hi && hR[i] > hi) {
                    res += Math.min(hL[i], hR[i]) - hi;
                }
            }
            return res;
        }

        //用栈
        public int trap6(int[] height) {
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            int current = 0;
            while (current < height.length) {
                //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
                while (!stack.empty() && height[current] > height[stack.peek()]) {
                    int h = height[stack.peek()]; //取出要出栈的元素
                    stack.pop(); //出栈
                    if (stack.empty()) { // 栈空就出去
                        break;
                    }
                    int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                    int min = Math.min(height[stack.peek()], height[current]);
                    sum = sum + distance * (min - h);
                }
                stack.push(current); //当前指向的墙入栈
                current++; //指针后移
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}