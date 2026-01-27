import java.util.*;

public class learn1 
{
    public static void main(String[] args)
    {
        char[] arr={'a','b','c','b','c'};
        int len_1=arr.length;

        // This assumes the palindrome is always in the absolute center
        int centerIndex = (len_1-1)/2; 

        int len1 = centerIndex - 1;
        int len2 = centerIndex + 1;
        int gate = 0;

        while(gate == 0)
        {
            // Added boundary checks so we don't crash if len1 < 0 or len2 >= length
            if(len1 >= 0 && len2 < len_1 && arr[len1] == arr[len2])
            {
                len1 = len1 - 1;
                len2 = len2 + 1;
            }
            else
            {
                gate = 1;
            }
        }

        // CORRECTION: The loop broke because match failed or bounds reached.
        // We must step back inward to get the valid palindrome range.
        int start = len1 + 1;
        int end = len2 - 1;

        int i = start;
        while(i <= end)
        {
            System.out.print(arr[i]);
            i++; // CORRECTION: Increment i
        }
    }    
}
