package com.smida.algrithm.book_zuo.chapter_4_recursionanddp;

/**
 * 纸牌博弈
 * 问题：给一个数组代表纸牌，只能从两端拿，两个人一个先拿一个后拿，都绝顶聪明，问最后胜出者手牌的和
 * 解答：先拿的手牌和用f(i,j)表示，后拿手牌和的用s(i,j)表示 i>=j
 * 对先拿的人，如果i==j,则返回arri；否则先拿到arri或者arrj，此时下一轮对此人来说就是后拿，他绝顶聪明，会拿走max(s(i,j-1),s(i+1,j))
 * 对后拿的人，如果i==j,则被先拿的人拿了，返回0；否则别人先拿到arri或者arrj，此时下一轮对此人来说就是先拿，由于先拿的人绝顶聪明，只会给他留下min(f(i,j-1),f(i+1,j))
 * <p>
 * 优化：用两个二维数组分别代表f(i,j)和s(i,j),由以上分析可得 f(i,i) = i，s(i,i) = 0;
 */
public class Problem_14_CardsGame {
    //My
    public static int winMy1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    private static int first(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + second(arr, i + 1, j), arr[j] + second(arr, i, j - 1));
    }

    private static int second(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(first(arr, i + 1, j), first(arr, i, j - 1));
    }

    public static int winMy2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] first = new int[n][n];
        int[][] second = new int[n][n];
        for (int i = 0; i < n; i++) {
            first[i][i] = arr[i];
        }
        for (int j = 0; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                first[i][j] = Math.max(arr[j] + second[i][j - 1], arr[i] + second[i + 1][j]);
                second[i][j] = Math.min(first[i + 1][j], first[i][j - 1]);
            }
        }
        return Math.max(first[0][n - 1], second[0][n - 1]);
    }


    //标准答案
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 11};
        System.out.println(win1(arr));
        System.out.println(winMy1(arr));
        System.out.println(win2(arr));
        System.out.println(winMy2(arr));
    }

}
