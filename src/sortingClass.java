import java.util.Random;

public class sortingClass {

	public static void main(String[] args) {
		mergeSort merge_sort = new mergeSort();
		quickSort quick_sort = new quickSort();
		int arraySize = 1000;
		Random rand = new Random();
		int[] array = new int[arraySize];

//		E Q U A L 		I N T E G E R S
		for (int i = 0; i < arraySize; i++) {
			array[i] = 1;
		}

//		R A N D O M		 I N T E G E R S
//		for (int i = 0; i < arraySize; i++) {
//			array[i] = rand.nextInt(1000);
//		}

//		I N C R E A S I N G 	I N T E G E R S
//		for (int i = 0; i < arraySize; i++) {
//			array[i] = i;
//		}

//		D E C R E A S I N G		 I N T E G E R S
//		int j = 0;
//		for (int i = arraySize; i > 0; i--) {
//			array[j] = i;
//			j++;
//		}

//		W İ T H O U T   S O R T
//		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
//		}

		long startTime = System.nanoTime();
		merge_sort.MergeSort(array, "2");
//		merge_sort.MergeSort(array, "3");
//		quick_sort.QuickSort(array, "FirstElement");
//		quick_sort.QuickSort(array, "RandomElement");
//		quick_sort.QuickSort(array, "MidOfFirstMidLast");
		long estimatedTime = System.nanoTime();
		System.out.println(estimatedTime - startTime);

//		S O R T E D
//		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
//		}

	}

}
