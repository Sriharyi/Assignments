import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2,5,7,3,5,6,3,1,4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Choose the middle element as the pivot
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the subarrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2]; // Middle element as the pivot
        while (low <= high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }
            if(low <= high) {
                // Swap arr[low] and arr[high]
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;

                low++;
                high--;
            }
        }
        return low;
    }
}
