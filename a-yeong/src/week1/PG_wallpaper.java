package src.week1;

/*
- # 문자열이 포함된 좌표 이용해서 구하기
1. top, left에는 Integer의 가장 큰 값 저장 bottom, right에는 가장 작은 값 저장
2. wallpaper의 범위만큼 이중for문 돌기
    1) # 문자가 있다면
        - top: i와 top 비교하여 작은 값 저장
        - left: j와 top 비교하여 작은 값 저장
        - bottom: i+1과 bottom 비교하여 큰 값 저장
        - right: j+1과 right 비교하여 큰 값 저장
3. answer에 top, left, bottom, right 저장하여 출력
 */

public class PG_wallpaper {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++)
        {
            for(int j = 0; j < wallpaper[i].length(); j++)
            {
                if(wallpaper[i].charAt(j) == '#')
                {
                    top = Math.min(i, top);
                    left = Math.min(j, left);
                    // # 문자가 차지하는 부분을 선택하기 위해 bottom과 right을 구할 때는 i와 j에 +1
                    bottom = Math.max(i + 1, bottom);
                    right = Math.max(j + 1, right);
                }
            }
        }

        answer = new int[] {top, left, bottom, right};
        return answer;
    }
}
