public class FindIndex {

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Example 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Haystack: " + haystack1 + ", Needle: " + needle1);
        System.out.println("Index: " + solver.strStr(haystack1, needle1)); 
        // Expected: 0

        // Example 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("\nHaystack: " + haystack2 + ", Needle: " + needle2);
        System.out.println("Index: " + solver.strStr(haystack2, needle2)); 
        // Expected: -1
    }

    // --- SOLUTION CLASS ---
    static class Solution {
        public int strStr(String haystack, String needle) {
            // Edge case: empty needle is found at index 0
            if (needle.length() == 0) return 0;

            int hLen = haystack.length();
            int nLen = needle.length();

            // We iterate through the haystack
            // Optimization: iterate only as long as the needle fits
            // i.e., stop when i > hLen - nLen
            for (int i = 0; i <= hLen - nLen; i++) {
                
                // Check if the substring starting at i matches the needle
                boolean match = true;
                for (int j = 0; j < nLen; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        match = false;
                        break; // Stop checking this window
                    }
                }

                if (match) {
                    return i; // Found it!
                }
            }

            return -1; // Not found
        }
    }
}