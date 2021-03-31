package com.smida.algrithm.book_zuo.chapter_9_others;

/**
 * 问题一：从随机5函数到随机7
 * 解析：
 * r5-1: 0 1 2 3 4
 * (r5-1)*5: 0 5 10 15 20
 * 加起来：0-24
 * 若大于20就继续： 0-20
 * mod7 +1：1-7
 * <p>
 * 问题二：给定p概率的0/1生成函数，实现1-6随机
 * 解析：
 * 生成01和10的概率是一样的，得到r01： 0 1
 * r01*2 ：0 2
 * 加起来 ： 0 1 2 3
 * r03 *2  + r01 :0 1 2 3 4 5 6 7
 * 大于5就继续：0-5
 * 加1 ： 1-6
 */
public class Problem_01_Rand5ToRand7 {
    public static void printCountArray(int[] countArr) {
        for (int i = 0; i != countArr.length; i++) {
            System.out.println(i + " appears " + countArr[i] + " times");
        }
    }

    public static int rand1To5() {
        return (int) (Math.random() * 5) + 1;
    }

    public static void main(String[] args) {
        int testTimes = 1000000;
        int[] countArr1 = new int[8];
        for (int i = 0; i != testTimes; i++) {
            countArr1[rand1To7()]++;
        }
        printCountArray(countArr1);

    }

    private static int rand1To7() {
        int i;
        do {
            i = (rand1To5() - 1) + ((rand1To5() - 1) * 5);
        } while (i > 20);
        return (i % 7) + 1;
    }
}
