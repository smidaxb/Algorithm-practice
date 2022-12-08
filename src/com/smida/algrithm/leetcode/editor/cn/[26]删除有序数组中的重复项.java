package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution26 {
    //双指针
    public int removeDuplicates(int[] nums) {
        int fast = 0, slow = 0, res = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                res++;
            }
            fast++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
