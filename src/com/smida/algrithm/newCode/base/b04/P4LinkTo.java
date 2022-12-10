package com.smida.algrithm.newCode.base.b04;

import com.smida.algrithm.newCode.TreeNode;
import com.smida.algrithm.newCode.TreeUtil;

import java.util.Stack;

/**
 * 二叉树后继节点
 * 思路一：找个数组给存起来，中序遍历后找下一个就行
 * 思路二：有右子树：找右子树最左的那个
 * 没有右子树：找parent，如果是parent的左子树，直接返回parent，是右子树，找parent的parent，直到是左子树为止
 * 代码见：com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem.Problem_17_getNextNode
 * <p>
 * 二叉树序列化和反序列化
 * 代码见：com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem.Problem_04_SerializeAndReconstructTree
 * <p>
 * 判断平衡二叉树
 * 思路：递归，左右子树树高不超过1，且左右子树均为平衡二叉树
 * 代码见：com.smida.algrithm.aimOffer.Practice#IsBalanced_Solution
 * <p>
 * 判断是否搜索二叉树
 * 思路一：递归，左子树value ≤ cur.value ≤ 右子树value，且左右子树均为搜索二叉树
 * 思路二：中序遍历二叉树，存到一个数组里，看是不是有序的
 * 代码见下方
 * <p>
 * 判断是否完全二叉树
 * 思路：层次遍历，不允许某个节点出队后左空右不空，且一旦出现空节点后，后续出队节点必须左右均空
 * 代码见：com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem.Problem_15_IsCBT
 *
 * @author YYF
 * @date 2022/9/14 15:48.
 */
public class P4LinkTo {
    //递归，判断搜索二叉树
    public static boolean judgeSearchTreeR(TreeNode head) {
        if (head == null) {
            return true;
        }
        int lv = null != head.left ? head.left.val : Integer.MIN_VALUE;
        int rv = null != head.right ? head.right.val : Integer.MAX_VALUE;
        if (lv > head.val || head.val > rv) {
            return false;
        }
        return judgeSearchTree(head.left) && judgeSearchTree(head.left.right);
    }

    //非递归，判断搜索二叉树,就是中序遍历做比较
    public static boolean judgeSearchTree(TreeNode head) {
        if (head == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head=head.left;
            }else {
                head = stack.pop();
                //把中序遍历打印的换成比较
                if (head.val < pre) {
                    return false;
                }
                pre = head.val;
                head = head.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        TreeUtil.printTree(head);
        System.out.println(judgeSearchTreeR(head));
        System.out.println(judgeSearchTree(head));

    }
}

