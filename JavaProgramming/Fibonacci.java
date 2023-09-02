import java.math.*;

public class Fibonacci
{
	public static int[] fiboiterative(int n){
		int n1 =0;
		int n2 =1;
		int fibo[] = new int[100000];
		fibo[0] = n1;
		fibo[1] = n2;
		for(int i=2;i<100000;i++)
		{
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		System.out.println(fibo[n]);
		return fibo;
	}
	public static int fiborecursive(int n){
	 if(n==0) return 0;
	 if(n==1) return 1;
	 return fiborecursive(n-1)+fiborecursive(n-2);
	}
	public static void fiboseries(int n){
		int fibo[] = fiboiterative(n);
		for(int i=0;i<n;i++)
		{
			System.out.print(fibo[i]+" ");
		}
	}
	// public static void fiboseriesrecursive(long n){
	// 	System.out.print("0 ");
	// 	System.out.print("1 ");
	// 		fiborecur(0,1,n-2);
    //  		}
    //  	public static void fiborecur(long n1,long n2,long n){
    //  		if(n>=0)
    //  		{
    //  			long n3 = n1+n2;	
    //  			System.out.print(n3+" ");
    //  			fiborecur(n2,n3,n-1);
	// 	}
	// }
	public static void fiboseriesrecursive(long n){
		System.out.print("0 ");
		System.out.print("1 ");
			fiborecur(new BigInteger("0"),new BigInteger("1"),n-2);
     		}
     	public static void fiborecur(BigInteger n1,BigInteger n2,long n){
     		if(n>=0)
     		{
     			BigInteger n3 = n1.add(n2);	
     			System.out.print(n3+" ");
     			fiborecur(n2,n3,n-1);
		}
	}
     		
	public static void main(String... args){
		/*fiboiterative(Integer.parseInt(args[0]));
		System.out.println(fiborecursive(Integer.parseInt(args[0])));
		fiboseries(Integer.parseInt(args[0]));*/
		fiboseriesrecursive(Long.parseLong(args[0]));
		
	}
}
