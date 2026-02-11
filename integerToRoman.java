public class integerToRoman {

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Example 1
        int num1 = 3749;
        System.out.println("Input: " + num1);
        System.out.println("Output: " + solver.intToRoman(num1)); 
        // Expected: "MMMDCCXLIX"

        // Example 2
        int num2 = 58;
        System.out.println("\nInput: " + num2);
        System.out.println("Output: " + solver.intToRoman(num2)); 
        // Expected: "LVIII"

        // Example 3
        int num3 = 1994;
        System.out.println("\nInput: " + num3);
        System.out.println("Output: " + solver.intToRoman(num3)); 
        // Expected: "MCMXCIV"
    }

    // --- SOLUTION CLASS ---
    static class Solution {
        public String intToRoman(int num) {
            // Define values and symbols in descending order
            // We include the "subtractive" cases (900, 400, 90, 40, 9, 4) directly
            int[] values = {
                1000, 900, 500, 400, 
                100, 90, 50, 40, 
                10, 9, 5, 4, 
                1
            };
            
            String[] symbols = {
                "M", "CM", "D", "CD", 
                "C", "XC", "L", "XL", 
                "X", "IX", "V", "IV", 
                "I"
            };

            StringBuilder result = new StringBuilder();

            // Loop through each symbol
            for (int i = 0; i < values.length; i++) {
                // While the current number is large enough to contain the value
                while (num >= values[i]) {
                    // Append the symbol
                    result.append(symbols[i]);
                    // Subtract the value
                    num -= values[i];
                }
            }

            return result.toString();
        }
    }
}