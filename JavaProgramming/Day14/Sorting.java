import java.util.ArrayList;
import java.util.Scanner;

public class Sorting {

    void mergeSort(ArrayList<Integer> list){
        mergeSort(list,0,list.size()-1);
    }

    private void mergeSort(ArrayList<Integer> list, int low, int high) {
        if(low<=high)
        {
            int mid = low + (high - low)/2;
            mergeSort(list, low, mid);
            mergeSort(list, mid+1, high);
            merge(list,low,mid,high);
        }
    }

    private void merge(ArrayList<Integer> list, int low, int mid, int high) {
        

    
    }

    void selectionSort(ArrayList<Integer> list)
    {
        int iteration = 0;
        for(int i = 0;i < list.size();i++){
            int min_idx = i;
            iteration++;
            for(int j = i+1;j < list.size();j++) {
                if(list.get(j)<list.get(min_idx)){
                    min_idx = j;
                }
                iteration++;
            }
            if(min_idx!=i){
                int temp = list.get(i);
                list.set(i, list.get(min_idx));
                list.set(min_idx, temp);
            }
        }
        System.out.println(iteration);
    }
    void insertionSort(ArrayList<Integer> list)
    {
        Integer iteration = 0;
        for(int i=1;i<list.size();i++)
        {
            Integer elementtosort = list.get(i);
            Integer j = i-1;
            iteration++;
            while(j>=0 && list.get(j)>elementtosort)
            {
                iteration++;
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, elementtosort);
        }
        System.out.println(iteration);
    }

    void bubbleSort(ArrayList<Integer> list)
    {
        Integer iteration = 0;
        for(int i=0;i<list.size();i++)
        {
            iteration++;
            for(int j=0;j<list.size()-1-i;j++)
            {
                iteration++;
                if(list.get(j)>list.get(j+1))
                {
                    Integer temp = list.get(j);
                    list.set(j,  list.get(j+1));
                    list.set(j+1,  temp);
                }
            }
        }
        System.out.println(iteration);
    }

   public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        Integer n = sc.nextInt();
        System.out.println("Enter the elements to the list to perform sorting");
        while(n-->0)
        {
            al.add(sc.nextInt());       
        }
        Sorting sorting = new Sorting();
        sorting.selectionSort(al);
        System.out.println(al.toString());
   } 

}
