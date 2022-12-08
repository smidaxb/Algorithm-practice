package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution27 {
    //双指针
    public int removeElement(int[] nums, int val) {
        //fast找不同，slow依次记录
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
