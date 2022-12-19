package com.smida.algrithm.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * 哈希表 + 双向链表实现
 */
class LRUCache {
    Map<Integer, CacheNode> map;
    CacheNode head = new CacheNode();
    CacheNode tail = new CacheNode();
    int size = 0;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        CacheNode cache = map.get(key);
        if (null == cache) {
            return -1;
        }
        moveToFirst(cache);
        return cache.getVal();
    }

    public void put(int key, int value) {
        System.out.println("put" + key + ":" + value);
        CacheNode cache = map.get(key);
        if (null != cache) {
            cache.setVal(value);
            moveToFirst(cache);
            return;
        }
        if (size >= capacity) {
            removeLast();
        }
        if (size < capacity) {
            cache = new CacheNode(key, value);
            map.put(key, cache);
            addToFirst(cache);
            size++;
        }
    }

    private void moveToFirst(CacheNode node) {
        remove(node);
        addToFirst(node);
    }

    private void addToFirst(CacheNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void removeLast() {
        CacheNode last = tail.getPre();
        remove(last);
        map.remove(last.getKey());
        size--;
    }

    private void remove(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    class CacheNode {
        private Integer key;
        private Integer val;
        private CacheNode next;
        private CacheNode pre;

        public CacheNode(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }

        public CacheNode() {
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public CacheNode getNext() {
            return next;
        }

        public void setNext(CacheNode next) {
            this.next = next;
        }

        public CacheNode getPre() {
            return pre;
        }

        public void setPre(CacheNode pre) {
            this.pre = pre;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
