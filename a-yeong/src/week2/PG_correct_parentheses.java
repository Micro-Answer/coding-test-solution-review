package src.week2;

/*
1. 아이디어
- stack 이용
- (: stack에 push
- ): stack이 비어있지 않고 바로 앞 문자가 )면 pop, 아니라면 push
- 문자열 길이만큼 for문 반복, stack이 비어있지 않다면 false  반환

2. 자료구조
- stack: ArrayDeque<Character>

3. 시간복잡도
- 문자열만큼 for문 반복: O(N)

4. 공간복잡도
- 문자열의 길이가 n일 때 arrayduque 공간복잡도 O(N)
 */
import java.util.ArrayDeque;

public class PG_correct_parentheses {
    static int cnt = 1;
    boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.add(s.charAt(i));
            else if (s.charAt(i) == ')') {
                if(!stack.isEmpty() && stack.getLast() == '(')
                    stack.poll();
                else
                    stack.add(s.charAt(i));

            }
        }

        if(!stack.isEmpty())
            answer = false;

        System.out.println("#" + cnt + " " + answer);
        cnt++;
        return answer;
    }

//    public static void main(String[] args) {
//        boolean ans1 = solution("()()");
//        boolean ans2 = solution("(())()");
//        boolean ans3 = solution(")()(");
//        boolean ans4 = solution("(()(");
//    }
}
