package com.liyuncong.sort.sort_common.impl;

import com.liyuncong.sort.sort_common.Sort;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

	public void sort(T[] a) {
		this.sort(a, 0, a.length - 1);
	}
	
	public <T extends Comparable<T>> void sort(T[] a, int p, int r) {
		// 确保待排序的子数组中至少有两个元素
		if (p < r) {
			int q = this.partition(a, p, r);
			sort(a, 0, q - 1);
			sort(a, q + 1, r);
		}
	}
	
	/**
	 * 把数组a分解为两部分，比a[r]大的那部分在a[r]的右边，
	 * 比a[r]小的那部分在a[r]的左边；
	 * 实际上就是在数组中寻找a[r]最终位置
	 * @param a
	 * @param p
	 * @param r
	 * @return
	 */
	private <T extends Comparable<T>> int partition(T[] a, int p, int r) {
		T temp = a[r];
		// i是数组中已知比a[r]小的最右边元素的位置
		int i = p - 1;
		for(int j = p; j <= r - 1; j++){
			/**
			 * 如果a[j]比temp小，就应该放在a[i]的下一个位置；
			 * 而且应该把a[i]下一个位置的元素放在a[j]的位置上
			 */
			if (a[j].compareTo(temp) < 0) {
				i++;
				T temp2 = a[j];
				a[j] = a[i];
				a[i] = temp2;
			}
		}
		i++;
		a[r] = a[i];
		a[i] = temp;
		return i;
	}
	
	public static void main(String[] args) {
		Integer[] heap = new Integer[]{0, 3, 1, 5, 12, 7};
		new QuickSort<Integer>().sort(heap);
		for (int i = 0; i < heap.length; i++) {
			System.out.println(heap[i]);
		}
	}
}
