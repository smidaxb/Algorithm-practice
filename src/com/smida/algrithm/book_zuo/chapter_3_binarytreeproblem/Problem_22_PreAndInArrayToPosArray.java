package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 前中数组生成后序数组
 */
public class Problem_22_PreAndInArrayToPosArray {

    //标准
    public static int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;
    }

    // 从右往左依次填好后序数组s
    // si为后序数组s该填的位置
    // 返回值为s该填的下一个位置
    public static int setPos(int[] p, int ps, int pe, int[] n, int ns, int ne,
                             int[] s, int si, HashMap<Integer, Integer> map) {
        if (ps > pe) {
            return si;
        }
        s[si--] = p[ps];
        int i = map.get(p[ps]);
        si = setPos(p, pe - (ne - i - 1), pe, n, i + 1, ne, s, si, map);
        return setPos(p, ps + 1, ps + (i - ns), n, ns, i - 1, s, si, map);
    }


    //My
    public static int[] getPosArrayMy(int[] pre, int[] in) {
        if (null == pre || null == in || pre.length < 1 || in.length < 1 || pre.length != in.length) {
            return null;
        }
        int[] res = new int[in.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        fillPostArr(pre, 0, pre.length - 1, in, 0, in.length - 1, map, res, pre.length - 1);
        return res;
    }

    private static int fillPostArr(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> map, int[] res, int fillInd) {
        if (ps > pe) {
            return fillInd;
        }
        res[fillInd--] = pre[ps];
        int i = map.get(pre[ps]);
        fillInd = fillPostArr(pre, pe - (ie - i - 1), pe, in, i + 1, ie, map, res, fillInd);
        return fillPostArr(pre, ps + 1, ps + (i - is), in, is, i - 1, map, res, fillInd);
    }


    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        int[] pos = getPosArray(pre, in);
        printArray(pos);
        int[] pos2 = getPosArrayMy(pre, in);
        printArray(pos2);
    }
}
