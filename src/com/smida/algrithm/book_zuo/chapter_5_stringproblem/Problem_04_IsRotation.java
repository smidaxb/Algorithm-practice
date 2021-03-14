package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 判断两个字符串是否互为旋转词（把一个字符串后边的部分移到前边）
 * 如abcd，cdab互为，abcd，acdb不为
 *
 * 解答：将一个字符串拼两次，在中间找到另一个字符串就互为
 */
public class Problem_04_IsRotation {
	//My
	public static boolean isRotationMy(String a, String b) {
		if (a == null || b == null || a.length() != b.length()) {
			return false;
		}
		String b2 = b + b;
		int s = 0;
		for (int i = 0; i < b2.length(); i++) {
			if (s == a.length()) {
				return true;
			}
			if (b2.charAt(i)==a.charAt(s)){
				s++;
				continue;
			}
			s=0;
		}
		return false;
	}

	public static boolean isRotation(String a, String b) {
		if (a == null || b == null || a.length() != b.length()) {
			return false;
		}
		String b2 = b + b;
		return getIndexOf(b2, a) != -1;
	}

	// KMP Algorithm
	public static int getIndexOf(String s, String m) {
		if (s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str1 = "yunzuocheng";
		String str2 = "zuochengyun";
		System.out.println(isRotation(str1, str2));
		System.out.println(isRotationMy(str1, str2));

	}

}
