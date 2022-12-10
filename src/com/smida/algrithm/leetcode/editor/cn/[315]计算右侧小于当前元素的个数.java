package com.smida.algrithm.leetcode.editor.cn;

import sun.security.util.ArrayUtil;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] res;
    int[] tmp;
    int[] index;
    int[] tempInd;

    //逆序对
    public List<Integer> countSmaller(int[] nums) {
        res = new int[nums.length];
        tmp = new int[nums.length];
        index = new int[nums.length];
        tempInd = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        partition(nums, 0, nums.length - 1);
        List resList = new ArrayList();
        for (int i = 0; i < res.length; i++) {
            resList.add(res[i]);
        }
        return resList;
    }

    private void partition(int[] nums, int l, int r) {
        if (l >= r || l < 0 || r >= nums.length) {
            return;
        }
        int mid = (l + r) >> 1;
        partition(nums, l, mid);
        partition(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int ind = i;
        while (i <= mid || j <= right) {
            if (i == mid + 1) {//左半边走完了
                tempInd[ind] = index[j];
                tmp[ind++] = nums[j++];
            } else if (j == right + 1) {//右半边走完了
                tempInd[ind] = index[i];
                tmp[ind++] = nums[i++];
            } else if (nums[i] <= nums[j]) {//左边小
                tempInd[ind] = index[i];
                tmp[ind++] = nums[i++];
            } else if (nums[i] > nums[j]) {
                tempInd[ind] = index[j];
                tmp[ind++] = nums[j++];
                //左边剩下的都比这个大
                for (int k = i; k <= mid; k++) {
                    res[index[k]] += 1;
                }
            }
        }
        for (int k = left; k <= right; k++) {
            index[k] = tempInd[k];
            nums[k] = tmp[k];
        }
    }

}

//class Solution {
//    private int[] index;
//    private int[] temp;
//    private int[] tempIndex;
//    private int[] ans;
//
//    public List<Integer> countSmaller(int[] nums) {
//        this.index = new int[nums.length];
//        this.temp = new int[nums.length];
//        this.tempIndex = new int[nums.length];
//        this.ans = new int[nums.length];
//        for (int i = 0; i < nums.length; ++i) {
//            index[i] = i;
//        }
//        int l = 0, r = nums.length - 1;
//        mergeSort(nums, l, r);
//        List<Integer> list = new ArrayList<Integer>();
//        for (int num : ans) {
//            list.add(num);
//        }
//        return list;
//    }
//
//    public void mergeSort(int[] a, int l, int r) {
//        if (l >= r) {
//            return;
//        }
//        int mid = (l + r) >> 1;
//        mergeSort(a, l, mid);
//        mergeSort(a, mid + 1, r);
//        merge(a, l, mid, r);
//    }
//
//    public void merge(int[] a, int l, int mid, int r) {
//        int i = l, j = mid + 1, p = l;
//        while (i <= mid && j <= r) {
//            if (a[i] <= a[j]) {
//                temp[p] = a[i];
//                tempIndex[p] = index[i];
//                ans[index[i]] += (j - mid - 1);
//                ++i;
//                ++p;
//            } else {
//                temp[p] = a[j];
//                tempIndex[p] = index[j];
//                ++j;
//                ++p;
//            }
//        }
//        while (i <= mid) {
//            temp[p] = a[i];
//            tempIndex[p] = index[i];
//            ans[index[i]] += (j - mid - 1);
//            ++i;
//            ++p;
//        }
//        while (j <= r) {
//            temp[p] = a[j];
//            tempIndex[p] = index[j];
//            ++j;
//            ++p;
//        }
//        for (int k = l; k <= r; ++k) {
//            index[k] = tempIndex[k];
//            a[k] = temp[k];
//        }
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
