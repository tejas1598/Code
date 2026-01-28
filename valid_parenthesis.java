import java.util.*;

public class valid_parenthesis 
{
    public static void main(String[] args)    
    {
        String word = "[]}";
        System.out.println(isValid(word));
    }
    
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) return false;
                
                char top = stack.pop();
                if((c == ')' && top != '(') || 
                   (c == ']' && top != '[') || 
                   (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}