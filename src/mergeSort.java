
public class mergeSort {

	// Main'den çağırılan numberOfPartitions'a göre neyi çalıştıracağını seçer
	void MergeSort(int[] arrayToSort, String numberOfPartitions) {
		if (numberOfPartitions.equals("2")) {
			merge_sort2(arrayToSort, 0, arrayToSort.length - 1);
		} else if (numberOfPartitions.equals("3")) {
			merge_sort3(arrayToSort);
		}
	}

	// 2 - W A Y . . M E R G E S O R T
	void merge_sort2(int arr[], int l, int r) {
		if (l < r) {
			// ortanca elemanı bulur
			int m = (l + r) / 2;

			// birinci ve ikinci yarıyı sıralar
			merge_sort2(arr, l, m);
			merge_sort2(arr, m + 1, r);

			// birinci ve ikinci yarıyı birleştirir
			merge2(arr, l, m, r);
		}
	}

	// 2'ye bölünen dizinin verilerini sıralayarak birleştirir
	void merge2(int arr[], int l, int m, int r) {
		int n1 = m - l + 1; // ortancadan low'u çıkartarak birinci yarının size'ını hesaplar
		int n2 = r - m; // high'dan ortancıyı çıkartarak ikinci yarının size'nı hesaplar

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i]; // birinci yarıyı L dizisine atıyor
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j]; // ikinci yarıyı R dizisine atıyor

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) { // birinci ve ikinci yarının elemanlarını karşılaştırıp diziye yerleştiriyor
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// 3 - W A Y . . M E R G E S O R T
	public static void merge_sort3(int[] gArray) {
		if (gArray == null) // dizisi boşsa, null değerini döndürür
			return;

		int[] fArray = new int[gArray.length]; // verilen dizinin kopyasını oluşturur
		for (int i = 0; i < fArray.length; i++)
			fArray[i] = gArray[i];

		mergeThree(fArray, 0, gArray.length, gArray); // sort methodu

		// yinelenen dizinin öğelerini verilen diziye geri kopyala
		for (int i = 0; i < fArray.length; i++)
			gArray[i] = fArray[i];
	}

	public static void mergeThree(int[] gArray, int low, int high, int[] destArray) {
		// If array size is 1 then do nothing
		if (high - low < 2)
			return;

		// diziyi 3 parçaya ayırır
		int mid1 = low + ((high - low) / 3);
		int mid2 = low + 2 * ((high - low) / 3) + 1;

		// 3 diziyi recursive olarak sıralar
		mergeThree(destArray, low, mid1, gArray);
		mergeThree(destArray, mid1, mid2, gArray);
		mergeThree(destArray, mid2, high, gArray);

		merge3(destArray, low, mid1, mid2, high, gArray);
	}

	// 3'e bölünen dizinin verilerini sıralayarak birleştirir
	public static void merge3(int[] gArray, int low, int mid1, int mid2, int high, int[] destArray) {
		int i = low, j = mid1, k = mid2, l = low;

		// 3 aralığın arasından en küçüğü seçer
		while ((i < mid1) && (j < mid2) && (k < high)) {
			if (gArray[i] < gArray[j]) {
				if (gArray[i] < gArray[k])
					destArray[l++] = gArray[i++];
				else
					destArray[l++] = gArray[k++];
			} else {
				if (gArray[j] < gArray[k])
					destArray[l++] = gArray[j++];
				else
					destArray[l++] = gArray[k++];
			}
		}

		// birinci ve ikinci aralıkta kalan değerlerin sıralanması
		while ((i < mid1) && (j < mid2)) {
			if (gArray[i] < gArray[j])
				destArray[l++] = gArray[i++];
			else
				destArray[l++] = gArray[j++];
		}

		// ikinci ve üçüncü aralıkta kalan değerlerin sıralanması
		while ((j < mid2) && (k < high)) {
			if (gArray[j] < gArray[k])
				destArray[l++] = gArray[j++];

			else
				destArray[l++] = gArray[k++];
		}

		// birinci ve üçüncü aralıkta kalan değerlerin sıralanması
		while ((i < mid1) && (k < high)) {
			if (gArray[i] < gArray[k])
				destArray[l++] = gArray[i++];
			else
				destArray[l++] = gArray[k++];
		}

		// ilk aralıkta kalan değerleri destination array'a koyuyor
		while (i < mid1)
			destArray[l++] = gArray[i++];

		// ikinci aralıkta kalan değerleri destination array'a koyuyor
		while (j < mid2)
			destArray[l++] = gArray[j++];

		// üçüncü aralıkta kalan değerleri destination array'a koyuyor
		while (k < high)
			destArray[l++] = gArray[k++];
	}
}
