import java.util.HashSet;
import java.util.Set;

public class code1 {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        String s1 = "abcabcbb";
        int result1 = solver.lengthOfLongestSubstring(s1);
        System.out.println("Input: \"" + s1 + "\" | Output: " + result1);

        // Test Case 2
        String s2 = "bbbbb";
        int result2 = solver.lengthOfLongestSubstring(s2);
        System.out.println("Input: \"" + s2 + "\" | Output: " + result2);

        // Test Case 3
        String s3 = "pwwkew";
        int result3 = solver.lengthOfLongestSubstring(s3);
        System.out.println("Input: \"" + s3 + "\" | Output: " + result3);
    }
}

// This is the solution class you use in LeetCode
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        
        Set<Character> set = new HashSet<>();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(c);
            max = Math.max(max, set.size());
            right++;
        }
        
        return max;
    }
}