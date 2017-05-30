package com.liyuncong.sort.sort_common.impl;

import com.liyuncong.sort.sort_common.Sort;

/**
 * 选择排序
 * @author liyuncong
 *
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] a) {
		int len = a.length;
		for(int i = 0; i < len; i++) {
			int minIndex = i;
			for(int j = i + 1; j < len; j++) {
				if (a[j].compareTo(a[minIndex]) < 0) {
					minIndex = j;
				}
			}
			T temp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = temp;
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{0, 3, 1, 5, 12, 7};
		new BubbleSort<Integer>().sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
