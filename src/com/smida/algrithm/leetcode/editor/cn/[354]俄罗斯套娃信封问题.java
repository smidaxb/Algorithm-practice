package com.smida.algrithm.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution354 {
//    //相当于300的二维版
//    //dp[i]代表走到 envelopes[i]时，最大套娃个数
//    public int maxEnvelopes(int[][] envelopes) {
//        int[] dp = new int[envelopes.length];
//        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
//        for (int i = 0; i < dp.length; i++) {
//            dp[i] = 1;
//        }
//        int[] height = new int[envelopes.length];
//        for (int i = 0; i < envelopes.length; i++)
//            height[i] = envelopes[i][1];
//        int res = 1;
//        dp[0] = 1;
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 0; j < i; j++) {
//                //长宽都比其大
//                if (height[i]> height[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                    res = Math.max(res, dp[i]);
//                }
//            }
//        }
//        return res;//这里res也就是dp数组的最大值
//    }

    // envelopes = [[w, h], [w, h]...]
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];

        return lengthOfLIS(height);
    }

    int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
