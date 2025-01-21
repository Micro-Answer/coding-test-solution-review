package src.week3;

import java.util.*;

public class PG_pick_tangerine {
    public int solution(int k, int[] tangerine) {
        int sum = 0; // 현재까지 선택한 귤 개수의 합
        int answer = 0; // 서로 다른 귤 크기의 수
        HashMap<Integer, Integer> map = new HashMap<>(); // 귤 크기별로 그 크기의 귤 개수 저장

        for(int i: tangerine){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        for(int v : list){
            sum += v;
            answer++;
            if(sum >= k)
                break;
        }
        return answer;
    }
}
