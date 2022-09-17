package com.smida.algrithm.newCode.base.b07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 字符串自小字典序
 * <p>
 * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所 有字 符串拼起来之后形成的字符串具有最低的字典序。
 * 思路：用一个 拼接排序的Comparator，使得 str1+str2 < str2+str1 时，str1 < str2
 *
 * @author YYF
 * @date 2022/9/17 15:02.
 */
public class P7LowestStringSeq {
    private static class StringSeqComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    //不用堆
    public static String method(String[] arr) {
        Arrays.sort(arr, new StringSeqComparator());
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    //用堆
    public static String method2(String[] arr) {
        PriorityQueue<String> heap = new PriorityQueue<>(new StringSeqComparator());
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            heap.add(s);
        }
        while (!heap.isEmpty()) {
            sb.append(heap.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(method(strs1));
        System.out.println(method2(strs1));

        String[] strs2 = {"ba", "b"};
        System.out.println(method(strs2));
        System.out.println(method2(strs2));
    }
}
