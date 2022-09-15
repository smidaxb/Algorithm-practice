package com.smida.algrithm.newCode.base.b05;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 * 用两个hashmap实现，一个记录节点和其上级节点，一个记录节点和其所在集合大小
 */
public class P5UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap; //key:kid value:parent
		public HashMap<Node, Integer> sizeMap; //key:node value:set size

		//初始化
		public UnionFindSet(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			makeSets(nodes);
		}

		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		//找头节点
		private Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father);
			return father;
		}

		//是否在一个集合
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		//将两个节点所在集合合并
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

}
