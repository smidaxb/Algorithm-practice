package com.smida.algrithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution912 {
    //写个标准快排
    public int[] sortArray(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }

    private int[] quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return nums;
        }
        int pInd = partition(nums, l, r);
        quickSort(nums, l, pInd - 1);
        quickSort(nums, pInd + 1, r);
        return nums;
    }

    //把 p 放中间，左边 <= p , 右边 > p
    private int partition(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int i = l, j = r;
        int p = nums[l];
        while (i < j) {
            //左指针移动到第一个比 p 大的位置
            while (i < r && nums[i] <= p) {
                i++;
            }
            //右指针移动到第一个 小于等于 p的位置
            while (j > l && nums[j] > p) {
                j--;
            }
            if (i < j) {
                //交换
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int tmp = nums[l];
        nums[l] = nums[j];
        nums[j] = tmp;
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
