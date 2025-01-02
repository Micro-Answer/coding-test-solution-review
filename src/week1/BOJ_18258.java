package week1;

import java.io.*;
import java.util.LinkedList;

/*
 * 1. 아이디어
 * - for문 n번 돌면서 switch문으로 명령어 실행
 *
 * 2. 시간복잡도
 * - O(N)
 *
 * 3. 자료구조
 * - queue: LinkedList
 */

public class BOJ_18258
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++)
        {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0])
            {
                case "push":
                    queue.add(Integer.parseInt(cmd[1]));
                    break;
                case "pop":
                    if(queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.pop() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "front":
                    if (queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.get(0) + "\n");
                    break;
                case "back":
                    if (queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.get(queue.size() - 1) + "\n");
                    break;
            }
        }

        bw.close();

    }
}