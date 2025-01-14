package src.week2;

/*
1. 아이디어
- 가장 먼 곳을 가장 마지막에 가도록
- 정렬, 그리디 알고리즘 사용
    - 음수, 양수를 나누어 각자 정렬
    - 가장 먼 곳에 있는 책은 해당 숫자만 더해줌(왕복할 필요 x)
    - input % M == 0인 수는 *2 해서 더함

2. 자료구조
- plus : int[]
- minus : int[]

3. 시간복잡도
- Collections.sort() 수행 -> O(nlog(n))
- 거리 계산: plus, minus 각각 for문 1번씩 수행 -> O(2n)
- O(2n+nlng(n)) ~= O(nlogn)

4. 공간복잡도
- 입력 데이터 저장: 배열 O(N)
- 리스트 저장
    - plus, minus 각각 최대 O(N)
- 전체 공간복잡도: O(N)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1461 {
    static int N, M, max, answer;
    static String[] input;
    static ArrayList<Integer> plus, minus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        plus = new ArrayList<>();
        minus = new ArrayList<>();

        input = br.readLine().split(" ");
        for(int i = 0; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);
            // 가장 큰 절댓값을 max에 저장
            if(max < Math.abs(num)){
                max = Math.abs(num);

            }
            // 음수, 양수 구별하여 ArrayList에 저장
            if(num > 0){
                plus.add(num);
            }
            else
                minus.add(Math.abs(num));
        }

        // 오름차순 정렬
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        for(int i = 0; i < plus.size(); i++) {
            if(i % M == 0 && plus.get(i) == max)
                answer += plus.get(i);
            else if(i % M == 0)
                answer += (plus.get(i ) * 2);
        }

        for(int i = 0; i < minus.size(); i++) {
            if(i % M == 0 && minus.get(i) == max)
                answer += minus.get(i);
            else if(i % M == 0)
                answer += (minus.get(i) * 2);
        }

        System.out.println(answer);
    }
}