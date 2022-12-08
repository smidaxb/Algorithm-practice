package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution167 {
    //左右指针，没啥说的
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
