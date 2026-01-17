import java.util.*;

public class _9_1_two_sum
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int result;
        int[] arr={2,4,4,6};

        int len=arr.length;
        int[] result_arr=new int[2];

        System.out.print("what is required result : ");
        int toFind=s.nextInt();

        for(int i=0;i<len-1;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                int addition=arr[i]+arr[j];
                
                if(addition==toFind)
                {
                    result_arr[0]=i;
                    result_arr[1]=j;
                    break;
                }
            }
        }

        for(int l=0;l<2;l++)
        {
            System.out.print(result_arr[l]+" ");
        }
    }
}