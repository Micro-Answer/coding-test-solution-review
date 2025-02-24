import java.util.HashMap;
import java.util.Map;

/**
 * 1. 핵심 알고리즘
 *    1) map에 개수 저장
 *    2) value 집합 정렬
 *    3) Greedy하게 선택
 *
 * 2. 자료구조
 *    1) map
 *    2) 스트림
 *    3) 배열
 *
 * 3. 시간 복잡도
 *    O(n log n)
 *    1) map에 개수 저장 - O(n)
 *    2) value 집합 정렬 - O(n log n)
 *    3) Greedy하게 선택 - O(n)
 *
 * 4. 공간 복잡도
 *    O(n)
 *
 */
public class Main {
    public static int solution(int n, int[] tangerine) {
//        1) map에 개수 저장
        Map<Integer, Integer> map = new HashMap<>();
        for (int key: tangerine) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

//        2) value 집합 정렬
        Integer[] arr = map.values().stream()
                .sorted((a, b) -> b - a)
                .toArray(Integer[]::new);

//        3) Greedy하게 선택
        int answer = 0;
        for (int count: arr) {
            n -= count;
            answer++;
            if (n <= 0) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] n = {
                6,
                4,
                2
        };

        int[][] tests = {
                {1, 3, 2, 5, 4, 5, 2, 3},
                {1, 3, 2, 5, 4, 5, 2, 3},
                {1, 1, 1, 1, 2, 2, 2, 3}
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println(solution(n[i], tests[i]));
        }
    }
}