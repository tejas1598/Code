import java.util.*;

public class roman_number 
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Enter the word : ");
        String word=s.nextLine();

        int len=word.length();

        char[] arr=word.toCharArray();

        int I=1, V=5, X=10, L=50, C=100, D=500, M=1000;  
        
        int i=0;
        int result=0;

        while(i<len)
        {
            if(arr[i]=='I')
            {
                if(i+1<len && arr[i+1]=='V')
                {
                    result=result+4;
                    i=i+2;
                }
                else if(i+1<len && arr[i+1]=='X')
                {
                    result=result+9;
                    i=i+2;
                }
                else 
                {
                    result=result+I;
                    i++;
                }
            }
            else if(arr[i]=='V')
            {
                result=result+V;
                i++;
            }
            else if(arr[i]=='X')
            {
                if(i+1<len && arr[i+1]=='L')
                {
                    result=result+40;
                    i=i+2;
                }
                else if(i+1<len && arr[i+1]=='C')
                {
                    result=result+90;
                    i=i+2;
                }
                else 
                {
                    result=result+X;
                    i++;
                }
            }
            else if(arr[i]=='L')
            {
                result=result+L;
                i++;
            }
            else if(arr[i]=='C')
            {
                if(i+1<len && arr[i+1]=='D')
                {
                    result=result+400;
                    i=i+2;
                }
                else if(i+1<len && arr[i+1]=='M')
                {
                    result=result+900;
                    i=i+2;
                }
                else 
                {
                    result=result+C;
                    i++;
                }
            }
            else if(arr[i]=='D')
            {
                result=result+D;
                i++;
            }
            else if(arr[i]=='M')
            {
                result=result+M;
                i++;
            }
        }

        System.out.println(result);
    }    
}


// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000