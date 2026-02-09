public class single_number {

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: [2, 2, 1]
        int[] nums1 = {2, 2, 1};
        System.out.println("Input: [2, 2, 1]");
        int result1 = solver.singleNumber(nums1);
        System.out.println("Output: " + result1); // Expected: 1

        System.out.println("-----------------");

        // Test Case 2: [4, 1, 2, 1, 2]
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Input: [4, 1, 2, 1, 2]");
        int result2 = solver.singleNumber(nums2);
        System.out.println("Output: " + result2); // Expected: 4
    }

    // --- YOUR SOLUTION LOGIC ---
    static class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            
            // XOR logic:
            // 0 ^ N = N
            // N ^ N = 0
            // So: A ^ B ^ A = B (The duplicates kill each other)
            for (int num : nums) {
                result = result ^ num;
            }
            
            return result;
        }
    }
}