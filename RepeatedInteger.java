import java.util.Arrays;

public class RepeatedInteger {

    public static void main(String[] args) {
        // Test Case 1
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        
        System.out.println("Original Array: " + Arrays.toString(nums));

        Solution solver = new Solution();
        int k = solver.RepeatedInteger(nums);

        System.out.println("Unique Count (k): " + k);
        
        // Print only the valid first 'k' elements
        System.out.print("Modified Array (First " + k + " elements): [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i < k - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // --- YOUR SOLUTION LOGIC ---
    static class Solution {
        public int RepeatedInteger(int[] nums) {
            // Edge case check
            if (nums.length == 0) return 0;

            // Pointer 'j' tracks the position for the NEXT unique element
            int j = 1;

            // Pointer 'i' explores the array
            for (int i = 1; i < nums.length; i++) {
                // If we found a new unique number (different from the previous one)
                if (nums[i] != nums[i - 1]) {
                    nums[j] = nums[i]; // Move it to the front (position j)
                    j++; // Move j forward
                }
            }

            // Return the count of unique elements
            return j;
        }
    }
}