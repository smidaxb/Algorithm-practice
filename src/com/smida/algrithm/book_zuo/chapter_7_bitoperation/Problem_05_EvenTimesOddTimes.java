package com.smida.algrithm.book_zuo.chapter_7_bitoperation;

/**
 * a^a=0
 * 1：数组中所有数都出现了两次，只有一个数出现了一次，求这个数
 * 解答：用0与所有数组中的数异或，最后剩下的就是
 * <p>
 * 2：数组中所有数都出现了两次，只有两个数出现了一次，求这两个数
 * 解答：设这俩数为a,b。用0与所有数组中的数异或，得到a^b
 * 找到a^b某一个不为0的位，设其为c，让c和(c&arri)!=0的数异或，得到的就是其中一个数，假设为a
 * 再异或找到另一个数 b=a^(a^b)
 */
public class Problem_05_EvenTimesOddTimes {

    public static void printOddTimesNum1(int[] arr) {
        int eO = 0;
        for (int cur : arr) {
            eO ^= cur;
        }
        System.out.println(eO);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eO = 0, eOhasOne = 0;
        for (int curNum : arr) {
            eO ^= curNum;
        }
        int rightOne = eO & (~eO + 1);
        rightOne = 1;
        while ((rightOne & eO) == 0) {
            rightOne *= 2;
        }
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {
                eOhasOne ^= cur;
            }
        }
        System.out.println(eOhasOne + " " + (eO ^ eOhasOne));
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        printOddTimesNum2(arr2);

    }

}
