package com.smida.algrithm.book_zuo.chapter_2_listproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 随机链表复制
 */
public class Problem_09_CopyListWithRandom {

	public static class RandomNode {
		public int value;
		public RandomNode next;
		public RandomNode rand;

		public RandomNode(int data) {
			this.value = data;
		}
	}

	public static RandomNode copyListWithRand1(RandomNode head) {
		HashMap<RandomNode, RandomNode> map = new HashMap<RandomNode, RandomNode>();
		RandomNode cur = head;
		while (cur != null) {
			map.put(cur, new RandomNode(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}

	//1-2-3 ---> 1-1c-2-2c-3-3c ---> 1c-2c-3c
	public static RandomNode copyListWithRand2(RandomNode head) {
		if (head == null) {
			return null;
		}
		RandomNode cur = head;
		RandomNode next = null;
		// copy node and link to every node
		while (cur != null) {
			next = cur.next;
			cur.next = new RandomNode(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		RandomNode curCopy = null;
		// set copy node rand
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		RandomNode res = head.next;
		cur = head;
		// split
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
	}

	//用数组记下的random下标，为空则为-1
    public static RandomNode copyListWithRandMy(RandomNode head) {
        if (null == head) {
            return null;
        }
        List<RandomNode> nodeList = new ArrayList<>();
        RandomNode p = head;
        RandomNode headNew = new RandomNode(head.value);
        RandomNode pN = headNew;
        nodeList.add(p);
        p=p.next;
        while (p != null) {
            nodeList.add(p);
            pN.next = new RandomNode(p.value);
            pN = pN.next;
            p=p.next;
        }
        int[] randomInd = new int[nodeList.size()];
        for (int i = 0; i < nodeList.size(); i++) {
            randomInd[i] = -1;
            RandomNode rand = nodeList.get(i).rand;
            if (null == rand) {
                continue;
            }
            for (int j = 0; j < nodeList.size(); j++) {
                if (rand == nodeList.get(j)) {
                    randomInd[i] = j;
                }
            }
        }
        pN = headNew;
        int ind = 0;
        while (null != pN) {
            if (-1 != randomInd[ind]) {
                pN.rand = nodeList.get(randomInd[ind]);
            }
            ind++;
            pN= pN.next;
        }
        return headNew;
    }

	public static void printRandLinkedList(RandomNode head) {
		RandomNode cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RandomNode head = null;
		RandomNode res1 = null;
		RandomNode res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new RandomNode(1);
		head.next = new RandomNode(2);
		head.next.next = new RandomNode(3);
		head.next.next.next = new RandomNode(4);
		head.next.next.next.next = new RandomNode(5);
		head.next.next.next.next.next = new RandomNode(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		res2 = copyListWithRandMy(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}

}
