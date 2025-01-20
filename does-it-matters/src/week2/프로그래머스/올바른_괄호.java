/**
 * 1. 핵심 알고리즘
 * 비트 연산자를 활용하여 최종 결과가 1인지 확인한다.
 *
 * 2. 자료구조
 * 정수
 *
 * 3. 시간 복잡도
 * O(문자열 크기)
 *
 * 4. 공간 복잡도
 * O(문자열 크기)
 *
 */
public class Main {
    public static boolean solution(String test) {
        int result = 1;
        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(i) == '(') {
                result <<= 1;
            } else {
                result >>= 1;
            }
        }

        return result == 1;
    }

    public static void main(String[] args) {

        String[] tests = {
                "()()",
                "(())()",
                ")()(",
                "(()(",

        };

        for (String test: tests) {
            System.out.println(solution(test));
        }
    }
}