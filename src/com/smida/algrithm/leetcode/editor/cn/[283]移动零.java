package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution283 {
    //双指针
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0){
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
            fast++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
