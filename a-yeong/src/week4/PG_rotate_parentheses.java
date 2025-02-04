package src.week4;

/*
1. 아이디어
- 원문은 queue에 넣고 회전
- stack을 이용하여 올바른 괄호 문자열인지 판별
- isValid: 올바른 괄호 문자열인지 판단하는 함수
    :(, {, [ 일 때 push
    :), }, ]일 때
        * stack이 비어있다면, 혹은 pop한 문자가 짝이 아니면 false 반환
        * pop한 문자가 짝이라면 true 반환
- isMatching: 괄호의 짝을 판단하는 함수

2. 자료구조
- queue<Character> : 문자열을 넣고 회전시킴
- stack<Chracter> : 괄호가 올바른지 판별

3. 시간복잡도
- for문 한 번 돌때마다 isValid 한 번 호출 -> n * isValid
- isValid: O(n)
- 전체 시간 복잡도: O(n^2)

4. 공간복잡도
- queue: 최대 n개까지 저장, O(n)
- stack: 최악의 경우 모든 문자열을 저장해야 함, O(n)
- 전체 공간 복잡도: O(n)
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class PG_rotate_parentheses {
    public static int solution(String s){
        int answer = 0;
        Queue<Character> str = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            str.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            if(isValid(str)) {
                answer++;
            }
            str.add(str.poll());
        }

        return answer;
    }

    private static boolean isValid(Queue<Character> str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str) {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(!isMatching(top, c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')' ||
                open == '{' && close == '}' ||
                open == '[' && close == ']');
    }
}
