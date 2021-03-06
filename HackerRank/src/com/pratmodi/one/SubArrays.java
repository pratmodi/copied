package com.pratmodi.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SubArrays {

	public static void main(String[] args) {
		int[] array = { 1, -2, 4, -5, 1 };
		int[] subArray = new int[array.length];
//		numberOfNegativeSums(array);
//		findArrayIndex(subArray, array);
//		numberOfNegativeSum(array);
//		System.out.println(number(array));
		System.out.println(ViveksMethod(array));
	}

	public static int numberOfNegativeSums(int[] array) {
		try {
			int sum = Integer.MIN_VALUE;
			List<Integer> list = new ArrayList<Integer>(array.length);
			int[] subArray = new int[array.length];
			int subArrayElements = 0;
			for (int i = 0; i < array.length; i++) {
//			subArrayElements+=array[i];
//			subArray[i]=subArrayElements;
//			
				list.add(i, array[i]);
			}
			int sum2 = 0;
			for (int j = 0; j < list.size(); j++) {
				if (j + 1 < list.size()) {
					sum2 = list.get(j) + list.get(j + 1);
				}
				if (sum2 < 0) {
					return sum2;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public static int findArrayIndex(int[] subArray, int[] parentArray) {
		if (subArray.length == 0) {
			return -1;
		}
		int sL = subArray.length;
		int l = parentArray.length - subArray.length;
		int k = 0;
		for (int i = 0; i < l; i++) {
			if (parentArray[i] == subArray[k]) {
				for (int j = 0; j < subArray.length; j++) {
					if (parentArray[i + j] == subArray[j]) {
						sL--;
						if (sL == 0) {
							return i;
						}

					}

				}
			}

		}
		return -1;
	}

	public static <T> int[] subArray(int[] array, int beg, int end) {
		return Arrays.copyOfRange(array, beg, end + 1);
	}

	public static void numberOfNegativeSum(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int beg = 0; beg < array.length; beg++) {
			int end = 0;
			int[] array2;
			list.add(beg, array[beg]);
			for (end = beg + 1; end < array.length; end++) {
				Object[] array3 = new Object[list.size()];
				array3 = list.toArray();
				// array2 = subArray(array, beg, end);
			}

		}
		Iterator i = list.listIterator();
		while (i.hasNext()) {
			System.out.println("Subarrays in list: " + i.next());
		}

	}

	public static int number(int[] array) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {

			int[] array2 = new int[array.length];
//			for(counter=0;counter<array.length;counter++) {
//			  if(counter+1<array.length&&i+1<array.length) {
//				array2[counter]=array[i];
//				array2[counter+1]=array[i+1];
			counter = recursiveCall(array, array2, i);
//			  }
//			}
		}
		return counter;
	}

	public static int recursiveCall(int[] array, int[] array2, int i) {
		int subArrayCounter = 0;
		for (int j = 0; j < i; j++) {
			if (j + 1 < array.length && i + 1 < array.length) {
				array2[j] = array[i];
				array2[j + 1] = array[i + 1];
			}
		}
		subArrayCounter++;
		return subArrayCounter;
	}

	public static int ViveksMethod(int[] array) {
		List<Integer> negativeIndexes = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++) {
			if(array[i]<0) {
				negativeIndexes.add(i);
			}
		}
		int counter=0;
//		for(int i=0;i<negativeIndexes.size();i++) {
//			for(int j=0;j<array.length;j++) {
//				if(negativeIndexes.get(i)!=j && !(array[i]<0 && array[j]<0)) {
//					int sum = array[i]+array[j];
//					if(sum<0) {
//						counter++;
//					}
//				}
//			}
//		}
		int tempIndex=0;
		for(int i=0;i<array.length;i++) {
			if(array.length>i && array[i]+array[i+1]<0) {
				counter++;
				i=i+1;
			}
//			for(int j=1;j<=i;j++) {
//				int sum = array[i]+array[j];
//				if(sum<0) {
//					counter++;
//				}
//			}
		}
		
		for(int i=0;i<array.length;i++) {
			
		}
		
		System.out.println("counter: "+ (counter +negativeIndexes.size()));
		return 0;
	}
	
}
