import java.util.Arrays;
import java.util.*;

/**
 * Class containing all the sorting algorithms.
 * 
 * You may add any number instance variables and instance methods 
 * to your Sorting Algorithm classes. 
 * You may also override the no-argument constructor, but please
 * only use the no-argument constructor for each of the Sorting 
 * Algorithms, as that is what will be used for testing.
 * 
 */
public class MySortingAlgorithms {

	// public static void main(String[] args) {
	// 	// MySortingAlgorithms thai = new MySortingAlgorithms();
	// 	int[] array = {5,2,3,4,1,8,9,7,6,0};
	// 	// InsertionSort thai = new InsertionSort();
	// 	// SelectionSort thai = new SelectionSort();
	// 	// MergeSort thai = new MergeSort();
	// 	RadixSort thai = new RadixSort();
	// 	int[] result  = thai.sort(array,5);
	// 	System.out.print("result = ");
	// 	for(int a: result) {
	// 		System.out.print(a + " ");
	// 	}
	// 	System.out.println();
	// }


	/**
	 * Java's Sorting Algorithm.
	 * DO NOT USE THIS in your implementation.
	 * DO NOT USE Arrays.SORT in your implementation.
	 * 
	 * This algorithm may be helpful for testing.
	 */
	public static class JavaSort implements Sorting {
		@Override
		public int[] sort(int[] array, int k) {
			Arrays.sort(array);
			int[] truncated = new int[k];
			System.arraycopy(array, 0, truncated, 0, k);
			return truncated;
		}
	}

	public static class InsertionSort implements Sorting {
		@Override
		public int[] sort(int[] ary, int k) {
			// TODO: to be implemented
			for(int i = 1; i < ary.length; i++) {
				int item = ary[i];
				int j = i;
				while(j > 0 && ary[j-1] > item) {
					ary[j] = ary[j - 1];
					j--;
				}
				ary[j] = item;
			}
			int[] arr = new int[k];
			System.arraycopy(ary, 0, arr, 0, k);
			return arr;
		}

		@Override
		public String toString() {
			return "Insertion Sort";
		}
	}

	/**
	 * Selection Sort for small K should be more efficient
	 * than for larger K
	 */
	public static class SelectionSort implements Sorting {
		@Override
		public int[] sort(int[] ary, int k) {
			for(int i = 0; i < k; i++) {
				int min = i;
				for(int j = i + 1; j < ary.length; j++) {
					if(ary[j] < ary[min]) {
						min = j;
					}
				}
				
				if(min != i) {
					int temp = ary[i];
					ary[i] = ary[min];
					ary[min] = temp;
				}
			}
			int[] arr = new int[k];
			System.arraycopy(ary, 0, arr, 0, k);
			return arr;
		}

		@Override
		public String toString() {
			return "Selection Sort";
		}
	}

	public static class MergeSort implements Sorting {
		@Override
		public int[] sort(int[] ary, int k) {
	 		int[] arr = new int[k];	
	 		ary = helper(ary);
			System.arraycopy(ary, 0, arr, 0, k);
			return arr;
 		}


 		public int[] helper(int[] ary) {
 			if (ary.length <= 1) {
 				return ary;
 			}
 			
 			int[] first_half = new int[ary.length / 2];
 			int[] second_half = new int[ary.length - first_half.length];
 			System.arraycopy(ary, 0, first_half, 0, first_half.length);
 			System.arraycopy(ary, first_half.length, second_half, 0, second_half.length);
 			
 			helper(first_half);
 			helper(second_half);
 			
 			merge(first_half, second_half, ary);
 			return ary;
 		}

		private static void merge(int[] first_half, int[] second_half, int [] result) {
	        int first = 0;
	        int second = 0;
	        
	        int j = 0;
	        while (first < first_half.length && second < second_half.length) {
	            if (first_half[first] < second_half[second]) {
	                result[j] = first_half[first];
	                first++;
	                } else {
	                result[j] = second_half[second];
	                second++;
	            }
	            j++;
	        }

	        System.arraycopy(first_half, first, result, j, first_half.length - first);
	        System.arraycopy(second_half, second, result, j, second_half.length - second);
   		}

		@Override
		public String toString() {
			return "Merge Sort";
		}
	}

	/**
	 * Does not need to be stable.
	 * For better performance, sort in-place.
	 */
	public static class RadixSort implements Sorting {
		@Override
		public int[] sort(int[] array, int k) {
			int size = 10;
			List<Integer>[] buckets = new ArrayList[size];
			for (int i = 0; i < buckets.length; i++) {
				buckets[i] = new ArrayList<Integer>();
			}

			int temp = -1;
			int place = 1;
			int z = 0;
			boolean max_length = false;
			while (!max_length) {
				max_length = true;
				for (int a : array) {
					temp = a / place;
					buckets[temp % size].add(a);
					if (max_length && temp > 0) {
						max_length = false;
					}
				}
				z = 0;
				for (int i = 0; i < size; i++) {
					for (Integer a : buckets[i]) {
						array[z++] = a;
					}
					buckets[i].clear();
				}
				place *= size;
			}	

			int[] arr = new int[k];
			System.arraycopy(array, 0, arr, 0, k);
			return arr;
		}
		
		@Override
		public String toString() {
			return "Radix Sort";
		}
	}

}


