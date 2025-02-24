/**
 * 1. 핵심 알고리즘
 * flag 변수를 활용하여 체크
 *
 * 2. 자료구조
 * boolean
 *
 * 3. 시간 복잡도
 * O(문자열 크기)
 *
 * 4. 공간 복잡도
 * O(문자열 크기)
 *
 */
public class Main {
    public static String solution(String test) {
        boolean capital = true;
        StringBuffer buffer = new StringBuffer(test.length());
        for (int i = 0; i < test.length(); i++) {
            char current = test.charAt(i);
            if (current == ' ') {
                capital = true;
                buffer.append(current);
            } else if (capital) {
                buffer.append(Character.toUpperCase(current));
                capital = false;
            } else {
                buffer.append(Character.toLowerCase(current));
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {

        String[] tests = {
                "3people unFollowed me",
                "for the last week"
        };

        for (String test: tests) {
            System.out.println(solution(test));
        }
    }
}