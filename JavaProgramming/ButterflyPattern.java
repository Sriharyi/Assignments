    import java.util.*;
    public class ButterflyPattern{
        public static void main(String srgs[])
        {
            Scanner sc = new Scanner(System.in);
            Integer input = sc.nextInt();
            Integer mulinput = input * 2;
            printPattenRecur(input,mulinput,0,'*');
        }
        public static void printPattenRecur(int input,int mulinput,int row,char ch)
        {
            if(row!=input){
                    printpattern(input,mulinput,row,ch);
                    row++;
                    printPattenRecur(input,mulinput,row,ch);
                    row--;
                    ch = '-';
                    printpattern(input,mulinput,row,ch);
                }
            }
           public static void printpattern(int input,int mulinput,int row,char ch)
            {
                    System.out.println();
                    for(int i=0;i<=row;i++)
                    {
                        System.out.print(ch);
                    }
                    for(int i=row;i<mulinput-row-2;i++)
                    {
                        System.out.print(" ");   
                    }
                    for(int i=mulinput-row-1;i<mulinput;i++)
                    {
                        System.out.print(ch);
                    }
            }
    }