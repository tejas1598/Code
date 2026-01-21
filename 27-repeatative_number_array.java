import java.util.*;

public class repeatative_number_array 
{
    public static void main(String[] args)
    {
        int[] arr={0,1,2,2,3,0,4,2};
        int len_arr=arr.length;
        int toRemove=2;
        int run=0;
      
        for(Integer z:arr)
        {
            if(z==toRemove)
                run++;
        }
        int[] result=new int[len_arr-run];

        int i=0,k=0;

        for(Integer x:arr)
        {
            if(x!=toRemove)
            {
                result[k]=x;
                k++;
            }
        }

        int count=0;
        for(Integer y:result)
        {
            count++;
            System.out.print(y);
        }

        System.out.println(" "+count);
    }    
}
