package randomCounts;


import java.util.Arrays;

class SomeSort {

    //      Print Array to console
//-----------------------------------------------------------------------------------------------------
    void printArray(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            System.out.println(array[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    //      Selection Sort
//-----------------------------------------------------------------------------------------------------
    void selectionSort(int array[]) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    //      Bubble Sort
//-----------------------------------------------------------------------------------------------------
    void bubbleSort(int array[]) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
//                    swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }

            }
            if (swapped == false) {
                break;
            }
        }


    }

    //      Recursive Bubblesort
//-----------------------------------------------------------------------------------------------------
    void recursiveBubbleSort(int array[], int n) {


        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;

            }
        }
        recursiveBubbleSort(array, n - 1);
    }

    //      Insertion Sort
// -----------------------------------------------------------------------------------------------------
    void insertionSort(int array[]) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j = j - 1;

            }
            array[j + 1] = temp;
        }
    }


    //      Merge Sort
// -----------------------------------------------------------------------------------------------------
//     Merges two subarrays of arr[].
//     First subarray is arr[l..m]
//     Second subarray is arr[m+1..r]
    private void mergeSorting(int array[], int l, int m, int r) {
//         Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
//        Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

//        Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = array[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[m + 1 + j];
        }

//       Merge the temp arrays

//         Initial indexes of first and second subarrays
        int i = 0, j = 0;
//        Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;

        }
//        Copy remaining elements of L[] if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
//        Copy remaining elements of R[] if any
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }


    }

    void mergeSort(int array[], int l, int r) {
        if (l < r) {
//            Find the middle point
            int m = (l + r) / 2;
//            Sort first and second halves
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
//            Merge the sorted halves
            mergeSorting(array, l, m, r);
        }


    }

    //      Quick Sort
//-----------------------------------------------------------------------------------------------------
    private int quickSorting(int array[], int low, int high) {

        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pi = quickSorting(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);

        }
    }

    //      Count distincts in Array
//-----------------------------------------------------------------------------------------------------
    int countDistinct(int array[]) {
        int n = array.length;
        int res = 1;

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    break;
                }
            }
            if (i == j) {
                res++;
            }
        }

        return res;
    }

    //      HeapSort
//-----------------------------------------------------------------------------------------------------
    private void heap(int array[], int n, int i) {
        int largest = i;    //largest as a root
        int r = 2 * i + 1;      //left
        int l = 2 * i + 2;      //right

        // If left child is larger than root
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }
        // If right child is larger than largest so far
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }
        // If largest is not root
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heap(array, n, largest);
        }

    }

    void heapSort(int array[]) {
        int n = array.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(array, n, i);
        }
        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heap(array, i, 0);
        }

    }

    //      Counting Sort
//-----------------------------------------------------------------------------------------------------
    void countingSort(char array[]) {
        int n = array.length;
        // The output character array that will have sorted arr
        char output[] = new char[n];

        // Create a count array to store count of inidividual characters and initialize count array as 0
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i) {
            count[i] = 0;
        }

        // store count of each character
        for (int i = 0; i < n; ++i) {
            ++count[array[i]];
        }

        // Change count[i] so that count[i] now contains actual position of this character in output array
        for (int i = 1; i <= 255; ++i) {
            count[i] += count[i - 1];
        }
        // Build the output character array to make it stable we are operating in reverse order
        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            --count[array[i]];
        }
        // Copy the output array to arr, so that arr now contains sorted characters
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }

    }

    void countingSort(int array[]) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }

    }

    //      Radix Sort
//-----------------------------------------------------------------------------------------------------
    private int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private void countingSort(int array[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }
        // Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to curent digit
        for (i = 0; i < n; i++) {
            array[i] = output[i];
        }

    }

    void radixSort(int array[]) {
        int n = array.length;
        int m = getMax(array, n);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countingSort(array, n, exp);
        }
    }

    //      Bucket Sort
// -----------------------------------------------------------------------------------------------------
    void bucketSort(int array[]) {
        int bucket[] = new int[Arrays.stream(array).max().getAsInt() + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }
        int out = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                array[out++] = i;
            }
        }

    }

    //      Shell Sort
//-----------------------------------------------------------------------------------------------------
    int shellSort(int array[]) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return 0;
    }

    //      Tim Sort
