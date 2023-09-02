import java.math.*;
import java.util.*;

public class Fibonacci1{
    private static Scanner sc = new Scanner(System.in);

    public static List<BigInteger> fiborecur(BigInteger n1,BigInteger n2,long n){
     		if(n>=0)
     		{
     			BigInteger n3 = n1.add(n2);	
     			System.out.println(n3);
     			return fiborecur(n2,n3,n-1);	
		    }else{
            List<BigInteger> l1 = new ArrayList<BigInteger>();
            l1.add(n1);
            l1.add(n2);
            return l1;
            }
        }
    public static void main(String... args)
    {
        long input;
        long userreq;
        long nooftimesplayed=0;
        List<BigInteger> b1 = new ArrayList<BigInteger>();
        b1.add(new BigInteger("0"));
        b1.add(new BigInteger("1"));
        System.out.println("want to start the program,if yes type 1 else no type 0");
        userreq = sc.nextLong();
       while(userreq==1)
       {
         System.out.println("Enter the Number:");
         input = sc.nextLong();
         if(nooftimesplayed == 0)
         {
            System.out.println("The series is:");
             if(input==0)
            {
                System.out.println("0");
            }
            else if(input==1)
            {
                System.out.println("0");
                System.out.println("1");   
            }
           else if(input>2)
            {
                System.out.println("0");
                System.out.println("1"); 
                b1 = fiborecur(b1.get(0),b1.get(1),input-2);
            }
         }
         else
         {
            System.out.println("The Continued series is:");
            if(input==0)
            {
                System.out.println("0");
            }
            else if(input==1)
            {
                System.out.println("0");
                System.out.println("1");   
            }
           else if(input>2)
            {
                System.out.println("0");
                System.out.println("1"); 
                b1 = fiborecur(b1.get(0),b1.get(1),input-1);
            }
         }
         nooftimesplayed++;
         System.out.println("want to continue the program,if yes type 1 else no type 0");
         userreq = sc.nextLong();
       }
    }
}