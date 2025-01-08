import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int X = 0;
            String[] num = br.readLine().split(" ");

            switch (Integer.parseInt(num[0])) {
                case 1:
                    X = Integer.parseInt(num[1]);
                    deque.addFirst(X);
                    break;
                case 2:
                    X = Integer.parseInt(num[1]);
                    deque.addLast(X);
                    break;
                case 3:
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeFirst()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case 4:
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeLast()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case 7:
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekFirst()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case 8:
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
