/*
1. 아이디어
- 에너지 드링크 내림차순으로 정렬
- 가장 양이 많은 에너지드링크에 다른 에너지드링크 절반씩 더해서 계산

2. 자료구조
- int[] drinks: 에너지드링크의 양

3. 시간복잡도
- 에너지 드링크 계산할 때 N(드링크 개수)만큼 for문 반복
=> O(N^2)

4. 공간복잡도
- 에너지드링크 용량을 저장하는 drinks 배열: O(N^2) 사용
 */

package src.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20115 {
    static int n;
    static double ans;
    static double[] drinks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        drinks = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drinks[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(drinks);

        for (int i = n - 1; i >= 0; i--) {
            if(i == n - 1)
                ans = drinks[i];
            else
                ans += drinks[i] / 2;
        }

        System.out.println(ans);
    }
}
