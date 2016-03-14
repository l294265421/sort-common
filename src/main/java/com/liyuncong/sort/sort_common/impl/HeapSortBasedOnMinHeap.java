package com.liyuncong.sort.sort_common.impl;

import com.liyuncong.sort.heap.MinHeap;
import com.liyuncong.sort.sort_common.Sort;

public class HeapSortBasedOnMinHeap<T extends Comparable<T>> extends MinHeap<T> implements Sort<T>{
	/**
	 * 排序0到a.length-1的元素
	 */
	public void sort(T[] a) {
		// 最初，堆的长度就是整个数组的长度
		int heapLength = a.length;
		buildHeap(a, heapLength);
		for(int i = heapLength - 1; i >= 0; i--){
			T temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			heapLength--;
			heapify(a, 0, heapLength);
		}
	}
	
	public static void main(String[] args) {
		Integer[] heap = new Integer[]{0, 3, -1, 5, 12, 7};
		new HeapSortBasedOnMinHeap<Integer>().sort(heap);
		for(Integer integer : heap){
			System.out.println(integer);
		}
	}
}
