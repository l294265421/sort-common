package com.liyuncong.sort.sort_common.impl;

import com.liyuncong.sort.sort_common.Sort;

public class InsertSort implements Sort {

	public <T extends Comparable<T>> void sort(T[] a) {
		// TODO Auto-generated method stub
		int length = a.length;
		for(int i = 0; i < length; i++) {
			T key = a[i];
			// 需要与key比较的元素的位置
			int j = i - 1;
			/**
			 * j >= 0保证a[j]存在；
			 * a[j].compareTo(key) > 0保证a[j] > key, a[j]的位置需要后移，
			 * 这时（a[j]后移之后，j自减1之前），j就是key的候选位置；
			 * 如果是因为j < 0而退出while循环的，说明子数组中没有小于key的元素，
			 * 也就是说，0是key的正确位置。
			 */
			while (j >= 0 && a[j].compareTo(key) > 0) {
				// 元素后移一个位置
				a[j+1] = a[j];
				// 需要比较的元素的位置前移
				j--;
			}
			// j+1就是key的正确位置
			a[j+1] = key;
		}
		
	}

}
