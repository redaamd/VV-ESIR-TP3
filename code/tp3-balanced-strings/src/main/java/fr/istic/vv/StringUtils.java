package fr.istic.vv;
import java.util.Stack;
public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        // Traverse each character in the string
        for (char ch : str.toCharArray()) {
            // If the character is an opening symbol, push it to the stack
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // If the character is a closing symbol, check if it matches the top of the stack
            else if (ch == ')' || ch == ']' || ch == '}') {
                // If stack is empty or top of the stack doesn't match, return false
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all opening symbols were matched; otherwise, return false
        return stack.isEmpty();

    }
     // Helper function to check if the pair of symbols is matching
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
            (open == '[' && close == ']') ||
            (open == '{' && close == '}');
    }

}
