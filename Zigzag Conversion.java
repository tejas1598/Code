class Solution {
    public String convert(String s, int numRows) {
        // EDGE CASE: If 1 row, zigzag is impossible, return original string
        if (numRows == 1) return s;

        int len = s.length();
        
        // 1. REPLACING row1, row2... WITH A 2D ARRAY
        // We create 'numRows' arrays, each as big as the string length
        char[][] rows = new char[numRows][len];
        
        // 2. REPLACING i, j, k, l WITH AN ARRAY OF COUNTERS
        // counters[0] is 'i', counters[1] is 'j', etc.
        int[] counters = new int[numRows]; 

        int currentrow = 1;
        int direction = 1; // 1 for down, -1 for up

        char[] arr = s.toCharArray();

        // 3. YOUR EXACT LOOP LOGIC
        for (char x : arr) {
            
            // "row[currentrow]" logic
            // We subtract 1 because array indices start at 0, but your logic uses 1-based rows
            int r = currentrow - 1; 
            
            // Assign character to the specific row array
            rows[r][counters[r]] = x;
            
            // Increment the specific counter for that row (like i++ or j++)
            counters[r]++;

            // YOUR DIRECTION LOGIC (Unchanged)
            if (currentrow == numRows) {
                direction = -1;
            } 
            else if (currentrow == 1 && direction == -1) {
                direction = 1;
            }

            // Move currentrow
            currentrow += direction;
        }

        // 4. PRINTING LOGIC (Concatenating the arrays)
        StringBuilder result = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            // Only append the valid characters (up to the counter value)
            for (int c = 0; c < counters[r]; c++) {
                result.append(rows[r][c]);
            }
        }

        return result.toString();
    }
}