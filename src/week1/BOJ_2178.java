package week1;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 1. 아이디어
* - BFS 이용
* - 상하좌우 갈 수 있는지 판별하여 가능하면 queue에 넣고 방문 처리
* -
*
* 2. 시간복잡도
*
* 3. 자료구조
* - int[][]: N*M 미로
* - boolean[][]: 방문 체크
* - Queue(BFS)
*  */

public class BOJ_2178 {
    static int n, m;
    static int[][] arr;
    static boolean[][] isVisit;
    static int[] dx = {-1, 1, 0, 0}; // x 방향 상하좌우
    static int[] dy = {0, 0, -1, 1}; // y 방향 상하좌우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        isVisit = new boolean[n][m];
        sc.nextLine();

        for (int i = 0; i < n; i++)
        {
            String line = sc.next();
            for (int j = 0; j < m; j++)
            {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        isVisit[0][0] = true;
        bfs(0,0);
        System.out.println(arr[n-1][m-1]);
    }

    public static void bfs(int x, int y)
    {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        isVisit[x][y] = true;

        while(!queue.isEmpty())
        {
            Point currentPoint = queue.poll();
            // 상하좌우 이동 가능 여부 판별
            for (int i = 0; i < 4; i++)
            {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                // 지도 안에 있는지 판별
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;
                // 막힌 길인지 판별
                if(arr[nextX][nextY] == 0)
                    continue;
                // 방문했는지 판별
                if(isVisit[nextX][nextY])
                    continue;

                // 갈 수 있는 길이면 queue에 삽입, 방문 처리
                queue.offer(new Point(nextX, nextY));
                isVisit[nextX][nextY] = true;
                // arr[nextX][nextY]에 이동 횟수를 기록
                arr[nextX][nextY] = arr[currentPoint.x][currentPoint.y] + 1;
            }
        }

    }
}
