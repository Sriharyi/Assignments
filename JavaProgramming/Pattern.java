import java.util.*;

class Pattern{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Integer input = sc.nextInt();
        System.out.print(input);
        Integer mulinput = input * 2;
        for(int i=0;i<=input;i++)
        {
            for(int j=0;j<i;j++)
            {
                System.out.print("*");
            }
            for(int j=i;j<mulinput-i;j++)
            {
                System.out.print(" ");
            }
            for(int j=mulinput-i;j<mulinput;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        input = input -1;
        for(int i=input;i>=0;i--)
        {
            for(int j=0;j<i;j++)
            {
                System.out.print("*");
            }
            for(int j=i;j<mulinput-i;j++)
            {
                System.out.print(" ");
            }
            for(int j=mulinput-i;j<mulinput;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}