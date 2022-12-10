package com.smida.algrithm.leetcode.editor.cn;


import com.smida.algrithm.newCode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution144 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal2(root);
    }

    //递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (null == root) {
            return res;
        }
        res.add(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
        return res;
    }

    //迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!= null) {
            //自己先
            stack.push(node);
            res.add(node.val);
            //先往左走
            node = node.left;
            if (node != null) {
                continue;
            }
            //走到底了，依次处理各个栈中节点的右边
            while (node == null && !stack.isEmpty()) {
                node = stack.pop().right;
            }
        }
        return res;
    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = null;
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        new Solution().preorderTraversal2(root);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
