package cca.sort;

import java.util.ArrayList;

public class TestInsertSort {

	public static void main(String[] args) {
		InsertionSort<Integer> insertSort = new InsertionSort<Integer>() {
			
			@Override
			public int elemCompare(Integer a, Integer b) {
				if (a > b) {
					return InsertionSort.A_GREATER_THAN_B;
				}
				else if (a < b) {
					return InsertionSort.A_LESS_THAN_B;
				}
				else {
					return InsertionSort.A_EQUALS_B;
				}
			}
		};
		
		ArrayList<Integer> elems = buildArray();
		insertSort.sort(elems, InsertionSort.NON_DECREASING_SORT);
		
		for (int i=0; i<elems.size(); i++) {
			System.out.println(elems.get(i));
		}
	}
	
	private static ArrayList<Integer> buildArray() {
		ArrayList<Integer> elems = new ArrayList<Integer>();
		
		elems.add(0, 123);
		elems.add(1, 87);
		elems.add(2, 45);
		elems.add(3, 78);
		elems.add(4, 23);
		elems.add(5, 90);
		elems.add(6, 56);
		
		return elems;
	}
}
