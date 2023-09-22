import java.util.*;

public class SortingEg{

    static void quickSort(int array[])
    {
        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if(low<high)
        {
            int pivotIndex = partition(array,low,high);
            quickSort(array, low, pivotIndex-1);
            quickSort(array, pivotIndex, high);
        }
    }

    // private static int partition(int[] arr, int low, int high) {
    //     int pivot = arr[high]; // Choose the pivot as the rightmost element
    //     int left = low;       // Initialize left pointer
    //     int right = high - 1; // Initialize right pointer
    
    //     while (true) {
    //         while (left <= right && arr[left] < pivot) {
    //             left++;
    //         }
    
    //         while (left <= right && arr[right] > pivot) {
    //             right--;
    //         }
    
    //         if (left < right) {
    //             // Swap arr[left] and arr[right] to correct the order
    //             int temp = arr[left];
    //             arr[left] = arr[right];
    //             arr[right] = temp;
    //             left++;
    //             right--;
    //         } else {
    //             // Swap the pivot element with arr[left] to place the pivot in its correct position
    //             int temp = arr[left];
    //             arr[left] = arr[high];
    //             arr[high] = temp;
    //             return left;
    //         }
    //     }
    // }
    
    // private static int partition(int[] array, int low, int high) {
    //     int pivot = array[high];//choose rightmost element as pivot
    //     int left = low;
    //     int right = high-1;
    //     while(left<=right)
    //     {
    //         while(left<=right && array[left]<pivot){
    //             left++;
    //         }
    //         while(left<=right && array[right]>pivot )
    //         {
    //             right--;
    //         }
    //         if(left<right)
    //         {
    //             int temp = array[left];
    //             array[left] = array[right];
    //             array[right] = temp;
    //         }
    //     }
    //     int temp = array[left];
    //     array[left] = array[high];
    //     array[high] = temp;
    //     return left;
    // }

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
    
    static void bubbleSort(int array[])
    {
        int n= array.length;
        Integer iteration = 0;
        for(int j=0;j<n;j++)
        {
            boolean notswapped =true;
            iteration++;
             for(int i=0;i<n-1-j;i++)
            {
                if(array[i]>array[i+1])
                {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    notswapped = false;
                }
                iteration++;
            }
            // if(notswapped)
            //     break;

        }
        System.out.println("\nbubble iteration:"+iteration);
    }
    public static void biDirectionSort(int array[])
    {
        int start =0;
        int end = array.length;
        boolean notswapped = true;
        Integer iteration = 0;
        while(notswapped)
        {
            iteration++;
            for(int i=start;i<end-1;i++)
            {
                if(array[i]>array[i+1])
                {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    notswapped = false;
                }
                iteration++;
            }

            if(notswapped)
                break;
            
            notswapped = true;

            end = end-1;

            for(int i=end-1;i>=start;i--)
            {
                if(array[i]>array[i+1])
                {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    notswapped = false;
                }   
                iteration++;
            }
            if(notswapped)
                break;
            notswapped = true;
            start = start+1;
        }
        System.out.println("\ncocktail iteration:"+iteration);
    }
    public static void selectionSort(int array[])
    {
        int n = array.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(array[i]>array[j])
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        // int n = sc.nextInt();
        // int array1[] = new int[n];
        int array2[] = new int[]{2,5,7,3,5,6,3,1,4};
    //     System.out.println("enter the array element");
    //     for(int i=0;i<n;i++)
    //     {
    //         array1[i] = sc.nextInt();
    //     }
    //    bubbleSort(array1);
    //    System.out.println("array1 element in sorted order");
    //    for(int i:array1)
    //    {
    //        System.out.print(i+" ");
    //    }
       quickSort(array2);
        System.out.println("\narray2 element in sorted order");
       for(int i:array2)
       {
           System.out.print(i+" ");
       }
       
    }
}