package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

/**
 * 跳跃游戏，起始位置为0，可跳1~arri个位置，问从数组最左边跳到最右边(0~len-1)最少需要几步
 * jump代表跳了多少步，cur代表跳jump步最远可到哪个位置，next代表再跳一步可到哪个位置
 * jump=0;cur=0;next=Math.max(next, cur + arr[0]);
 */
public class Problem_15_JumpGame {
    //My
    public static int jumpMy(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int jump = 0;
        int cur = 0;
        int next = 0;
        next = Math.max(next, cur + arr[0]);
        for (int i = 0; i < arr.length; i++) {
            if (cur >= i) {
                continue;
            } else {
                jump++;
                cur = next;
            }
            next = Math.max(next, cur + arr[i]);
        }
        return jump;
    }

    //标准答案
    public static int jump(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 1, 4};
        System.out.println(jump(arr));
        System.out.println(jumpMy(arr));

    }
}
