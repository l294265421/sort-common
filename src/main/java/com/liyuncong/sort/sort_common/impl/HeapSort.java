package com.liyuncong.sort.sort_common.impl;

import com.liyuncong.sort.sort_common.Sort;

public class HeapSort implements Sort {

	public <T extends Comparable<T>> void sort(T[] a) {
		// 最初，堆的长度就是整个数组的长度
		int heapLength = a.length - 1;
		buildMaxHeap(a, heapLength);
		for(int i = heapLength; i >= 2; i--){
			T temp = a[i];
			a[i] = a[1];
			a[1] = temp;
			heapLength--;
			maxHeapify(a, 1, heapLength);
		}
	}

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	private int parent(int i) {
		// i为根结点
		if (i == 1) {
			return 0;
		}
		return i / 2;
	}

	/**
	 * 数组从下标1开始存储堆中元素；
	 * @param a 保存堆得数组
	 * @param i 堆中需要下降的元素
	 * @param heapLength 数组中最右边堆元素的位置
	 */
	public <T extends Comparable<T>> void maxHeapify(T[] a, int i, int heapLength) {
		int l = left(i);
		int r = right(i);
		int largest = 0;
		/**
		 * 下面两个if条件句用来找到三个元素中的最大元素的位置largest； 
		 * l <= heapLength说明l在数组内，i非叶子结点；
		 */
		if (l <= heapLength && a[i].compareTo(a[l]) < 0) {
			largest = l;
		} else {
			largest = i;
		}
        // r <= heapLength说明r在数组内
		if (r <= heapLength && a[largest].compareTo(a[r]) < 0) {
			largest = r;
		}
		// 如果i处元素不是最大的，就把i处的元素与最大处元素交换，交换会使元素下降
		if (i != largest) {
			T temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			// 递归下沉
			maxHeapify(a, largest, heapLength);
		}
	}

	public <T extends Comparable<T>> void buildMaxHeap(T[] a, int heapLength) {
		int lengthParent = parent(heapLength);
		// 最初，parent(length)之后的所有元素都是叶子结点
		for(int i = lengthParent; i >= 1; i--){
			maxHeapify(a, i, heapLength);
		}
	}
	
	public static void main(String[] args) {
		Integer[] heap = new Integer[]{0, 3, 1, 5, 12, 7};
		new HeapSort().sort(heap);
		for(Integer integer : heap){
			System.out.println(integer);
		}
	}

}
