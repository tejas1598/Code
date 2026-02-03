import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNA {

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Standard DNA sequence
        String input1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("Test 1: " + input1);
        System.out.println("Result: " + solver.findRepeatedDnaSequences(input1));

        // Test Case 2: Your specific case "AAAAAAAAAAA" (Length 11)
        String input2 = "AAAAAAAAAAA";
        System.out.println("\nTest 2: " + input2);
        System.out.println("Result: " + solver.findRepeatedDnaSequences(input2));
    }

    // --- YOUR LOGIC CLASS ---
    static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> seen = new HashSet<>();
            Set<String> repeated = new HashSet<>();

            int len = s.length();

            // We use <= because we need the loop to include the very last 
            // possible starting index for a 10-character window.
            for (int i = 0; i <= len - 10; i++) {
                String currSeq = s.substring(i, i + 10);

                if (seen.contains(currSeq)) {
                    repeated.add(currSeq);
                } else {
                    seen.add(currSeq);
                }
            }

            // Wrapping the Set into a List for the return type
            return new ArrayList<>(repeated);
        }
    }
}