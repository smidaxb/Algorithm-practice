package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

/**
 * 判断T1的子树是否是T2的拓扑结构
 */
public class Problem_12_T1SubtreeEqualsT2 {
    //标准答案
	public static boolean isSubtree(TreeNode t1, TreeNode t2) {
		String t1Str = serialByPre(t1);
		String t2Str = serialByPre(t2);
		return getIndexOf(t1Str, t2Str) != -1;
	}

	public static String serialByPre(TreeNode head) {
		if (head == null) {
			return "#!";
		}
		String res = head.val + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}

	// KMP
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int[] nextArr = getNextArray(ms);
		int index = 0;
		int mi = 0;
		while (index < ss.length && mi < ms.length) {
			if (ss[index] == ms[mi]) {
				index++;
				mi++;
			} else if (nextArr[mi] == -1) {
				index++;
			} else {
				mi = nextArr[mi];
			}
		}
		return mi == ms.length ? index - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] nextArr = new int[ms.length];
		nextArr[0] = -1;
		nextArr[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < nextArr.length) {
			if (ms[pos - 1] == ms[cn]) {
				nextArr[pos++] = ++cn;
			} else if (cn > 0) {
				cn = nextArr[cn];
			} else {
				nextArr[pos++] = 0;
			}
		}
		return nextArr;
	}

	//My
    public static boolean isSubtreeMy(TreeNode t1, TreeNode t2) {
        if (null == t1) {
            return false;
        } else if (null == t2) {
            return true;
        }
        return same(t1, t2) || same(t1.left, t2) || same(t1.right, t2);
    }

    private static boolean same(TreeNode t1, TreeNode t2) {
        if (null == t2) {
            return null == t1;
        }
        if (null == t1) {
            return false;
        }
        return t1.val == t2.val && same(t1.left, t2.left) && same(t1.right, t2.right);
    }

    public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.left.left = new TreeNode(4);
		t1.left.right = new TreeNode(5);
		t1.right.left = new TreeNode(6);
		t1.right.right = new TreeNode(7);
		t1.left.left.right = new TreeNode(8);
		t1.left.right.left = new TreeNode(9);

		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(4);
		t2.left.right = new TreeNode(8);
		t2.right = new TreeNode(5);
//		t2.right.left = new TreeNode(9);

		System.out.println(isSubtree(t1, t2));
		System.out.println(isSubtreeMy(t1, t2));

	}

}
