import java.util.*;

public class MergeSort{
    
    public static void mergeSort(int arr[])
     {
        mergeSort(arr, 0, arr.length-1);
     }
    private static void mergeSort(int[] arr, int low, int high) {
        if(low < high){
            int mid = ( low + high ) / 2; //or low + ((high-low)/2)
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr,low,mid,high);
        }
    }

    private static void merge(int[] arr, int low,  int mid, int high) {
        int n1 = mid - low +1;
        int n2 = high - mid;
        
        int leftSubarr[]= new int[n1];
        int rightSubarr[] = new int[n2];

        for(int i=0;i<n1;i++)
        {
            leftSubarr[i] = arr[low + i];
        }

        for(int i=0;i<n2;i++)
        {
            rightSubarr[i] = arr[mid + 1 + i];
        }

        int i=0;
        int j=0;
        int k=low;
        while(i<n1 && j<n2)
        {
            if(leftSubarr[i]<=rightSubarr[j])
            {
                arr[k++] = leftSubarr[i++];
            }else
            {
                arr[k++] = rightSubarr[j++];
            }
        }
        while(i<n1) {
            arr[k++] = leftSubarr[i++];
        }
        while(j<n2){
            arr[k++] = rightSubarr[j++];
        }
        
    }
    
    
    public static void main(String[] args) {
        int arr[] = new int[]{56,345,23,26,277,34,33,78,26,734,98,33,13};
        mergeSort(arr);
        // arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
        
            // public static int[] mergeSort(int arr[])
            // {
            //     if(arr.length==1)
            //         return arr;
            //     int mid = arr.length/2;
            //     int left[] = mergeSort(Arrays.copyOfRange(arr, 0, mid));
            //     int right[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
            //     return merge(left,right);
            // }
        // private static int[] merge(int[] leftSubarr, int[] rightSubarr) {
        //     int newArray[] = new int[leftSubarr.length + rightSubarr.length];
    
        //     int i=0,j=0,k=0;
    
        //      while(i<leftSubarr.length && j<rightSubarr.length)
        //     {
        //         if(leftSubarr[i]<=rightSubarr[j])
        //         {
            //             newArray[k++] = leftSubarr[i++];
            //         }else
            //         {
        //             newArray[k++] = rightSubarr[j++];
        //         }
        //     }
        //      while(i<leftSubarr.length) {
        //         newArray[k++] = leftSubarr[i++];
        //     }
        //     while(j<rightSubarr.length){
        //         newArray[k++] = rightSubarr[j++];
        //     }
        //     return newArray;
        // }