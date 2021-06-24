package sort;

/**
 * @Author : Wu.D.J
 * @Create : 2020.12.31
 */
public class SortWay {

    /**
     * @Way: 选择排序 O(n^2)
     */
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * @Way: 插入排序 O(n^2)
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    /**
     * @Way: 冒泡排序 O(n^2)
     */
    public void bobbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * @Way: 快速排序 O(nlogn)
     */
    public void quickSort(int[] arr, int start, int end) {
        if (end <= start) return;
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int cursor = start;
        int pivot = end;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[cursor];
                arr[cursor] = arr[i];
                arr[i] = temp;
                cursor++;
            }
        }

        int temp = arr[pivot];
        arr[pivot] = arr[cursor];
        arr[cursor] = temp;

        return cursor;
    }

    /**
     * @Way: 归并排序 O(nlogn)
     */
    public void mergeSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        if (temp.length >= 0) System.arraycopy(temp, 0, arr, left, temp.length);
    }

    /**
     * @Way: 堆排序 O(nlogn)
     */
    public void heapSort(int[] arr) {
        if (arr.length == 0) return;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2, largest = i;
        if (left < length && arr[left] > arr[largest]) largest = left;
        if (right < length && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, length, largest);
        }
    }

}
