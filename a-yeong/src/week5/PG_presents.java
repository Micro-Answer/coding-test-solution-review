package src.week5;

import java.util.Arrays;

/*
1. 아이디어
- 선물 주고 받은 내역을 int[][]에 저장
- 선물 지수(준 선물 - 받은 선물) 계산하여 int[][]에 저장
- 선물 내역 2중 for문 돌면서 다음달 선물 개수 계산
    - 두 명 비교해서 더 많은 선물을 준 사람에게 다음달 선물 +1
    - 주고받은 개수가 같으면 선물 지수 비교하여 더 높은 사람에게 다음달 선물 +1
    - 선물 개수까지 같다면 다음달에는 선물을 주고 받지 않음

2. 자료구조
- int[][] receives : 선물을 주고 받은 내역을 저장
- int[] : giftNum: 선물 지수
- int[] nextGift: 다음달 선물 받을 개수

3. 시간복잡도
- 다음달 선물 계산 시 2중 포문 돌기 때문에 O(N^2) : N은 친구 수
=> 총 시간복잡도 O(N^2)

4. 공간복잡도
- receives 배열이 O(N^2) 공간 사용
- giftNum, nextGift O(N)씩 공간 사용
=> 총 공간복잡도 O(N^2)
 */

public class PG_presents {
    static public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] receives = new int[n][n];
        // 누가 누구에게 선물을 줬는지 저장
        for (String gift : gifts) {
            String[] str = gift.split(" ");
            int fromIndex = Arrays.asList(friends).indexOf(str[0]);
            int toIndex = Arrays.asList(friends).indexOf(str[1]);
            receives[fromIndex][toIndex]++;
        }

        // 선물지수 계산
        int[] giftNum = new int[n];
        for (int i = 0; i < n; i++) {
            int giveNum = 0;
            int recNum = 0;
            for (int j = 0; j < n; j++) {
                giveNum += receives[i][j];
                recNum += receives[j][i];
            }
            giftNum[i] = giveNum - recNum;
        }

        // 다음달 선물 개수 계산
        int[] nextGift = new int[n];
        for (int i = 0; i < n; i++) {
            // 중복되어 계산되는 것을 막기 위해서 j는 i + 1부터 시작
            for (int j = i + 1; j < n; j++) {
                if(i == j) continue;

                // 더 많이 받은 사람이 다음 달에 상대방에게 선물을 줘야 함
                int garo = receives[i][j];
                int sero = receives[j][i];
                if(garo > sero){
                    nextGift[i]++;
                }
                else if (garo < sero) {
                    nextGift[j]++;
                }
                // 두 사람이 선물을 주고받은 기록이 없거나, 수가 같다면 선물지수 비교
                else{
                    if (giftNum[i] > giftNum[j])
                        nextGift[i]++;
                    else if(giftNum[i] < giftNum[j])
                        nextGift[j]++;
                    else continue;

                }
            }
        }


        int answer = Arrays.stream(nextGift).max().getAsInt();
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String[] friends = new String[]{};
        String[] gifts = new String[]{};

        friends = new String[]{"muzi", "ryan", "frodo", "neo"};
        gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        solution(friends, gifts);

        friends = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        gifts = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        solution(friends, gifts);

        friends = new String[]{"a", "b", "c"};
        gifts = new String[]{"a b", "b a", "c a", "a c", "a c", "c a"};
        solution(friends, gifts);
    }
}
