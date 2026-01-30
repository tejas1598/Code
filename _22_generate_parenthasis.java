import java.util.ArrayList;
import java.util.List;

public class _22_generate_parenthasis {

    // --- MAIN METHOD (To run in VS Code) ---
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Generating parentheses for n = " + n);
        
        _22_generate_parenthasis solver = new _22_generate_parenthasis();
        List<String> result = solver.generateParenthesis(n);
        
        System.out.println("Result: " + result);
    }

    // --- SOLUTION METHOD ---
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start the recursive process
        // current string = "", open count = 0, close count = 0
        backtrack(result, "", 0, 0, n);
        return result;
    }

    // --- HELPER FUNCTION (BACKTRACKING) ---
    // result: list to store completed valid strings
    // current: the string we are building right now
    // open: how many '(' we have used so far
    // close: how many ')' we have used so far
    // max: the target number 'n'
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        
        // 1. Base Case: If the string is complete (length is 2 * n)
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // 2. Decision 1: Can we add an Open bracket?
        // Only if we haven't used all 'n' opening brackets yet.
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // 3. Decision 2: Can we add a Close bracket?
        // Only if we have more open brackets than closed ones.
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}