package src.week2;

import java.io.*;
import java.util.ArrayDeque;

public class BOJ_28278 {
    public static void main(String[] args) throws IOException {
        int N;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            if(input[0].equals("1")){
                stack.addFirst(Integer.parseInt(input[1]));
            }
            else if(input[0].equals("2")){
                bw.write(stack.isEmpty() ? "-1\n" : stack.pollFirst() + "\n");
            }
            else if(input[0].equals("3")){
                bw.write(stack.size() + "\n");
            }
            else if(input[0].equals("4")){
                bw.write(stack.isEmpty() ? "1\n" : "0\n");
            }
            else if(input[0].equals("5")){
                bw.write(stack.isEmpty() ? "-1\n" : stack.getFirst() + "\n");
            }
        }
        bw.flush();
    }
}
