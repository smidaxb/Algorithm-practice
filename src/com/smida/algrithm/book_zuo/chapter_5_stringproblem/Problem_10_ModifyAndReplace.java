package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

/**
 * replace:字符串调整与替换
 * 把空字符换成"%20"
 * <p>
 * modify:将字符串中的*移到最前边，其他元素相对位置不改变，要求时间复杂度n，空间复杂度1
 */
public class Problem_10_ModifyAndReplace {
    //My
    public static void replaceMy(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int emptyCount = 0;
        int lenOld = 0;
        int word = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == 0) {
                break;
            }
            if (chas[i] == ' ') {
                emptyCount++;
            }else {
            	word++;
			}
        }
        lenOld = word+emptyCount;
        int lenNew = word + emptyCount * "%20".length();
		while (lenNew>0){
			if (chas[--lenOld] != ' ') {
				chas[--lenNew] = chas[lenOld];
			}else {
				chas[--lenNew] = '0';
				chas[--lenNew] = '2';
				chas[--lenNew] = '%';
			}
		}
    }

    public static void modifyMy(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int len = chas.length;
		for (int i = chas.length-1; i >= 0; i--) {
			if (chas[i] != '*') {
				chas[--len] = chas[i];
			}
		}
		while (len > 0) {
			chas[--len] = '*';
		}
    }

    //标准答案
    public static void replace(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int num = 0;
        int len = 0;
        for (len = 0; len < chas.length && chas[len] != 0; len++) {
            if (chas[len] == ' ') {
                num++;
            }
        }
        int j = len + num * 2 - 1;
        for (int i = len - 1; i > -1; i--) {
            if (chas[i] != ' ') {
                chas[j--] = chas[i];
            } else {
                chas[j--] = '0';
                chas[j--] = '2';
                chas[j--] = '%';
            }
        }
    }

    public static void modify(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int j = chas.length - 1;
        for (int i = chas.length - 1; i > -1; i--) {
            if (chas[i] != '*') {
                chas[j--] = chas[i];
            }
        }
        for (; j > -1; ) {
            chas[j--] = '*';
        }
    }

    public static void main(String[] args) {
        char[] chas1 = {'a', ' ', 'b', ' ', ' ', 'c', 0, 0, 0, 0, 0, 0, 0, 0,0,0};
        replaceMy(chas1);
        System.out.println(String.valueOf(chas1));

        char[] chas2 = {'1', '2', '*', '*', '3', '4', '5'};
        modifyMy(chas2);
        System.out.println(String.valueOf(chas2));

    }

}
