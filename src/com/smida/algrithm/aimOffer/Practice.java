package com.smida.algrithm.aimOffer;

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
        printListFromTailToHeadRecursionSub(res, listNode);
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
        int nextPreHalfPreStart = preStart +1 ;
        int nextPreHalfPreEnd = nextPreHalfPreStart + (inMid - inStart - 1);
        TreeNode root = new TreeNode(in[inMid]);
        root.left = reConstructBinaryTree(pre, nextPreHalfPreStart, nextPreHalfPreEnd, in, inStart, inMid - 1);
        root.right = reConstructBinaryTree(pre, nextPreHalfPreEnd + 1, preEnd, in, inMid + 1, inEnd);
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
        if (matrix == null || matrix.length == 0) {
            return arr;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            //从左到右
            for (int i = left; i < right; i++) {
                arr.add(matrix[top][i]);
            }
            //从上到下
            for (int i = top + 1; i < bottom; i++) {
                arr.add(matrix[i][right]);
            }
            //从右到左，判断一行情况
            if (top != bottom) {
                for (int i = right; i > left; i--) {
                    arr.add(matrix[bottom][i]);
                }
            }
            //从下到上，判断一列情况
            if (left != right) {
                for (int i = bottom; i > top; i--) {
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
        TreeSet set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
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
            max = Math.max(max + array[i], array[i]);
            res = Math.max(res, max);
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
        if (left >= right) {
            return;
        }
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
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                phigh++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (cur < sum) {
                phigh++;
            } else {
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


    /**
     * 47.求1+2+3+...+n
     * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 思路：递归算，boolean值做判断
     */
    public int Sum_Solution(int n) {
        int res = n;
        //第二个条件表达式重点只是为了计算res，后边的条件可以随便写
        boolean a = (n > 0) && ((res += Sum_Solution(n - 1)) == 0);
        return res;
    }

    /**
     * 48.非加减乘除做加法
     * 思路：异或操作算非进位和，按位与再左移操作算进位和，当无进位和时直接异或返回
     */
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int tmp = num1 ^ num2;
            num2 = ((num1 & num2) << 1);
            num1 = tmp;
        }
        return num1 ^ num2;
    }

    /**
     * 51构建乘积数组
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     * 思路，先算下三角，再算上三角相乘
     */
    public int[] multiply(int[] A) {
        int[] res = new int[A.length];
        if (A.length < 1) {
            return res;
        }
        res[0] = 1;
        for (int i = 1; i < A.length; i++) {
            res[i] = res[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            res[i] *= tmp;
        }
        return res;
    }

    /**
     * 55.链表中环的入口节点
     * 思路：
     * 设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，一定相遇于环中某点(结论1)。
     * 接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口(结论2)。以下是两个结论证明：
     * 两个结论：
     * 1、设置快慢指针，假如有环，他们最后一定相遇。
     * 2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
     * 证明结论1：设置快慢指针fast和low，fast每次走两步，low每次走一步。假如有环，两者一定会相遇
     * （因为low一旦进环，可看作fast在后面追赶low的过程，每次两者都接近一步，最后一定能追上）。
     * 证明结论2：
     * 设：
     * 链表头到环入口长度为--a
     * 环入口到相遇点长度为--b
     * 相遇点到环入口长度为--c
     * <p>
     * 则：相遇时
     * 快指针路程=a+(b+c)k+b ，k>=1  其中b+c为环的长度，k为绕环的圈数（k>=1,即最少一圈，不能是0圈，不然和慢指针走的一样长，矛盾）。
     * 慢指针路程=a+b
     * 快指针走的路程是慢指针的两倍，所以：
     * （a+b）*2=a+(b+c)k+b
     * 化简可得：
     * a=(k-1)(b+c)+c 这个式子的意思是：
     * 链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。其中k>=1,所以k-1>=0圈。
     * 所以两个指针分别从链表头和相遇点出发，最后一定相遇于环入口。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (fast != null) {
            if (slow == fast) {
                fast = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast;
    }

    /**
     * 56删除链表中重复的节点
     * 1-2-3-3-4-5-5-6 =====> 1-2-4-6
     */
    //非递归
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode pre, resPre = pre = new ListNode(0);
        pre.next = pHead;
        ListNode cur = pHead;
        while (cur != null) {
            ListNode next = cur.next;
            //若不等，直接继续
            if (next == null || cur.val != next.val) {
                pre = pre.next;
                cur = next;
                continue;
            }
            //若相等，一直走到下一个不等处
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur = next;
            pre.next = cur;
        }
        return resPre.next;
    }

    //递归
    public ListNode deleteDuplicationRecursive(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        if (pHead.next.val == pHead.val) {
            int val = pHead.val;
            while (pHead != null && pHead.val == val) {
                pHead = pHead.next;
            }
            return deleteDuplicationRecursive(pHead);
        }
        pHead.next = deleteDuplicationRecursive(pHead.next);
        return pHead;
    }

    /**
     * 59按之字形顺序打印二叉树
     * 60层次遍历二叉树，每层分别输出
     */
    public ArrayList<ArrayList<Integer>> PrintZHI(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> que = new LinkedList();
        que.offer(pRoot);
        ArrayList<Integer> sizeList = new ArrayList<>();
        sizeList.add(1);
        int level = 1;
        while (!que.isEmpty()) {
            int size = sizeList.get(level - 1);
            int nextSize = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            while (size > 0) {
                TreeNode node = que.poll();
                arr.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                    nextSize++;
                }
                if (node.right != null) {
                    que.offer(node.right);
                    nextSize++;
                }
                size--;
            }
            level++;
            if (level % 2 == 0) {
                int left = 0;
                int right = arr.size() - 1;
                while (left < right) {
                    int tmp = arr.get(left);
                    arr.set(left, arr.get(right));
                    arr.set(right, tmp);
                    left++;
                    right--;
                }
            }
            sizeList.add(nextSize);
            res.add(arr);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> que = new LinkedList();
        que.offer(pRoot);
        ArrayList<Integer> sizeList = new ArrayList<>();
        sizeList.add(1);
        int level = 1;
        while (!que.isEmpty()) {
            int size = sizeList.get(level - 1);
            int nextSize = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            while (size > 0) {
                TreeNode node = que.poll();
                arr.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                    nextSize++;
                }
                if (node.right != null) {
                    que.offer(node.right);
                    nextSize++;
                }
                size--;
            }
            level++;
            sizeList.add(nextSize);
            res.add(arr);
        }
        return res;
    }

    /**
     * 65矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * 思路：回溯法
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (null == matrix || matrix.length == 0 || null == str || str.length < 1 || matrix.length < rows * cols || str.length > matrix.length) {
            return false;
        }
        boolean[] beUsed = new boolean[matrix.length];
        for (int index = 0; index < matrix.length; index++) {
            int i = index / cols;
            int j = index % cols;
            if (matrix[index] == str[0]) {
                //每次开始前重置路径使用数组
                resetBeUsed(beUsed);
                //找到path直接返回true
                if (judgeSuccess(matrix, rows, cols, i, j, str, 0, beUsed)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judgeSuccess(char[] matrix, int rows, int cols, int i, int j, char[] str, int pathIndex, boolean[] beUsed) {
        //越界直接返回false
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }
        int ind = i * cols + j;
        //被使用或不等与当前直接返回false
        if (matrix[ind] != str[pathIndex] || beUsed[ind]) {
            return false;
        }
        beUsed[ind] = true;
        //若已完成匹配
        if (pathIndex == str.length - 1) {
            return true;
        }
        return judgeSuccess(matrix, rows, cols, i, j - 1, str, pathIndex + 1, beUsed)//向左
                || judgeSuccess(matrix, rows, cols, i, j + 1, str, pathIndex + 1, beUsed)//向右
                || judgeSuccess(matrix, rows, cols, i - 1, j, str, pathIndex + 1, beUsed)//向上
                || judgeSuccess(matrix, rows, cols, i + 1, j, str, pathIndex + 1, beUsed);//向下
    }

    private void resetBeUsed(boolean[] beUsed) {
        for (int i = 0; i < beUsed.length; i++) {
            beUsed[i] = false;
        }
    }

    /**
     * 66机器人的运动范围
     * 地上有一个m行和n列的方格。
     * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
     * 请问该机器人能够达到多少个格子？
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 1 || cols < 1) {
            return 0;
        }
        boolean[][] isVisited = new boolean[rows][cols];
        return helper(0, 0, rows, cols, threshold, isVisited);
    }

    private int helper(int i, int j, int rows, int cols, int threshold, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || getRCNum(i) + getRCNum(j) > threshold || isVisited[i][j] == true) {
            return 0;
        }
        isVisited[i][j] = true;
        return helper(i - 1, j, rows, cols, threshold, isVisited) +
                helper(i + 1, j, rows, cols, threshold, isVisited) +
                helper(i, j - 1, rows, cols, threshold, isVisited) +
                helper(i, j + 1, rows, cols, threshold, isVisited) + 1;
    }

    int getRCNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num = num / 10;
        }
        return sum;
    }

    /**
     * 67剪绳子
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
     * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * <p>
     * 思路：特殊情况：对2：1*1=1，对3：2*1=2，对4：2*2=4；
     * 绳子长度>=4时，5<2*3，6<3*3，7<5*2<3*2*2......
     * 故只看2或3，且只有2、3时，3的优先级更高，因为2*2*2<3*3
     */
    public int cutRope(int target) {
        int res = 1;
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int mod3 = target % 3;
        if (mod3 == 1) {
            res *= (2 * 2);
            target = target - res;
        } else if (mod3 == 2) {
            res *= 2;
            target = target - res;
        }
        int count3 = target / 3;
        if (count3 > 0) {
            for (int i = 0; i < count3; i++) {
                res *= 3;
            }
        }
        return res;
    }

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
