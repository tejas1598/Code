public class majority_number {

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Example 1: [3, 2, 3]
        int[] nums1 = {3, 2, 3};
        System.out.println("Input: [3, 2, 3]");
        System.out.println("Output: " + solver.majorityElement(nums1));

        // Example 2: [2, 2, 1, 1, 1, 2, 2]
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("\nInput: [2, 2, 1, 1, 1, 2, 2]");
        System.out.println("Output: " + solver.majorityElement(nums2));
    }

    // --- SOLUTION CLASS ---
    static class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                // If count is 0, we pick a new candidate
                if (count == 0) {
                    candidate = num;
                }

                // If current number matches candidate, increment
                // Otherwise, decrement (cancel out)
                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            return candidate;
        }
    }
}