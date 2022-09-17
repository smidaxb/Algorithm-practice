package com.smida.algrithm.newCode.base.b07;

import java.util.Arrays;

/**
 * 前缀树
 * 存字符串结构
 * <p>
 * 例子：String[] arr1 和 string[] arr2
 * 1.求 aar2 中哪些字符在 arr1 中出现过，打印
 * 2.求 aar2 中哪些字符在 arr1 中作为前缀出现，打印，并找出出现次数最大的前缀
 *
 * @author YYF
 * @date 2022/9/16 15:08.
 */
public class P7TrieTree {

    private TrieNode root;

    public P7TrieTree() {
        this.root = new TrieNode();
    }

    //往前缀树种插入单词
    public void insert(String str) {
        if (null == str) {
            return;
        }
        TrieNode cur = root;
        //第一次入新建，经过pass++，结尾end++
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ind = ch - 'a';
            //新字符串，新路径
            if (cur.subs[ind] == null) {
                cur.subs[ind] = new TrieNode();
            }
            cur = cur.subs[ind];
            cur.passCount++;
        }
        cur.endCount++;
    }

    //查找是否在前缀树中，并查找插入次数
    public int search(String str) {
        if (null == str) {
            return 0;
        }
        TrieNode cur = root;
        //只要哪个字符没有就返回
        for (int i = 0; i < str.length(); i++) {
            int ind = str.charAt(i) - 'a';
            if (cur.subs[ind] == null) {
                return 0;
            }
            cur = cur.subs[ind];
        }
        //有结尾才返回
        return cur.endCount;
    }

    //从树中删除
    public void delete(String str) {
        if (search(str) == 0) {
            return;
        }
        TrieNode cur = root;
        //经过pass--，结尾end--
        for (int i = 0; i < str.length(); i++) {
            int ind = str.charAt(i) - 'a';
            TrieNode pre = cur;
            cur = cur.subs[ind];
            cur.passCount--;
            //passCount都归零了说明下边不用看了
            if (cur.passCount == 0) {
                pre.subs[ind] = null;
                return;
            }
        }
        cur.endCount--;
    }

    //前缀个数
    public int prefixNum(String str) {
        if (str == null) {
            return 0;
        }
        TrieNode cur = root;
        //经过pass--，结尾end--
        for (int i = 0; i < str.length(); i++) {
            int ind = str.charAt(i) - 'a';
            if (cur.subs[ind] == null) {
                return 0;
            }
            cur = cur.subs[ind];
        }
        return cur.passCount;
    }

    public static class TrieNode {
        public TrieNode() {
            endCount = 0;
            passCount = 0;
            subs = new TrieNode[26];
        }

        //节点存以其结尾次数(可求完整字符串)
        private int endCount;
        //经过该节点次数(可求前缀)
        private int passCount;
        //通往下级节点，26个英文字母
        private TrieNode[] subs;
    }

    /**
     * 1.求 aar2 中哪些字符在 arr1 中出现过，打印
     */
    public static void Retain(String[] arr1, String arr2[]) {
        P7TrieTree trie = new P7TrieTree();
        for (String s : arr1) {
            trie.insert(s);
        }
        for (String s : arr2) {
            if (trie.search(s) > 0) {
                System.out.println(s + " ");
            }
        }
    }

    /**
     * 2.求 aar2 中哪些字符在 arr1 中作为前缀出现，打印，并找出出现次数最大的前缀
     */
    public static void MaxPrefix(String[] arr1, String arr2[]) {
        P7TrieTree trie = new P7TrieTree();
        for (String s : arr1) {
            trie.insert(s);
        }
        int max = Integer.MIN_VALUE;
        String maxPrefix = null;
        for (String s : arr2) {
            int count;
            if ((count = trie.prefixNum(s)) > max) {
                maxPrefix = s;
                max = count;
            }
        }
        System.out.println("最大前缀为：\"" + maxPrefix + "\", 出现了 " + max + " 次");
    }

    public static void main(String[] args) {
        P7TrieTree trie = new P7TrieTree();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNum("zuo"));


        String[] arr1 = new String[]{"abcde","abcd","abc","abcdu","abcdeff"};
        String[] arr2 = new String[]{"abcde","ab"};
        Retain(arr1,arr2);
        MaxPrefix(arr1,arr2);

    }
}
