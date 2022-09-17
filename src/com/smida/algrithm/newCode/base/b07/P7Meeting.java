package com.smida.algrithm.newCode.base.b07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 安排最多场会议
 * 两个数组，start[],end[] 分别表示开始、结束时间
 * <p>
 * 思路：以结束时间最早的优先，进小顶堆，能安排就安排，不能算逑
 *
 * @author YYF
 * @date 2022/9/17 19:49.
 */
public class P7Meeting {
    public static class Meet {
        public int start;
        public int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Meet> ArrangeMeet(int[] startArr, int[] endArr) {
        List<Meet> res = new ArrayList<>();
        PriorityQueue<Meet> smallHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        for (int i = 0; i < startArr.length; i++) {
            Meet meet = new Meet(startArr[i], endArr[i]);
            smallHeap.add(meet);
        }
        Meet pre = null;
        while (!smallHeap.isEmpty()) {
            Meet meet = smallHeap.poll();
            if (pre == null || pre.end <= meet.start) {
                res.add(meet);
                pre = meet;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] start = new int[]{1, 2, 3, 4};
        int[] end = new int[]{2, 4, 4, 5};
        System.out.println(ArrangeMeet(start, end).size());
    }
}
