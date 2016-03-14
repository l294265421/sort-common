package com.liyuncong.sort.sort_common.impl;

import com.liyuncong.sort.sort_common.Sort;

public class BubbleSort <T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] a) {
		int len = a.length;
		// 针对前i个元素
		for(int i = len - 1; i >= 1; i--) {
			// 把最大元素放到最后，也就是沉下去
			for(int j = 0; j < i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					T temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
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
