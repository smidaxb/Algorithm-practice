package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * 在有序的含有空的数组中查找字符串，如有多个取最左边
 * 如strs=[mull,"a",null,"a","b",null,"c"]
 * str=null返回-1
 * str=a 返回2
 * str=d 返回-1
 *
 * 用二分查找，
 * 不为null，比较，小于等于就往前找，令right=mid-1，大于则left=mid+1
 * 为null，往前走到不为null的地方比较，全为null就比较右半区
 */
public class Problem_09_FindStringInContainsNullArray {

	public static int getIndex(String[] strs, String str) {
		if (strs == null || strs.length == 0 || str == null) {
			return -1;
		}
		int res = -1;
		int left = 0;
		int right = strs.length - 1;
		int mid = 0;
		int i = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (strs[mid] != null && strs[mid].equals(str)) {
				res = mid;
				right = mid - 1;
			} else if (strs[mid] != null) {
				if (strs[mid].compareTo(str) < 0) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				i = mid;
				while (strs[i] == null && --i >= left)
					;
				if (i < left || strs[i].compareTo(str) < 0) {
					left = mid + 1;
				} else {
					res = strs[i].equals(str) ? i : res;
					right = i - 1;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs = new String[] { null, "a", null, "a", null, "b", null,
				null, null, "b", null, "c", null, "c", null, null, "d", null,
				null, null, null, null, "d", null, "e", null, null, "e", null,
				null, null, "f", null, "f", null };
		String str1 = "a";
		System.out.println(getIndex(strs, str1));
		String str2 = "b";
		System.out.println(getIndex(strs, str2));
		String str3 = "c";
		System.out.println(getIndex(strs, str3));
		String str4 = "d";
		System.out.println(getIndex(strs, str4));
		String str5 = "e";
		System.out.println(getIndex(strs, str5));
		String str6 = "f";
		System.out.println(getIndex(strs, str6));

	}

}
