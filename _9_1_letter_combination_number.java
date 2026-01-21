import java.util.*;

class Solution {
    // 1. YOUR ARRAYS (Moved here so all blocks can use them)
    String[] a2 = {"a", "b", "c"};
    String[] a3 = {"d", "e", "f"};
    String[] a4 = {"g", "h", "i"};
    String[] a5 = {"j", "k", "l"};
    String[] a6 = {"m", "n", "o"};
    String[] a7 = {"p", "q", "r", "s"};
    String[] a8 = {"t", "u", "v"};
    String[] a9 = {"w", "x", "y", "z"};

    // Helper function to pick the right array (Replace your huge if/else blocks)
    // This keeps your logic but saves us from writing it 4 times!
    public String[] getArray(char digit) {
        if (digit == '2') return a2;
        if (digit == '3') return a3;
        if (digit == '4') return a4;
        if (digit == '5') return a5;
        if (digit == '6') return a6;
        if (digit == '7') return a7;
        if (digit == '8') return a8;
        if (digit == '9') return a9;
        return new String[]{};
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int len = digits.length();

        // CASE 0: Empty Input
        if (len == 0) {
            return result;
        }

        // ===========================================
        // CASE 1: SINGLE DIGIT 
        // ===========================================
        if (len == 1) {
            String[] arr1 = getArray(digits.charAt(0));
            for (String s : arr1) {
                result.add(s);
            }
            return result;
        }

        // ===========================================
        // CASE 2: TWO DIGITS 
        // ===========================================
        if (len == 2) {
            String[] arr1 = getArray(digits.charAt(0));
            String[] arr2 = getArray(digits.charAt(1));

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    result.add(arr1[i] + arr2[j]);
                }
            }
            return result;
        }

        // ===========================================
        // CASE 3: THREE DIGITS 
        // ===========================================
        if (len == 3) {
            String[] arr1 = getArray(digits.charAt(0));
            String[] arr2 = getArray(digits.charAt(1));
            String[] arr3 = getArray(digits.charAt(2));

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    for (int k = 0; k < arr3.length; k++) {
                        result.add(arr1[i] + arr2[j] + arr3[k]);
                    }
                }
            }
            return result;
        }

        // ===========================================
        // CASE 4: FOUR DIGITS
        // ===========================================
        if (len == 4) {
            String[] arr1 = getArray(digits.charAt(0));
            String[] arr2 = getArray(digits.charAt(1));
            String[] arr3 = getArray(digits.charAt(2));
            String[] arr4 = getArray(digits.charAt(3));

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    for (int k = 0; k < arr3.length; k++) {
                        for (int l = 0; l < arr4.length; l++) {
                            result.add(arr1[i] + arr2[j] + arr3[k] + arr4[l]);
                        }
                    }
                }
            }
            return result;
        }

        return result;
    }
}