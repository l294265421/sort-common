package com.liyuncong.sort.sort_common;

public interface Sort {
	/**
	 * 这是需要变化的地方。将它独立处理，和不需要变化的部分分开。
	 * @param a
	 */
    public <T extends Comparable<T>> void sort(T[] a);
}
