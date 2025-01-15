package org.example.codingtest;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1. 핵심 알고리즘
 * - 한번에 갈때 먼거리의 위치들을 우선적으로 해결한다.
 *   정렬 알고리즘이 중요하다.
 *   퀵 정렬, 힙 정렬을 고려할 수 있다.
 * 
 * - 음수와 양수를 나누어 처리한다.
 *
 * 2. 자료구조
 * - 음수와 양수과 섞여있으므로 원소 하나씩 검토하면서 정렬한다.
 *   따라서 우선순위 큐의 힙 정렬을 선택한다.
 *   양수는 가장 큰 원소들을 먼저 처리해야 하므로 최대힙을 활용한다.
 *   음수는 가장 작은 원소들을 먼저 처리해야 하므로 최소힙을 활용한다.
 *   
 * - 또는 음수들을 양수로 변환하여 또다른 최대힙에 저장한다. 
 *
 * 3. 시간 복잡도
 * - 힙 구축: O(n)
 * - 힙 정렬: O(n log n)
 *
 * 4. 공간 복잡도
 * - O(n)
 */
public class Main {
    public static int solution(int bookMax, String bookPositions) {
        var positiveHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        var negativeHeap = new PriorityQueue<Integer>();

        Arrays.stream(bookPositions.split(" "))
                .map(Integer::parseInt)
                .forEach(n -> {
                    if (n > 0) {
                        positiveHeap.offer(n);
                    } else {
                        negativeHeap.offer(n);
                    }
                });

        int answer = 0;
        int max = 0;

        while (!positiveHeap.isEmpty()) {
            int current = positiveHeap.poll();
            max = Math.max(max, current);
            answer += current;
            for (int i = 0; i < bookMax - 1; i++) {
                if (positiveHeap.isEmpty()) {
                    break;
                }
                positiveHeap.poll();
            }
        }

        while (!negativeHeap.isEmpty()) {
            int current = - negativeHeap.poll();
            max = Math.max(max, current);
            answer += current;
            for (int i = 0; i < bookMax - 1; i++) {
                if (negativeHeap.isEmpty()) {
                    break;
                }
                negativeHeap.poll();
            }
        }

        return 2 * answer - max;
    }

    public static void main(String[] args) {
        int[] bookMax = {
                2,
                3,
                2,
                1
        };

        String[] bookPositionsSet = {
                "-37 2 -6 -39 -29 11 -28",
                "-18 -9 -4 50 22 -26 40 -45",
                "3 4 5 6 11 -1",
                "-1",
        };

        for (int i = 0; i < bookPositionsSet.length; i++) {
            System.out.println(solution(bookMax[i], bookPositionsSet[i]));
        }
    }
}