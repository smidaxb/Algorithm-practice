package com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最短通路值
 *
 * 如：matrix
 * 1 0 1 1 1
 * 1 0 1 0 1
 * 1 1 1 0 1
 * 0 0 0 0 1
 * 通路只有一条，由12个1组成，返回12
 *
 * 解析：
 * 用map[i][j]代表走到i,j的最短路径值，行队列rq，列队列cq，左上角0,0入队列
 * 出队一个点，看其四个方向哪个为1，更新这些点的map值，若已经不为0了就跳过(每个点只遍一次),同时将其加入队列
 * 若队列都空了还没走到终点，说明没有通路，返回0
 */
public class Problem_24_MinPathValue {
    public static int minPathValue(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0 || m[0][0] != 1
                || m[m.length - 1][m[0].length - 1] != 1) {
            return 0;
        }
        int res = 0;
        int[][] map = new int[m.length][m[0].length];
        map[0][0] = 1;
        Queue<Integer> rQ = new LinkedList<Integer>();
        Queue<Integer> cQ = new LinkedList<Integer>();
        rQ.add(0);
        cQ.add(0);
        int r = 0;
        int c = 0;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();
            if (r == m.length - 1 && c == m[0].length - 1) {
                return map[r][c];
            }
            walkTo(map[r][c], r, c + 1, m, map, rQ, cQ); // right
            walkTo(map[r][c], r + 1, c, m, map, rQ, cQ); // down
            walkTo(map[r][c], r - 1, c, m, map, rQ, cQ); // up
            walkTo(map[r][c], r, c - 1, m, map, rQ, cQ); // left

        }
        return res;
    }

    public static void walkTo(int pre, int toR, int toC, int[][] m,
                              int[][] map, Queue<Integer> rQ, Queue<Integer> cQ) {
        if (toR < 0 || toR == m.length || toC < 0 || toC == m[0].length
                || m[toR][toC] != 1 || map[toR][toC] != 0) {
            return;
        }
        map[toR][toC] = pre + 1;
        rQ.add(toR);
        cQ.add(toC);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1 } };
        System.out.println(minPathValue(matrix));

    }
}
