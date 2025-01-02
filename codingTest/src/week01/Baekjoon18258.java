package week01;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 18258 - 큐 2
 * <pre>큐를 구현하고 여섯 가지 명령(push, pop, size, empty, front, back)을 처리하는 프로그램</pre>
 *
 * <pre>사용 자료구조 : LinkedList, Queue</pre>
 * <pre>시간 복잡도 : O(1)</pre>
 */
public class Baekjoon18258 {
    Queue<Integer> queue = new LinkedList<>();
    private void push(int x){
        queue.add(x);
    }
    private int pop(){
        if(queue.size() != 0){
            int result = queue.peek();
            queue.poll();
            return result;
        }
        else return -1;
    }
    private int size(){
        return queue.size();
    }
    private boolean isEmpty(){
        if (queue.size() == 0)
            return true;
        else return false;
    }
    private int front(){
        if (queue.isEmpty())
            return -1;
        else return queue.peek();
    }
    private int back(){
        if (queue.isEmpty())
            return -1;
        else return ((LinkedList<Integer>)queue).getLast();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Baekjoon18258 bk = new Baekjoon18258();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n;i++){
            String[] input = br.readLine().split(" ");

            switch (input[0]){
                case "push":
                    bk.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    bw.write(bk.pop() + "\n");
                    break;
                case "size":
                    bw.write(bk.size() + "\n");
                    break;
                case "empty":
                    bw.write((bk.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write(bk.front() + "\n");
                    break;
                case "back":
                    bw.write(bk.back() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

