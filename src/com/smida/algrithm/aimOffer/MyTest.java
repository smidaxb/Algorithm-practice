package com.smida.algrithm.aimOffer;

import com.sun.deploy.util.ArrayUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author Created by YangYifan on 2020/6/2.
 */
public class MyTest {
    private Practice aimOffer = new Practice();
    @Test
    public void NumberOf1Test(){
        int res = aimOffer.NumberOf1(-1);
        assert res == 32;
    }

    @Test
    public void reOrderArrayTest(){
        int[] array = new int[]{2,1,3,4,5};
        aimOffer.reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    @Test
    public void VerifySquenceOfBSTTest(){
        int[] array = new int[]{7,4,6,5};
        boolean res = aimOffer.VerifySquenceOfBST(array);
        System.out.println(res);
    }

    @Test
    public void FindNumsAppearOnceTest() {
        int[] arr = new int[]{2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        aimOffer.FindNumsAppearOnce(arr,num1,num2);
        System.out.println(num1[0]+"---"+num2[0]);
    }
    @Test
    public void addTest() {
        int sum = aimOffer.Add(2,43);
        System.out.println(sum);
    }
}
