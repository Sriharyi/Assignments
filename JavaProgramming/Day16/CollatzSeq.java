import java.util.HashMap;

public class CollatzSeq{
    public static void main(String[] args) {
        
        Long resultmax = -1l;
        Long num = -1l;
        HashMap<Long,Long> hmap = new HashMap<>();

        for(long i=1;i<=1000000;i++)
        {
            Long tempmax=0l;
            if(hmap.containsKey(i)==false)
            {
                tempmax = findterms(i,hmap);
            }
            else
            {
                tempmax = hmap.get(i);
            }
            if(tempmax>resultmax)
            {
                resultmax = tempmax;
                num = i;
            }
        }
        System.out.println("terms"+resultmax+"number is"+num);
    }

    private static Long findterms(long n, HashMap<Long, Long> hmap) {
        if(hmap.containsKey(n))
        {
            return hmap.get(n);
        }
        if(n==1)
            hmap.put(n, 1l);
        else if(n%2==0)
            hmap.put(n, 1 + findterms(n/2, hmap));
        else
            hmap.put(n, 1 + findterms(3*n + 1, hmap));  
        
        return hmap.get(n);
    }

    // private static int findterms(long n) {
    //     int count=1;
    //     while(n!=1){
    //         if(n%2==0)
    //         {
    //             n = n/2;
    //         }else{
    //             n = 3*n + 1;
    //         }
    //         count++;
    //     }
    //     return count;
    // }
}