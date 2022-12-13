package com.smida.algrithm.leetcode.editor.cn;

import com.smida.algrithm.leetcode.editor.cn.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class NestedIterator implements Iterator<Integer> {
    //直接展开初始化
//    private Iterator<Integer> iterator;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        List<Integer> list = new ArrayList<>();
//        expandNL(nestedList, list);
//        iterator = list.iterator();
//    }
//
//    private void expandNL(List<NestedInteger> nestedList, List<Integer> list) {
//        for (NestedInteger nestedInteger : nestedList) {
//            if (nestedInteger.isInteger()) {
//                list.add(nestedInteger.getInteger());
//            } else {
//                expandNL(nestedInteger.getList(), list);
//            }
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return iterator.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return iterator.hasNext();
//    }

    //惰性加载
    private LinkedList<NestedInteger> list;


    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> first = list.remove(0).getList();
            for (int i = first.size() - 1; i >= 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return list.size() > 0;
    }


}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
