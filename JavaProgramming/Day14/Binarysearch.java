import java.util.ArrayList;
import java.util.Scanner;

public class Binarysearch{
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        Integer n = sc.nextInt();
        System.out.println("Enter the elements in sorted order to perform binary search");
        while(n-->0)
        {
            al.add(sc.nextInt());            
        }
        System.out.println("Enter the elements to Search using binary search");
        n = sc.nextInt();
        Integer elementindex = binarySearch(al,0,al.size()-1,n);
        if(elementindex>=0)
        {
            System.out.println("Element found at index: "+elementindex);
        }
        else 
        {
            System.out.println("Element not found");
        }


    }

    private static Integer binarySearch(ArrayList<Integer> al, Integer low, Integer high,Integer key) {
        System.out.println("Low is Now: "+low);
        System.out.println("High is NOw: "+high);
        if(low<=high)
       {
         Integer mid = low + (high-low)/2;
         System.out.println("Now Mid is :"+mid);
         if(al.get(mid) == key){
                return mid;
         }
         else if(al.get(mid)>key){
            return binarySearch(al, low, mid-1, key);
         }
         else{
            return binarySearch(al, mid+1, high, key);
         }
       }
       else {
        return -1;
       }
    }
}