package com.smida.algrithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution96 {
    public int numTrees(int n) {
        return sub(1, n);
    }

    //用来缓存中间结果
    Map<String, Integer> map = new HashMap<>();
    //从 l 到 r 的数字能组成几种结果
    private int sub(int l, int r) {
        if (l >= r) {
            return 1;
        }
        if (r - l == 1) {
            return 2;
        }

        Integer c = map.get(l+","+r);
        if (c != null) {
            return c;
        }
        int res = 0;
        //这里以 i 为根节点， 依次加起来
        for (int i = l; i <= r; i++) {
            int subL = sub(l, i - 1);
            int subR = sub(i + 1, r);
            res += (subL * subR);
            map.put(l + "," + r, res);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
