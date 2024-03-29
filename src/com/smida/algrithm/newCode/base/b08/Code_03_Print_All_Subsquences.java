package com.smida.algrithm.newCode.base.b08;

import java.util.ArrayList;
import java.util.List;

public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = ' ';
		process(chs, i + 1);
		chs[i] = tmp;
	}
	

	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
	}

}
