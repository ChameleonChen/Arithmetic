package cca.sort;

import java.util.ArrayList;

public abstract class InsertionSort<T> {
	
	public static final int A_GREATER_THAN_B = 1;
	
	public static final int A_LESS_THAN_B = 2;
	
	public static final int A_EQUALS_B = 3;
	
	/**
	 * 实现a b 两个元素的比较策略。
	 * ex:
	 *     int elemCompare(Integer a, Integer b) {
	 *         if (a > b) return InsertionSort.A_GREATER_THAN_B;
	 *         else if (a < b) return InsertionSort.A_LESS_THAN_B;
	 *         else return InsertionSort.A_EQUALS_B;
	 *     }
	 * @param a
	 * @param b
	 * @return a大于b，返回InsertionSort.A_GREATER_THAN_B；a小于b，返回InsertionSort.A_LESS_THAN_B
	 *         a等于b，返回InsertionSort.A_EQUALS_B.
	 */
	public abstract int elemCompare(T a, T b);
	

	public static final int NON_DECREASING_SORT = 1;    // 非递减
	
	public static final int NON_INCREASING_SORT = 2;    // 非递增
	
	/**
	 * 对elems进行排序，改变其在内存中的值。
	 * 实现算法如下：
	 * INSERTION-SORT(A)
	 *   for j = 2 to A.length
	 *   	key = A[j]
	 *   
	 *   	i = j - 1
	 *   	while i > 0 and A[i] > key
	 *   		A[i+1] = A[i]
	 *   		i = i - 1
	 *   	A[i+1] = key
	 * 
	 * @param elems
	 * @param sortType 排序的类型：非递减排序 InsertionSort.NON_DECREASING_SORT；
	 * 非递增排序InsertionSort.NON_INCREASING_SORT
	 */
	public void sort(ArrayList<T> elems, int sortType) {
		if (elems == null){
			throw new NullPointerException("the elems can not be null");
		}
		
		int expected;
		switch (sortType) {
		case NON_DECREASING_SORT:
			expected = A_GREATER_THAN_B;
			break;
		case NON_INCREASING_SORT:
			expected = A_LESS_THAN_B;
			break;
		default :
			throw new IllegalArgumentException("the sortType's value is illegal");
		}
		
		T temp;
		for (int j=1,i; j<elems.size(); j++) {
			temp = elems.get(j);
			
			i = j - 1;
			while (i>=0 && elemCompare(elems.get(i), temp) == expected) {
				elems.set(i+1, elems.get(i));
				i = i - 1;
			}
			elems.set(i+1, temp);
		}
	}
}
