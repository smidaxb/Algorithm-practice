package com.smida.algrithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
//一个arrayList存元素，要删除就给它换到最后一位，然后remove，一个hash表判断是否存在并记录位置
class RandomizedSet {
    ArrayList<Integer> arr = new ArrayList<>();
    //val , ind
    HashMap<Integer, Integer> map = new HashMap<>();
    int size = 0;

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        //自己控制size，存入数组的同时将位置下标存到hash表中
        if (!map.containsKey(val)) {
            if (arr.size() > size) {
                arr.set(size, val);
            } else {
                arr.add(val);
            }
            map.put(val, size);
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            //要删除元素不是最后一个元素时，删除时只要把数组最后一位元素放入要删除的位置，然后将数组长度减一
            arr.set(map.get(val), arr.get(size - 1));
            //注意移动之后也要把坐标修改
            map.put(arr.get(size - 1), map.get(val));
            map.remove(val);
            size--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        int ind = new Random().nextInt(size);
        return arr.get(ind);
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
