package com.smida.algrithm.leetcode.editor.cn;

import java.time.LocalTime;

/**
 * @author Created by YangYifan on 2022/4/21.
 */
public class _00WorkTime {
    public static void main(String[] args) {
        LocalTime s = LocalTime.of(10, 14);
        LocalTime e = LocalTime.of(20, 29);
        Double abs = e.getHour() * 1.0 - s.getHour() * 1.0 + (e.getMinute() - s.getMinute()) / 60.0 - 10;
        System.out.println("**************** " + String.format("%.2f", abs) + " ***************");
    }
}


