package com.smida.algrithm.newCode.base.b05;

import java.util.HashMap;

/**
 * 设计RandomPool，在该结构中有如下三个功能:
 * insert(key):将某个key加入到该结构，做到不重复加入。
 * delete(key):将原本在结构中的某个key移除。
 * getRandom(): 等概率随机返回结构中的任何一个key。
 * 要求：Insert、delete和getRandom方法的时间复杂度都是 O(1)
 * 思路：用两个hashmap，一个存 key-key在pool中次序，一个存 key在pool中次序-key，再用一个size参数记录次序大小
 * insert：分别存入两个hashmap
 * delete：先拿到次序，然后将最近入pool的元素覆盖到该位置，再将最近入pool元素删掉
 * get：生成随机数再获取
 */
public class P5RandomPool {

    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        //初始化
        public Pool() {
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            this.size = 0;
        }

        //入pool
        public void insert(K key) {
            if (!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size, key);
                this.size++;
            }
        }

        //删key
        public void delete(K key) {
            if (this.keyIndexMap.containsKey(key)) {
                int deleteIndex = this.keyIndexMap.get(key);
                //获取最后一个，覆盖到要删除的key上
                int lastIndex = this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                //把最后一个删除
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
                this.size--;
            }
        }

        //拿key
        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
            return this.indexKeyMap.get(randomIndex);
        }

    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        for (int i = 0; i < 9; i++) {
            System.out.println(pool.getRandom());
        }
    }

}
