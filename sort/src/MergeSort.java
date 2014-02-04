/*
 *  complexity:  worst case - n log(n)
 */
public class MergeSort {
	private int[] numbers;
	private int[] helper;

	private int number;

	private int totalcopies = 0;
	
	public void resetStats() {
		totalcopies = 0;
	}
	public int getSwapCount() {
		return totalcopies;
	}
	
	public void sort(int[] values) {
		numbers = values;
		number = values.length;
		helper = new int[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {
		/*
		 * If low is >= high the the list is fully sorted
		 */
		if (low < high) {
			int middle = (low + high) / 2; 	// Get the index of the middle element
			mergesort(low, middle); 		// Sort the left side of the array
			mergesort(middle + 1, high); 	// Sort the right side of the array
			merge(low, middle, high); 		// Combine them both
		}
		
	}

	private void merge(int low, int middle, int high) {
		/*
		 *  Copy both parts into the helper array
		 */
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
			++totalcopies;
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		/*
		 * Copy the smallest values from either the left or the right side back
		 * to the original array
		 */
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
			++totalcopies;
		}
		/*
		 * Copy the rest of the left side of the array into the target array
		 */
		for (; i<= middle; k++, i++) {
			numbers[k] = helper[i];
			++totalcopies;
		}

	}

}