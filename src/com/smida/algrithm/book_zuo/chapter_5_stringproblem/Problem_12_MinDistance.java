package com.smida.algrithm.book_zuo.chapter_5_stringproblem;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 数组中两个字符串的最小距离
 * strs=[1,2,2,2,3,2,1] str1=1,str2=3 返回2
 * <p>
 * 用last1记录发现str1的上一个位置，用last2...
 * 如果遍历到str1，返回min（min,abs(i-last1)）,。。。
 */
public class Problem_12_MinDistance {

    //My
    public static int minDistanceMy(String[] strs, String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        }
        int last1 = -1, last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if (s.equals(str1)) {
                last1 = i;
                min = Math.min(min, (last2 == -1 ? Integer.MAX_VALUE : i - last2));
            }
            if (s.equals(str2)) {
                last2 = i;
                min = Math.min(min, (last1 == -1 ? Integer.MAX_VALUE : i - last1));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    //标准答案
    public static int minDistance(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        if (str1.equals(str2)) {
            return 0;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i != strs.length; i++) {
            if (strs[i].equals(str1)) {
                min = Math.min(min, last2 == -1 ? min : i - last2);
                last1 = i;
            }
            if (strs[i].equals(str2)) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static class Record {
        private HashMap<String, HashMap<String, Integer>> record;

        public Record(String[] strArr) {
            record = new HashMap<String, HashMap<String, Integer>>();
            HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
            for (int i = 0; i != strArr.length; i++) {
                String curStr = strArr[i];
                update(indexMap, curStr, i);
                indexMap.put(curStr, i);
            }
        }

        private void update(HashMap<String, Integer> indexMap, String str, int i) {
            if (!record.containsKey(str)) {
                record.put(str, new HashMap<String, Integer>());
            }
            HashMap<String, Integer> strMap = record.get(str);
            for (Entry<String, Integer> lastEntry : indexMap.entrySet()) {
                String key = lastEntry.getKey();
                int index = lastEntry.getValue();
                if (!key.equals(str)) {
                    HashMap<String, Integer> lastMap = record.get(key);
                    int curMin = i - index;
                    if (strMap.containsKey(key)) {
                        int preMin = strMap.get(key);
                        if (curMin < preMin) {
                            strMap.put(key, curMin);
                            lastMap.put(str, curMin);
                        }
                    } else {
                        strMap.put(key, curMin);
                        lastMap.put(str, curMin);
                    }
                }
            }
        }

        public int minDistance(String str1, String str2) {
            if (str1 == null || str2 == null) {
                return -1;
            }
            if (str1.equals(str2)) {
                return 0;
            }
            if (record.containsKey(str1) && record.get(str1).containsKey(str2)) {
                return record.get(str1).get(str2);
            }
            return -1;
        }

    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"4", "2", "2", "3", "2", "2", "3",
                "1", "1", "3"};
        System.out.println(minDistance(strArr, "4", "3"));
        System.out.println(minDistanceMy(strArr, "4", "3"));
        System.out.println(minDistance(strArr, "2", "3"));
        System.out.println(minDistanceMy(strArr, "2", "3"));
        System.out.println(minDistance(strArr, "2", "1"));
        System.out.println(minDistanceMy(strArr, "2", "1"));

        System.out.println("=======");

        Record record = new Record(strArr);
        System.out.println(record.minDistance("4", "3"));
        System.out.println(record.minDistance("2", "3"));
        System.out.println(record.minDistance("2", "1"));
    }
}
