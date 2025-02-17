package src.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1. 아이디어
- bfs 이용

2. 자료구조
- char[][]:
- boolean[][] : 방문 여부 저장
- queue: bfs 탐색

3. 시간 복잡도
- 각 병사 영역 한 번씩 탐색 -> O(n * m)
: n, m 최댓값은 100, 최악의 경우 n * m = 10000 < 2억 (시간제한 2초, 자바는 1초에 1억번 연산)

4. 공간 복잡도
- soldier : O(n*m)
- visited: O(n*m)
- queue : 최악의 경우, 모든 병사 탐색 -> O(n*m)
 */

public class BOJ_1303 {
    static char soldiers[][];
    static int n, m, sumW, sumB;
    static boolean visited[][];
    static int dx[] = new int[]{-1, 0, 1, 0};
    static int dy[] = new int[]{0, 1, 0, -1};

    static int bfs(int x, int y, char type){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(!visited[nx][ny] && soldiers[nx][ny] == type){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        soldiers = new char[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                soldiers[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    char currentType = soldiers[i][j];
                    int cnt = bfs(i, j, currentType);
                    if(currentType == 'W')
                        sumW += cnt * cnt;
                    else
                        sumB += cnt * cnt;
                }
            }

        }

        System.out.println(sumW + " " + sumB);
    }
}
