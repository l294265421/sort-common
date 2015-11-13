package com.liyuncong.sort.sort_common.impl;

import com.liyuncong.sort.sort_common.Sort;

public class HeapSort implements Sort {

	/**
	 * 排序1到a.length-1的元素
	 */
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

	public int left(int i) {
		return 2 * i;
	}

	public int right(int i) {
		return 2 * i + 1;
	}

	public int parent(int i) {
		// i为根结点
		if (i == 1) {
			return 0;
		}
		return i / 2;
	}

	/**
	 * 数组从下标1开始存储堆中元素；
	 * @param a 保存堆的数组
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
			// 交换元素后，以a[i]为根的树可能不在满足大根堆性质，于是递归调用该方法
			maxHeapify(a, largest, heapLength);
		}
	}

	/**
	 * 建堆
	 * @param a 数组
	 * @param heapLength 堆元素个数
	 */
	public <T extends Comparable<T>> void buildMaxHeap(T[] a, int heapLength) {
		// 从后往前看，lengthParent处的元素是第一个有孩子节点的节点
		int lengthParent = parent(heapLength);
		// 最初，parent(length)之后的所有元素都是叶子结点；
		// 因为大于length/2处元素的孩子节点如果存在，那么
		// 它们的数组下标值必定大于length，这与事实不符；
		// 在数组中，孩子元素必定在父亲元素的后面，从后往前
		// 对元素调用maxHeapify，保证了元素的孩子都是
		// 大根堆
		for(int i = lengthParent; i >= 1; i--){
			maxHeapify(a, i, heapLength);
		}
	}
	
	public static void main(String[] args) {
		Integer[] heap = new Integer[]{0, 3, -1, 5, 12, 7};
		new HeapSort().sort(heap);
		for(Integer integer : heap){
			System.out.println(integer);
		}
	}

}
