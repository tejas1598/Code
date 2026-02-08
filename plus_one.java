import java.util.Arrays;

public class plus_one {

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Case 1: Simple
        int[] digits1 = {1, 2, 3};
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + Arrays.toString(solver.plusOne(digits1)));

        // Case 2: Carry over
        int[] digits2 = {1, 2, 9};
        System.out.println("\nInput: [1, 2, 9]");
        System.out.println("Output: " + Arrays.toString(solver.plusOne(digits2)));

        // Case 3: All 9s (Array Resize)
        int[] digits3 = {9, 9, 9};
        System.out.println("\nInput: [9, 9, 9]");
        System.out.println("Output: " + Arrays.toString(solver.plusOne(digits3)));
    }

    // --- SOLUTION CLASS ---
    static class Solution {
        public int[] plusOne(int[] digits) {
            
            // Start from the very last digit and move backwards
            for (int i = digits.length - 1; i >= 0; i--) {
                
                // Case A: The digit is less than 9
                // We just add 1 and we are done!
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits; // Return immediately
                }
                
                // Case B: The digit is 9
                // It becomes 0, and the loop continues to the next digit (carry over)
                digits[i] = 0;
            }

            // Case C: If we are still here, it means ALL digits were 9.
            // Example: input was [9, 9, 9] -> now it is [0, 0, 0]
            // We need a new array with one extra slot.
            int[] newNumber = new int[digits.length + 1];
            
            // In Java, new int[] is full of 0s by default.
            // We just need to set the first digit to 1.
            // Result becomes [1, 0, 0, 0]
            newNumber[0] = 1;
            
            return newNumber;
        }
    }
}