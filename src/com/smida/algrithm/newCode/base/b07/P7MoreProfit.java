package com.smida.algrithm.newCode.base.b07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 计算项目最大收益
 * 给两个数组cost[],profit[]，分别代表项目花费和净利润，k为最多可做的项目数,cur为初始资金
 * <p>
 * 思路：先把项目按cost入小顶堆，再把能做的出堆按profit进大顶堆，做大顶堆出堆的项目
 *
 * @author YYF
 * @date 2022/9/17 18:23.
 */
public class P7MoreProfit {
    private static class Project {
        private int cost;
        private int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static int MoreProfit(int[] costArr, int[] profitArr, int k, int cur) {
        List<Project> projects = new ArrayList<>(costArr.length);
        PriorityQueue<Project> costSmallHeap = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        PriorityQueue<Project> profitBigHeap = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);
        for (int i = 0; i < costArr.length; i++) {
            Project project = new Project(costArr[i], profitArr[i]);
            projects.add(project);
            //先按cost进小顶堆
            costSmallHeap.add(project);
        }
        //最多做k个项目
        for (int i = 0; i < k; i++) {
            //更新可做的项目
            while (!costSmallHeap.isEmpty() && costSmallHeap.peek().cost <= cur) {
                profitBigHeap.add(costSmallHeap.poll());
            }
            //若无可做项目，结束，否则更新收益后的财产
            if (profitBigHeap.isEmpty()) {
                return cur;
            }
            cur += profitBigHeap.poll().profit;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{50, 100, 150, 200, 2000};
        int[] profit = new int[]{10, 50, 50, 200, 200};
        int k = 3, cur = 100;
        System.out.println(MoreProfit(cost, profit, k, cur));
        k=10;
        System.out.println(MoreProfit(cost, profit, k, cur));
    }
}
