import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        if (s.charAt(0) == ')') {
            answer = false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            }
        }

        if (stack.size() != 0) {
            answer = false;
        }
        return answer;
    }
}
