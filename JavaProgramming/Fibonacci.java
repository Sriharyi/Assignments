public class Fibonacci
{
	public static void fiboiterative(int n){
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
	}
	public static int fiborecursive(int n){
	 if(n==0) return 0;
	 if(n==1) return 1;
	 return fiborecursive(n-1)+fiborecursive(n-2);
	}
	public static void main(String... args){

		fiboiterative(Integer.parseInt(args[0]));
		System.out.println(fiborecursive(Integer.parseInt(args[0])));
		
	}
}
