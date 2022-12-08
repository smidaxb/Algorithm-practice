package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {

    //中心扩展
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }



    //简单中心扩展
    public String longestPalindrome1(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        for (int i = 0; i < n; i++) {
            int pv = 0;
            while ((i + pv) < n && (i - pv) >= 0 && T.charAt(i + pv) == T.charAt(i - pv)) {
                P[i] = pv;
                pv++;
            }
        }
        int ind = 0;
        int val = 0;
        for (int i = 0; i < n; i++) {
            if (P[i] > val) {
                val = P[i];
                ind = i;
            }
        }
        int start = (ind - val) / 2;
        int end = start + val;
        return s.substring(start, end);
    }

    // abc -->  ^#a#b#c#$
    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++) {
            ret += "#" + s.charAt(i);
        }
        ret += "#$";
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
