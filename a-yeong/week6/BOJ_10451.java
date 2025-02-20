package week6;

// DFS 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10451 {
    static int[] graph;
    static boolean[] isVisit;
    static int t, n, cnt;

    static void dfs(int start) {
        isVisit[start] = true;
        if(!isVisit[graph[start]])
            dfs(graph[start]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            cnt = 0;
            n = Integer.parseInt(br.readLine());
            graph = new int[n + 1];
            isVisit = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < n + 1; i++) {
                if(!isVisit[i]){
                    dfs(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}




// BFS 사용

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BOJ_10451 {
//    static int[] graph;
//    static boolean[] isVisit;
//    static int cnt, t, n;
//
//    static void bfs(int start) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(start);
//        isVisit[start] = true;
//        while(!queue.isEmpty()){
//            int now = queue.poll();
//            if(!isVisit[graph[now]]){
//                isVisit[graph[now]] = true;
//                queue.offer(graph[now]);
//            }
//            else {
//                cnt++;
//                break;
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        t = Integer.parseInt(br.readLine());
//        for (int tc = 0; tc < t; tc++) {
//            n = Integer.parseInt(br.readLine());
//            cnt = 0;
//            graph = new int[n + 1];
//            isVisit = new boolean[n + 1];
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int i = 1; i < n + 1; i++) {
//                graph[i] = Integer.parseInt(st.nextToken());
//            }
//
//            for (int i = 1; i < n + 1; i++) {
//                if(!isVisit[i])
//                    bfs(i);
//            }
//
//            System.out.println(cnt);
//        }
//    }
//}