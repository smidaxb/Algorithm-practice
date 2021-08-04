package com.smida.algrithm.aimOffer;

import com.smida.algrithm.Node;
import org.junit.Test;

/**
 * @author Created by YangYifan on 2020/6/2.
 */
public class MyTest {
    private Practice aimOffer = new Practice();

    @Test
    public void NumberOf1Test() {
        int res = aimOffer.NumberOf1(-1);
        assert res == 32;
    }

    @Test
    public void reOrderArrayTest() {
        int[] array = new int[]{2, 1, 3, 4, 5};
        aimOffer.reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    @Test
    public void VerifySquenceOfBSTTest() {
        int[] array = new int[]{7, 4, 6, 5};
        boolean res = aimOffer.VerifySquenceOfBST(array);
        System.out.println(res);
    }

    @Test
    public void FindNumsAppearOnceTest() {
        int[] arr = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        aimOffer.FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0] + "---" + num2[0]);
    }

    @Test
    public void addTest() {
        int sum = aimOffer.Add(2, 43);
        System.out.println(sum);
    }

    @Test
    public void multiplyTest() {
        int[] res = aimOffer.multiply(new int[]{1, 2, 3, 4, 5});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    @Test
    public void sumTest() {
        System.out.println(calculateSum(0, 10));
        System.out.println(getRCNum(0) + getRCNum(10));
    }

    private int calculateSum(int i, int j) {
        int isum = 0;
        int jsum = 0;
        while (i != 0 || j != 0) {
            isum += i % 10;
            jsum += j % 10;
            i /= 10;
            j /= 10;
        }
        return isum + jsum;
    }

    int getRCNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num = num / 10;
        }
        return sum;
    }

    /**
     * 3逆向打印链表
     */
    @Test
    public void q3() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        System.out.println(aimOffer.printListFromTailToHeadRecursion(a));
    }

    /**
     * 4 前中遍历重建二叉树
     */
    @Test
    public void q4() {
        int[] p = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] i = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = aimOffer.reConstructBinaryTree(p, i);
    }

    /**
     * 27 字符串全排列
     */
    @Test
    public void q27() {
        System.out.println(aimOffer.Permutation("abcd"));
    }

    /**
     * 35 逆序对
     */
    @Test
    public void q35() {
        System.out.println(aimOffer.InversePairs(new int[]{3,4,2, 1}));
    }

}
