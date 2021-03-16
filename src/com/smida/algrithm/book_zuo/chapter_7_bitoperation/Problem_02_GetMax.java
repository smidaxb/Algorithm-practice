package com.smida.algrithm.book_zuo.chapter_7_bitoperation;

/**
 * 不用比较获取两个整数之间较大值
 * flip函数：传0返回1，传1返回0
 * sign函数：a-b为正，则(a-b)>>31 & 1为0，flip(...)返回1，即a大返回1，b大返回0
 * 这样返回 sign*a+flip*b 即为最大值
 */
public class Problem_02_GetMax {

	public static int flip(int n) {
		return n ^ 1;
	}

	public static int sign(int n) {
		return flip((n >> 31) & 1);
	}

	public static int getMax1(int a, int b) {
		int c = a - b;
		int scA = sign(c);
		int scB = flip(scA);
		return a * scA + b * scB;
	}

	public static int getMax2(int a, int b) {
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		int difSab = sa ^ sb;
		int sameSab = flip(difSab);
		int returnA = difSab * sa + sameSab * sc;
		int returnB = flip(returnA);
		return a * returnA + b * returnB;
	}

	public static void main(String[] args) {
		int a = -16;
		int b = 1;
		System.out.println(getMax1(a, b));
		System.out.println(getMax2(a, b));
		a = 2147483647;
		b = -2147480000;
		System.out.println(getMax1(a, b)); // wrong answer because of overflow
		System.out.println(getMax2(a, b));

	}

}