//-----------------------------------------------------------------------------------------------------
    private final int RUN = 32;

    private void insertionSort(int array[], int left, int right) {

        for (int i = left + 1; i <= right; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= left && array[j] > temp) {
                array[j + 1] = array[j];
                j = j - 1;

            }
            array[j + 1] = temp;
        }
    }

    void timSort(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; i += RUN) {
            insertionSort(array, i, Math.min((i + 31), (n - 1)));
        }
        for (int size = RUN; size < n; size = (2 * size)) {
            for (int left = 0; left < n; left += (2 * size)) {
                int mid = left + size - 1;
                int right = Math.min((left + (2 * size) - 1), (n - 1));
                if (mid >= right) {
                    mid = ((right - left) / 2) + left;
                }

                mergeSorting(array, left, mid, right);
            }


        }

    }

    //      Comb Sort
//-----------------------------------------------------------------------------------------------------
    int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }

    void combSort(int array[]) {
        int n = array.length;
        int gap = n;
        boolean swapped = true;
        while (gap != 1 && swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;

                }
            }
        }
    }

    //      Pigeon Sort
//-----------------------------------------------------------------------------------------------------
    void pigeonholeSort(int array[]) {
        int n = array.length;
        int min = array[0];
        int max = array[0];
        int range, i, j, index;

        for (int anArray : array) {
            if (anArray > max) {
                max = anArray;
            }
            if (anArray < min) {
                min = anArray;
            }
        }

        range = max - min + 1;

        int pHole[] = new int[range];
        Arrays.fill(pHole, 0);

        for (i = 0; i < n; i++) {
            pHole[array[i] - min]++;
        }
        index = 0;
        for (j = 0; j < range; j++) {
            while (pHole[j]-- > 0) {
                array[index++] = j + min;
            }
        }
    }

    //      Cycle Sort
//-----------------------------------------------------------------------------------------------------
    void cycleSort(int array[]) {
        int n = array.length;
        int writes = 0;
        for (int cycleStart = 0; cycleStart <= n - 2; cycleStart++) {
            int item = array[cycleStart];

            int pos = cycleStart;
            for (int i = cycleStart + 1; i < n; i++) {
                if (array[i] < item) {
                    pos++;
                }
            }
            if (pos == cycleStart) {
                continue;
            }
            while (item == array[pos]) {
                pos += 1;
            }
            if (pos != cycleStart) {
                int temp = item;
                item = array[pos];
                array[pos] = temp;
                writes++;
            }
            while (pos != cycleStart) {
                pos = cycleStart;

                for (int i = cycleStart + 1; i < n; i++) {
                    if (array[i] < item) {
                        pos += 1;
                    }
                }
                while (item == array[pos]) {
                    pos += 1;
                }
                if (item != array[pos]) {
                    int temp = item;
                    item = array[pos];
                    array[pos] = temp;
                    writes++;
                }
            }
        }
    }

    //      Coctail Sort
//-----------------------------------------------------------------------------------------------------
    void coctailSort(int array[]) {
        boolean swapped = true;
        int start = 0;
        int end = array.length;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            end = end - 1;

            for (int i = end - 1; i >= start; i--) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }

    }

    //      Bitonic Sort
//-----------------------------------------------------------------------------------------------------
    private void compAndSwap(int array[], int i, int j, int dir) {
        if ((array[i] > array[j] && dir == 1) || (array[i] < array[j] && dir == 0)) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    private void bitonicMerge(int array[],int low,int count, int dir){
        if(count>1){
            int k = count/2;
            for(int i = low;i<low+k;i++){
                compAndSwap(array,i,i+k,dir);
            }
            bitonicMerge(array,low,k,dir);
            bitonicMerge(array,low+k,k,dir);
        }
    }

    private void bitonicSorting(int array[],int low, int count, int dir){
        if(count>1){
            int k = count/2;
            bitonicSorting(array,low,k,1);
            bitonicSorting(array,low+k,k,0);
            bitonicMerge(array,low,count,dir);
        }
    }
    void bitonicSort(int array[]){
        int n = array.length;
        int up = 1;
        bitonicSorting(array,0,n,up);
    }
}

