package com.smida.algrithm.lettcode.tencent50;

/**
 * 11.盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class _011MaxArea {
    public static int maxArea(int[] height) {
        int res = 0;
        if (null == height || height.length < 2) {
            return res;
        }
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                int volume = Math.min(height[i], height[j]) * (i - j);
                res = volume > res ? volume : res;
            }
        }
        return res;
    }

    public static int maxAreaON(int[] height) {
        int res = 0;
        if (null == height || height.length < 2) {
            return res;
        }
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int volume = Math.min(height[left], height[right]) * (right - left);
            res = volume > res ? volume : res;
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxAreaON(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
