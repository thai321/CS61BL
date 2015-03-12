import java.util.*;
import java.lang.Math;
/**
 * Determines which sorting algorithm to use based on 
 * the contents of the array, and K.
 */
public class MyAlgorithmSelector implements AlgorithmSelector {
	
	@Override
	public Sorting chooseSortingAlgorithm(int[] ary, int k) {
		// TODO Auto-generated method stub
		
		if(k == 1) {  // for all R, L    6
			// System.out.println("SelectionSort k = 1");
			return new MySortingAlgorithms.SelectionSort();
		}

		int l = 0;
		int r = Integer.MIN_VALUE;
		for(int i = 0; i < ary.length-1; i ++) {
			if(ary[i] > ary[i+1]) {
				l++;
			}
			if(ary[i] > r) {
				r = ary[i];
			}
		}
		r = r +1;

		if(l >= 25) {
			if(k <= 32 && r > 2) {   // 2  l >= 25, k == 32, r = 1024, 2^30
				// System.out.println("SelectionSort");
				return new MySortingAlgorithms.SelectionSort();
			}
			else if(k > 32 && r <= 1024){  // 3  l >= 25, k > 32, all
				// System.out.println("RadixSort");
				return new MySortingAlgorithms.RadixSort();
			}
			else {
				// System.out.println("MergeSort");
				return new MySortingAlgorithms.MergeSort();
			}

		}
		// System.out.println("InsertionSort");
		return new MySortingAlgorithms.InsertionSort();
	
	}

	public static void main(String[] args) {
		// System.out.println("Hello");
		// Random random = new Random();
		// MyAlgorithmSelector thai = new MyAlgorithmSelector();
		// // int[] array = {5,2,3,11, 4,1,8,9,7,6,0};
		// int x = (int) Math.pow(2,20);
		// int [] array = new int[x];
		// for(int i = 0; i < array.length; i++) {
		// 	// array[i] = random.nextInt(x);
		// 	array[i] = i+ 1;

		// }
		
		// array[array.length - 1] = 0;
		// int k = array.length;
		// Sorting thai2 = thai.chooseSortingAlgorithm(array, k);
		// int[] result = thai2.sort(array,k);
		// System.out.print("result = ");
		// for(int a: result) {
		// 	System.out.print(a + " ");
		// }
		// System.out.println();
	}
}