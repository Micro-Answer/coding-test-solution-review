package src.week4;
/*
1. 아이디어
- 키와 몸무게 배열에 저장
- 모든 사람을 비교하여 자신보다 덩치가 큰 사람이 몇 명인지 셈
- 위 수 + 1이 자신의 덩치 등수

2. 자료구조
- int[][]: 키, 몸무게 저장
- int[]: 등수 저장

3. 시간복잡도

4. 공간복잡도
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] people = new int[n][2];
        int[] ranks = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
            ranks[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue; // 자기 자신과는 비교하지 않음
                if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    ranks[i]++; // 자신보다 큰 사람이 있다면 등수 증가
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int rank: ranks) {
            sb.append(rank).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
