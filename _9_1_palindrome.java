import java.util.*;

public class _9_1_palindrome
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number : ");
        int a=s.nextInt();

        if(a<0)
        {
            System.out.println("false");
            return;
        }
        
        int original=a;
        int reversed =0;

        while(a!=0)
        {
            int digit=a%10;
            reversed= reversed*10+digit;
            a=a/10;
        }

        if(original==reversed)
        {
            System.out.println(true);
        }

        else
            System.out.println(false);
    }
}