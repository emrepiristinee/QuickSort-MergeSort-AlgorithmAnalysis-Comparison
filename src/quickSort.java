import java.util.Random;

public class quickSort {

	// Q U I C K . . S O R T
	void QuickSort(int[] arrayToSort, String pivotType) {
		if (pivotType.equals("FirstElement")) {
			quickSortFirstElement(arrayToSort, 0, arrayToSort.length - 1);
		} else if (pivotType.equals("RandomElement")) {
			quickSortRandomElement(arrayToSort, 0, arrayToSort.length - 1);
		} else if (pivotType.equals("MidOfFirstMidLast")) {
			quickSortMidOfFirstMidLast(arrayToSort, 0, arrayToSort.length - 1);
		}
	}

	// iki verinin yerini birbiriyle değiştirir
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// İlk elemanı pivot olarak alır, pivottan küçükler sola, pivottan büyükler
	// sağına yerleştirilir
	int partitionFirstElement(int arr[], int low, int high) {
		int pivot = arr[low];
		int k = high;
		for (int i = high; i > low; i--) {
			if (arr[i] > pivot)
				swap(arr, i, k--);
		}
		swap(arr, low, k);
		return k;
	}

	// First Element'in ana methodu
	void quickSortFirstElement(int arr[], int low, int high) {
		if (low < high && high > 1) { // eğer low hala high'dan küçükse
			int idx = partitionFirstElement(arr, low, high); // sıralanmış konumunda olan pivot'un indeksini idx'e koyar

			quickSortFirstElement(arr, low, idx - 1);
			quickSortFirstElement(arr, idx + 1, high);
		}
	}

	// R A N D O M . . E L E M E N T
	// rastgele sayı üretir ve bunu high pivot yapar
	static void random(int arr[], int low, int high) {
		Random rand = new Random();
		int pivot = rand.nextInt(high - low) + low;
		int temp1 = arr[pivot];
		arr[pivot] = arr[high];
		arr[high] = temp1;
	}

	// Son elemanı pivot olarak alır, pivottan küçükleri sola, pivottan büyükleri
	// sağına yerleştirilir
	static int partitionRandomElement(int arr[], int low, int high) {
		random(arr, low, high); // pivotun rastgele seçildiği method
		int pivot = arr[high];

		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;

				// swap işlemi yapıyor
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap işlemi yapıyor
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	// Random Element'in ana methodu
	static void quickSortRandomElement(int arr[], int low, int high) {
		if (low < high) {

			// Son elemanı pivot olarak alır, pivottan küçükleri sola, pivottan büyükleri
			// sağına yerleştirilir
			int pi = partitionRandomElement(arr, low, high);

			quickSortRandomElement(arr, low, pi - 1);
			quickSortRandomElement(arr, pi + 1, high);
		}
	}

	// M I D . . E L E M E N T

	// First, Mid, Last arasından ortancayı bulan method
	static int findMid(int arr[], int low, int high) {
		int pivot = 0;
		int midElement = arr.length / 2;

		if ((arr[low] >= arr[high] && arr[low] <= arr[midElement])
				|| (arr[low] <= arr[high] && arr[low] >= arr[midElement])) {
			pivot = low;
		} else if ((arr[high] >= arr[low] && arr[high] <= arr[midElement])
				|| (arr[high] <= arr[low] && arr[high] >= arr[midElement])) {
			pivot = high;

		} else if ((arr[midElement] >= arr[low] && arr[midElement] <= arr[high])
				|| (arr[midElement] <= arr[low] && arr[midElement] >= arr[high])) {
			pivot = midElement;
		}
		return pivot;
	}

	// Mid Of First Mid Last'ın ana methodu
	static void quickSortMidOfFirstMidLast(int arr[], int low, int high) {
		if (low < high) {
			int pi = 0;
			int mid = arr.length / 2;
			int whickMedian = findMid(arr, low, high);

			if (whickMedian == low) { // hangisi ortancaysa ona göre if'e giriyor ve pivotu belirliyor
				pi = partitionMidOfFirst(arr, low, high);
			} else if (whickMedian == mid) {
				pi = partitionMidOfMid(arr, low, high);
			} else if (whickMedian == high) {
				pi = partitionMidOfLast(arr, low, high);
			}

			quickSortMidOfFirstMidLast(arr, low, pi - 1);
			quickSortMidOfFirstMidLast(arr, pi + 1, high);
		}
	}

	// Son elemanı pivot olarak alır, pivottan küçükleri sola, pivottan büyükleri
	// sağına yerleştirilir
	static int partitionMidOfLast(int arr[], int low, int high) {
		int pivot = arr[high];

		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;

				// swap işlemi
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap işlemi
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	// Ortadaki elemanı pivot olarak alır, pivottan küçükleri sola, pivottan
	// büyükleri sağına yerleştirilir
	static int partitionMidOfMid(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	// İlk elemanı pivot olarak alır, pivottan küçükleri sola, pivottan büyükleri
	// sağına yerleştirilir
	static int partitionMidOfFirst(int arr[], int low, int high) {
		int pivot = arr[low];
		int k = high;
		for (int i = high; i > low; i--) {
			if (arr[i] > pivot)
				swap(arr, i, k--);
		}
		swap(arr, low, k);
		return k;
	}
}
