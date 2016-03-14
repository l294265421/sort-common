package com.liyuncong.sort.sort_common.impl;

import java.lang.reflect.Array;

import com.liyuncong.sort.sort_common.Sort;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

	@SuppressWarnings("unchecked")
	private void merge(T[] a, int p, int q, int r) {
		// 获得数组left的长度
		int n1 = q - p + 1;
		// 获得数组right的长度
		int n2 = r - q;
		// 创建数组left
		T[] left = (T[]) Array.newInstance(a.getClass().getComponentType(), n1);
		// 创建数组right
		T[] right = (T[]) Array.newInstance(a.getClass().getComponentType(), n2);
        // 把数组a的相应值赋给left
		for(int i = 0; i < n1; i++){
        	left[i] = a[p + i];
        }
		// 把数组a的相应值赋给right
        for(int i = 0; i < n2; i++){
        	right[i] = a[q + 1 + i];
        }
        // left数组当前待处理元素的位置
        int i = 0;
        // left结束标识
        boolean endLeft = false;
        // right数组当前待处理元素的位置
        int j = 0;
        // right结束标识
        boolean engRight = false;
        int k = p;
        while(k <= r){
        	if (left[i].compareTo(right[j]) < 0) {
				a[k] = left[i];
				// 说明left的最后一个元素已被处理
				if (i == (n1 - 1)) {
					endLeft = true;
					k++;
					break;
				}
				i++;
			} else {
				a[k] = right[j];
				// 说明right的最后一个元素已被处理
				if (j == (n2 - 1)) {
					engRight = true;
					k++;
					break;
				}
				j++;
			}
        	k++;
        }
        // 把还没处理完的数组的剩余元素放进a中
        if (endLeft) {
			while(k <= r){
				a[k] = right[j];
				k++;
				j++;
			}
		} else {
			while(k <= r){
				a[k] = left[i];
				k++;
				i++;
			}
		}
	}

	public void sort(T[] a) {
		// TODO Auto-generated method stub
		// 默认情况下，对数组从头到尾排序
		int p = 0;
		int r = a.length - 1;
		sort(a, p, r);

	}

	private void sort(T[] a, int p, int r) {
		// TODO Auto-generated method stub
		if (p < r) {
			int q = (p + r) / 2;
			sort(a, p, q);
			sort(a, q + 1, r);
			merge(a, p, q, r);
		}

	}

	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void test(T[] a) {
		T[] b = (T[]) Array.newInstance(a.getClass().getComponentType(),
				a.length);
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		T min = null;
		boolean flag = true;
		for (int i = 0; i < b.length; i++) {
			if (flag) {
				min = b[i];
				flag = false;
			}
			if (b[i].compareTo(min) < 0) {
				min = b[i];
			}
		}

		System.out.println(min);

	}

	@SuppressWarnings("unchecked")
	public <T> void test2(T[] a) {
		T[] b = (T[]) new Object[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}

		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 1, 8, 2, 3, 5 };
//		new MergeSort().merge(a, 0, 1, 4);
		new MergeSort<Integer>().sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
