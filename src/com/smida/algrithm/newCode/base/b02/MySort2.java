package com.smida.algrithm.newCode.base.b02;

import com.smida.algrithm.newCode.SortUtil;

/**
 * Description:b02
 *
 * @author YYF
 * @date 2022/9/6 16:34.
 */
public class MySort2 {
    /**
     * 荷兰国旗问题,快排基础
     * 给num和arr，arr中大于num放左边，小于num放右边，等于num放中间,LR为操作范围
     */
    public static int[] NetherLandsFlag(int[] arr, int num, int L, int R) {
        int index = L;
        //less 及之前为小于num的范围，more及之后为大于num的范围
        int less = L - 1, more = R + 1;
        while (index < more) {
            if (arr[index] == num) {
                index++;
            } else if (arr[index] < num) {
                SortUtil.swap(arr, ++less, index++);
            } else {
                SortUtil.swap(arr, --more, index);
            }
        }
        //等于num的边界：less+1，more-1
        return new int[]{less + 1, more - 1};
    }

    /**
     * 快排
     * 时间复杂度最差n*n，平均n*lgn
     * 空间复杂度lgn（划分点）
     */
    public static void QuickSort(int[] arr) {
//        quickSort(arr, 0, arr.length - 1);
        quickSortRandom(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] edge = NetherLandsFlag(arr, arr[L], L, R);
        quickSort(arr, L, edge[0] - 1);
        quickSort(arr, edge[1] + 1, R);
    }

    private static void quickSortRandom(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //随机快排，随机找一个数
        int randomInd = (int) Math.random() * (R - L + 1) + L;
        int[] edge = NetherLandsFlag(arr, arr[randomInd], L, R);
        quickSort(arr, L, edge[0] - 1);
        quickSort(arr, edge[1] + 1, R);
    }


