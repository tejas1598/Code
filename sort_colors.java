import java.util.*;

public class sort_colors 
{
    // HINT 1: Fix the swap logic here
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; // Used temp here
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 1, 5, 3};
        int len = arr.length;
        int k = 0;

        // Outer loop: Move the boundary of the sorted part
        while(k < len - 1)
        {
            // Assume the first element of the unsorted part is the smallest
            int minIndex = k; 

            // Inner loop: Find the REAL smallest element in the rest of the array
            // HINT 3: Use 'len', not 5
            for(int i = k + 1; i < len; i++)
            {    
                // HINT 4: Compare arr[i] with arr[minIndex]
                if(arr[i] < arr[minIndex])
                {
                    minIndex = i; // Save the INDEX, not the value
                }                      
            }

            // Swap the found smallest element with the element at position k
            swap(arr, k, minIndex);

            // HINT 2: Move to the next spot
            k++;
        }

        for(int x : arr)
        {
            System.out.print(x + " ");
        }
    }    
}