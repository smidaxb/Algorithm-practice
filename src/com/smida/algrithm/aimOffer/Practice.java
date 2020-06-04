package com.smida.algrithm.aimOffer;

import org.hamcrest.core.Is;

import java.util.*;

/**
 * @author Created by YangYifan on 2020/6/2.
 */
public class Practice {
    /**
     * 3.从尾到头打印链表
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //常规写法
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (null != listNode) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public ArrayList<Integer> printListFromTailToHeadRecursion(ListNode listNode) {
        //递归写法,思路：找到最后一个后add，再add本节点
        ArrayList<Integer> res = new ArrayList<>();
        if (null == listNode) {
            return res;
        }
        if (null != listNode.next) {
            printListFromTailToHeadRecursionSub(res, listNode.next);
        }
        res.add(listNode.val);
        return res;
    }

    private void printListFromTailToHeadRecursionSub(ArrayList<Integer> res, ListNode listNode) {
        if (null != listNode.next) {
            printListFromTailToHeadRecursionSub(res, listNode.next);
        }
        res.add(listNode.val);
    }

    /**
     * 4.重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (null == pre || 0 == pre.length) {
            return null;
        }
        int preStart = 0, inStart = 0;
        int preEnd = pre.length - 1, inEnd = preEnd;
        return reConstructBinaryTree(pre, preStart, preEnd, in, inStart, inEnd);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        int inMid = 0;
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        if (preStart > preEnd) {
            return null;
        }
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                inMid = i;
                break;
            }
        }
        int nextPreEnd = preStart + 1 + (inMid - inStart - 1);
        TreeNode root = new TreeNode(in[inMid]);
        root.left = reConstructBinaryTree(pre, preStart + 1, nextPreEnd, in, inStart, inMid - 1);
        root.right = reConstructBinaryTree(pre, nextPreEnd + 1, preEnd, in, inMid + 1, inEnd);
        return root;
    }

    /**
     * 11.输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    public int NumberOf1(int n) {
        int res = 0;
        while (0 != n) {
            if ((n & 1) == 1) {
                res += 1;
            }
            n = n >>> 1;
        }
        return res;
    }

    /**
     * 13.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 思路：插入排序
     */
    public void reOrderArray(int[] array) {
        if (null == array || array.length <= 1) {
            return;
        }
        int start = 0;
        int oddInd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                oddInd = i;
            } else {
                continue;
            }
            while (oddInd > start) {
                int tem = array[oddInd];
                array[oddInd] = array[oddInd - 1];
                array[oddInd - 1] = tem;
                oddInd--;
            }
            start++;
        }
    }

    /**
     * 14.输入一个链表，输出该链表中倒数第k个结点。
     * 思路：直接跑遍整个链表，算出总节点数，然后直接走
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (null == head || k < 1) {
            return null;
        }
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        if (k > length) {
            return null;
        }
        ListNode res = head;
        for (int i = 0; i < length - k; i++) {
            res = res.next;
        }
        return res;
    }

    /**
     * 19.顺时针打印矩阵
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            //从左到右
            for (int i = left; i <= right; i++) {
                arr.add(matrix[top][i]);
            }
            //从上到下
            for (int i = top + 1; i <= bottom; i++) {
                arr.add(matrix[i][right]);
            }
            //从右到左，判断一行情况
            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    arr.add(matrix[bottom][i]);
                }
            }
            //从下到上，判断一列情况
            if (left != right) {
                for (int i = bottom - 1; i >= top + 1; i--) {
                    arr.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return arr;
    }

    /**
     * 22.二叉树层次遍历
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList res = new ArrayList();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            res.add(node.val);
            if (null != node.left) {
                que.offer(node.left);
            }
            if (null != node.right) {
                que.offer(node.right);
            }
        }
        return res;
    }

    /**
     * 23.判断数组是否是二叉查找树遍历的结果
     * 思路：bst最后一个节点必为跟，左树节点小于跟，又树节点大于跟，递归
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (null == sequence || 0 == sequence.length) {
            return false;
        }
        return judgeBST(sequence, 0, sequence.length - 1);
    }

    private boolean judgeBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        Integer leftEnd = start;
        for (int i = start; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
            leftEnd = i;
        }
        for (int i = leftEnd + 1; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return judgeBST(sequence, start, leftEnd) && judgeBST(sequence, leftEnd + 1, end - 1);
    }

    /**
     * 25.复杂链表复制
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode pCur = pHead;
        //第一步：复制next 如原来是A->B->C 变成A->A'->B->B'->C->C' A->A'->B->B'
        while (null != pCur) {
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = pCur.next.next;
        }
        //第二步:复制random
        pCur = pHead;
        while (null != pCur) {
            RandomListNode cur = pCur.next;
            if (null != pCur.random) {
                cur.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }
        //第三步
        pCur = pHead;
        RandomListNode res = pHead.next;
        RandomListNode cur = res;
        while (null != pCur) {
            pCur.next = pCur.next.next;
            if (null != cur.next) {
                cur.next = cur.next.next;
                cur = cur.next;
            }
            pCur = pCur.next;
        }
        return res;
    }

    /**
     * 26.二叉排序树转链表
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrderToList(list, pRootOfTree);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }

    private void inOrderToList(ArrayList<TreeNode> list, TreeNode root) {
        if (null == root) {
            return;
        }
        inOrderToList(list, root.left);
        list.add(root);
        inOrderToList(list, root.right);
    }

    /**
     * 27字符串全排列
     * 思路：递归法，问题转换为先固定第一个字符，求剩余字符的排列；求剩余字符排列时跟原问题一样。
     * (1) 遍历出所有可能出现在第一个位置的字符（即：依次将第一个字符同后面所有字符交换）；
     * (2) 固定第一个字符，求后面字符的排列（即：在第1步的遍历过程中，插入递归进行实现）。
     * 需要注意的几点：
     * (1) 先确定递归结束的条件，例如本题中可设begin == str.size() - 1;
     * (2) 形如 aba 或 aa 等特殊测试用例的情况，vector在进行push_back时是不考虑重复情况的，需要自行控制；
     * (3) 输出的排列可能不是按字典顺序排列的，可能导致无法完全通过测试用例，考虑输出前排序，或者递归之后取消复位操作。
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (null == str || 0 == str.length()) {
            return null;
        }
        char[] arr = str.toCharArray();
        TreeSet set = new TreeSet();
        Permutation(arr, 0, set);
        res.addAll(set);
        return res;
    }

    //set用于字典排序
    private void Permutation(char[] arr, int begin, TreeSet set) {
        if (begin < 0 || begin > arr.length - 1) {
            return;
        }

        if (begin == arr.length - 1) {
            set.add(String.valueOf(arr));
            return;
        }
        for (int i = begin; i < arr.length; i++) {
            swap(arr, begin, i);
            Permutation(arr, begin + 1, set);
            swap(arr, begin, i);
        }
    }

    private void swap(char[] arr, int begin, int i) {
        char tmp = arr[begin];
        arr[begin] = arr[i];
        arr[i] = tmp;
    }

    /**
     * 30连续子数组最大和
     * 思路：动态规划：
     * max：包含arr[i]的，连续子数组最大值
     * res：连续子数组最大和
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            max = max + array[i] > array[i] ? max + array[i] : array[i];
            res = res > max ? res : max;
        }
        return res;
    }

    /**
     * 33丑数
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * 思路：穷举
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 1) {
            return index;
        }
        int[] uglyNums = new int[index];
        int n2 = 0, n3 = 0, n5 = 0;
        uglyNums[0] = 1;
        for (int i = 1; i < index; i++) {
            uglyNums[i] = min(uglyNums[n2] * 2, uglyNums[n3] * 3, uglyNums[n5] * 5);
            if (uglyNums[i] == uglyNums[n2] * 2) {
                n2++;
            }
            if (uglyNums[i] == uglyNums[n3] * 3) {
                n3++;
            }
            if (uglyNums[i] == uglyNums[n5] * 5) {
                n5++;
            }
        }
        return uglyNums[index - 1];
    }

    private int min(int a, int b, int c) {
        if (a < b) {
            return c < a ? c : a;
        }
        return c < b ? c : b;
    }

    /**
     * 35数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     */
    private int resultNi = 0;

    public int InversePairs(int[] array) {
        int[] arrTemp = new int[array.length];
        int result = 0;
        //归并排序,传入result进行统计逆序对
        mergeSort(array, 0, array.length - 1, arrTemp);
        result = resultNi % 1000000007;
        resultNi = 0;
        return result;
    }

    //归并排序
    private void mergeSort(int[] array, int left, int right, int[] arrTemp) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid, arrTemp);
        mergeSort(array, mid + 1, right, arrTemp);
        //归并
        merge(array, left, mid, right, arrTemp);
    }

    private void merge(int[] array, int left, int mid, int right, int[] arrTemp) {
        int s1 = left, s2 = mid + 1;
        int sArrTemp = left;
        int end1 = mid, end2 = right;
        while (end1 >= left && end2 >= mid + 1) {
            if (array[end1] > array[end2]) {
                end1--;
                resultNi += (end2 - mid);
                if (resultNi > 1000000007) {
                    resultNi = resultNi % 1000000007;
                }
            } else {
                end2--;
            }
        }
        while (s1 <= mid && s2 <= right) {
            if (array[s1] < array[s2]) {
                arrTemp[sArrTemp] = array[s1];
                sArrTemp++;
                s1++;
            } else {
                arrTemp[sArrTemp] = array[s2];
                sArrTemp++;
                s2++;
            }
        }
        while (s1 <= mid) {
            arrTemp[sArrTemp] = array[s1];
            sArrTemp++;
            s1++;
        }
        while (s2 <= right) {
            arrTemp[sArrTemp] = array[s2];
            sArrTemp++;
            s2++;
        }
        sArrTemp = left;
        while (sArrTemp <= right) {
            array[sArrTemp] = arrTemp[sArrTemp];
            sArrTemp++;
        }
    }

    /**
     * 38二叉树深度39是否平衡二叉树
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ldeep = TreeDepth(root.left);
        int rdeep = TreeDepth(root.right);
        return ldeep > rdeep ? ldeep + 1 : rdeep + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (null == root) {
            return true;
        }
        int i = TreeDepth(root.left) - TreeDepth(root.right);
        if (Math.abs(i) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    /**
     * 40数组中只出现一次的两个数字
     * 可以用位运算实现，如果将所有所有数字相异或，则最后的结果肯定是那两个只出现一次的数字异或
     * 的结果，所以根据异或的结果1所在的最低位，把数字分成两半，每一半里都还有只出现一次的数据和成对出现的数据
     * 这样继续对每一半相异或则可以分别求出两个只出现一次的数字
     */
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        int yihuo = 0;
        int flag = 1;
        for (int i = 0; i < array.length; i++) {
            yihuo ^= array[i];
        }
        while ((flag & yihuo) == 0) {
            flag <<= 1;
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & flag) == 0) {
                num1[0] ^= array[i];
                continue;
            }
        }
        num2[0] = num1[0] ^ yihuo;
    }

    /**
     * 41和为s的连续正数序列
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * 思路：滑动窗口
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                phigh++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }


    /**
     * 43左旋字符串
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     * 思路：YX = (XTYT)T 两次翻转，再总翻转
     */



}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
