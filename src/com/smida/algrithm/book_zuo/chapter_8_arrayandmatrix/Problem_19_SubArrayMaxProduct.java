package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

/**
 * 求子数组最大累积和
 * <p>
 * preMax代表以上一个元素结尾的最大累积和
 * preMin代表以上一个元素结尾的最小累积和
 * <p>
 * 则，当前元素的最大累积和，与最小累积和为
 * arr[i]*preMax
 * arr[i]*preMin
 * arr[i]
 * 三个数值中的最大、最小值
 */
public class Problem_19_SubArrayMaxProduct {
    public static void main(String[] args) {
        double[] arr = {-2.5, 4, 0, 3, 0.5, 8, -1};//返回12
        System.out.println(maxProduct(arr));

    }

    private static double maxProduct(double[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        double max = Double.MIN_VALUE;
        double preMax = arr[0];
        double preMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            double v1 = arr[i];
            double v2 = arr[i] * preMax;
            double v3 = arr[i] * preMin;

            preMax = Double.max(Double.max(v1, v2), v3);
            preMin = Double.min(Double.min(v1, v2), v3);
            max = Math.max(max, preMax);
        }
        return max;
    }
}
