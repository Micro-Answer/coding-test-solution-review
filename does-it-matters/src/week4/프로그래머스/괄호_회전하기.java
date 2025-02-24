import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1. 핵심 알고리즘
 *    1) 스택에 넣는 조건 체크
 *    2) 스택에서 빼는 조건 체크
 *    3) 올바르지 않은 문자열 체크
 *    4) 올바른 문자열 체크
 *
 * 2. 자료구조
 *    1) 스택
 *
 * 3. 시간 복잡도
 *    O(n ^ 2)
 *
 * 4. 공간 복잡도
 *    O(n)
 *
 */
public class Main {
    public static int solution(String data) {
        int answer = 0;
        outer: for (int i = 0; i < data.length(); i++) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = 0; j < data.length(); j++) {
                char current = data.charAt((i + j) % data.length());
//              1) 스택에 넣는 조건 체크
                if (current == '(' || current == '{' || current == '[') {
                    stack.addLast(current);
//              2) 스택에서 빼는 조건 체크
                } else if (current == ')' && !stack.isEmpty() && stack.getLast() == '(') {
                    stack.removeLast();
                } else if (current == '}' && !stack.isEmpty() && stack.getLast() == '{') {
                    stack.removeLast();
                } else if (current == ']' && !stack.isEmpty() && stack.getLast() == '[') {
                    stack.removeLast();
//              3) 올바르지 않은 문자열 체크
                } else {
                    continue outer;
                }
            }
//          4) 올바른 문자열 체크
            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] tests = {
                "[](){}",
                "}]()[{",
                "[)(]",
                "}}}",
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println(solution(tests[i]));
        }
    }
}