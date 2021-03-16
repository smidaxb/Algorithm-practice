package com.smida.algrithm.book_zuo.chapter_7_bitoperation;

/**
 * 不用比较交换两个数
 */
public class Problem_01_SwapWithoutTmp {

	public static void main(String[] args) {
		int a = 16;
		int b = 111;
		System.out.println(a);
		System.out.println(b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);
	}

}
