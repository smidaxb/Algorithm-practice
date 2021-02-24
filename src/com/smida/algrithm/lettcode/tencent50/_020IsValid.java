package com.smida.algrithm.lettcode.tencent50;

import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class _020IsValid {
    public static boolean isValid(String s) {
        if (null == s || s.length() < 2) {
            return false;
        }
        char[] arr = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stack.push(arr[i]);
            } else if (arr[i] == ')' || arr[i] == '}' || arr[i] == ']') {
                switch (arr[i]) {
                    case ')':
                        if (Character.valueOf('(').equals(stack.peek())) {
                            stack.pop();
                            break;
                        }
                        return false;
                    case '}':
                        if (Character.valueOf('{').equals(stack.peek())) {
                            stack.pop();
                            break;
                        }
                        return false;
                    case ']':
                        if (Character.valueOf('[').equals(stack.peek())) {
                            stack.pop();
                            break;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }




    public static void main(String[] args) {
        System.out.println(isValid("([abccccc])"));

    }
}