    /**
     * 堆排序
     * 时间复杂度 n*lgn，空间复杂度 1
     * 数组对应完全二叉树,对节点i
     * 左孩子：2*i+1 右孩子：2*i+2
     * 父节点：(i-1)/2Ï
     */
    public static void HeapSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i <= arr.length - 1; i++) {
            heapBigInsert(arr, i);
        }
        int heapEndInd = arr.length - 1;
        while (0 != heapEndInd) {
            SortUtil.swap(arr, 0, heapEndInd--);
            heapBigFy(arr, heapEndInd, 0);
        }
    }

    //将数组下标i之前建大顶堆,时间复杂度为n： ln1+ln2+ln3....
    private static void heapBigInsert(int[] arr, int ind) {
        // 建大顶堆:从第一个下标开始就看成完全二叉树，比较其父节点与其值，父节点小就交换，每次交换到根节点才停止
        // 下标走完，堆建完
        while (arr[ind] > arr[(ind - 1) / 2]) {
            SortUtil.swap(arr, ind, (ind - 1) / 2);
            ind = (ind - 1) / 2;
        }
    }

    // 在原本是大顶堆的情况下，置换某个节点后，如何重新堆化.限制堆长 heapSize
    // 时间复杂度lgn
    private static void heapBigFy(int[] arr, int heapInd, int ind) {
        while (ind <= heapInd) {
            //先找堆内左右儿子中大的那个
            int lChild = ind * 2 + 1;
            int rChild = ind * 2 + 2;
            int bigChild;
            if (lChild > heapInd) {
                break;
            } else if (rChild > heapInd) {
                bigChild = lChild;
            } else {
                bigChild = arr[lChild] > arr[rChild] ? lChild : rChild;
            }
            //比当前值大则交换，当前值下沉
            if (arr[ind] < arr[bigChild]) {
                SortUtil.swap(arr, ind, bigChild);
                ind = bigChild;
            } else {
                break;
            }
        }
    }

    //建小顶堆
    private static void heapSmallInsert(int[] arr, int ind) {
        while (arr[ind] < arr[(ind - 1) / 2]) {
            SortUtil.swap(arr, ind, (ind - 1) / 2);
            ind = (ind - 1) / 2;
        }
    }

    // 重新小顶堆化
    private static void heapSmallFy(int[] arr, int heapInd, int ind) {
        while (ind <= heapInd) {
            //先找堆内左右儿子中小的那个
            int lChild = ind * 2 + 1;
            int rChild = ind * 2 + 2;
            int smallChild;
            if (lChild > heapInd) {
                break;
            } else if (rChild > heapInd) {
                smallChild = lChild;
            } else {
                smallChild = arr[lChild] < arr[rChild] ? lChild : rChild;
            }
            //比当前值大则交换，当前值下沉
            if (arr[ind] > arr[smallChild]) {
                SortUtil.swap(arr, ind, smallChild);
                ind = smallChild;
            } else {
                break;
            }
        }
    }

    /**
     * 找中位数,endInd为截止位置
     * 用俩堆，大顶堆存小值，小顶堆里存大值，保持两个堆size平衡
     */
    public static int FindMidNum(int[] arr, int endInd) {
        int[] small = new int[endInd + 1];
        int[] big = new int[endInd + 1];
        int smallSize = 0, bigSize = 0;
        for (int i = 0; i <= endInd; i++) {
            int smallTopVal = small[0];
            //大顶堆存小值，小顶堆存大值
            if (smallSize == 0 || arr[i] > smallTopVal) {
                small[smallSize++] = arr[i];
                heapSmallInsert(small, smallSize - 1);
            } else {
                big[bigSize++] = arr[i];
                heapBigInsert(big, bigSize - 1);
            }
            //平衡两个堆
            int moveVal;
            if (smallSize - bigSize > 1) {
                //小顶堆堆顶进大顶堆
                //小顶堆顶出堆，最后一个节点成为新顶点再堆化
                moveVal = small[0];
                SortUtil.swap(small, 0, smallSize - 1);
                smallSize--;
                heapSmallFy(small, smallSize - 1, 0);
                //刚才的小顶堆顶分到大顶堆中
                big[bigSize++] = moveVal;
                heapBigInsert(big, bigSize - 1);
            } else if (bigSize - smallSize > 1) {
                //与上边相反
                moveVal = big[0];
                SortUtil.swap(big, bigSize - 1, 0);
                bigSize--;
                heapBigFy(big, bigSize - 1, 0);
                small[smallSize++] = moveVal;
                heapSmallInsert(small, smallSize - 1);
            }
        }
        SortUtil.printArray(big);
        SortUtil.printArray(small);
        if (bigSize > smallSize) {
            return big[0];
        } else if (bigSize < smallSize) {
            return small[0];
        } else {
            return (big[0] + small[0]) / 2;
        }
    }

    /**
     * 给定数组求排序后相邻最大差值
     * 要求时间复杂度n，不能用非基于比较的排序
     * 解法：找最大和最小值为两级，中间分成len+1个桶，所有数按范围放进去，记录每个桶的最大、最小值，挨个比较过去
     * 空桶是为了避免最大差值在一个桶内部出现
     */
    public static int MaxGap(int[] arr) {
        //先找整个数组最小、最大值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
            min = arr[i] < min ? arr[i] : min;
        }
        //三个数组分别代表桶的数字个数，最小值，最大值,初始化
        int[] countArr = new int[arr.length + 1];
        int[] maxArr = new int[arr.length + 1];
        int[] minArr = new int[arr.length + 1];
        countArr[0] = countArr[arr.length] = 1;
        maxArr[0] = minArr[0] = min;
        maxArr[arr.length] = minArr[arr.length] = max;
        //挨个过一遍
        double bucketV = (max - min) * 1.0 / (arr.length + 1);
        for (int i = 0; i < arr.length; i++) {
            //找到应该分配到第几个桶
            int val = arr[i] - min;
            int bucketInd = ((Double) ((val - min) / bucketV)).intValue();
            //入桶
            countArr[bucketInd]++;
            if (countArr[bucketInd] == 1) {
                maxArr[bucketInd] = minArr[bucketInd] = arr[i];
            } else {
                maxArr[bucketInd] = arr[i] > maxArr[bucketInd] ? arr[i] : maxArr[bucketInd];
                minArr[bucketInd] = arr[i] < minArr[bucketInd] ? arr[i] : minArr[bucketInd];
            }
        }
        //挨个过一遍，计算一个桶的最大值和下一个桶之间最小值的差，找出最大间隙
        int res = Integer.MIN_VALUE;
        int pre = maxArr[0], next;
        for (int i = 0; i < arr.length + 1; i++) {
            if (countArr[i] == 0) {
                continue;
            }
            next = minArr[i];
            res = (next - pre) > res ? next - pre : res;
            pre = maxArr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 22, 233, 4, 533, 66, 7, 89, 9, 10, 11};
        System.out.println(MaxGap(arr));
    }

}
