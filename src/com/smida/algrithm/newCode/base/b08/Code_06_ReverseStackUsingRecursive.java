package com.smida.algrithm.newCode.base.b08;

import java.util.Stack;

/**
 * 逆序栈
 */
public class Code_06_ReverseStackUsingRecursive {

	//父递归反转栈：取栈底，反转剩下的栈(递归)，再将栈底入栈成为栈顶
	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}

	//子递归取栈底：出栈当前值，为栈底直接返回，否则接着取栈底(递归)，然后当前值入栈
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}

	}

}
