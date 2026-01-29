public class _14_Longest_Common_Prefix {
    
    // --- MAIN METHOD (To run and test the code) ---
    public static void main(String[] args) {
        // Test Case 1
        String[] input1 = {"flower", "flow", "flight"};
        System.out.println("Input: [flower, flow, flight]");
        System.out.println("Result: " + longest_prefix(input1));

        System.out.println("-----------------");

        // Test Case 2
        String[] input2 = {"dog", "racecar", "car"};
        System.out.println("Input: [dog, racecar, car]");
        System.out.println("Result: \"" + longest_prefix(input2) + "\"");
    }

    // --- SOLUTION METHOD ---
    public static String longest_prefix(String[] strs) {
        // 1. Safety Check: If the list is empty, return ""
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 2. Assume the FIRST word is the prefix
        String prefix = strs[0];

        // 3. Loop through the rest of the words (starting from index 1)
        for (int i = 1; i < strs.length; i++) {
            
            // 4. Check if the current word (strs[i]) starts with our 'prefix'
            // indexOf returns 0 if it starts with it.
            // If it returns -1 or anything else, it means it doesn't match perfectly at the start.
            while (strs[i].indexOf(prefix) != 0) {
                
                // 5. Shorten the prefix by chopping off the last letter
                prefix = prefix.substring(0, prefix.length() - 1);

                // 6. If the prefix becomes empty, nothing matches. Stop.
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

}
