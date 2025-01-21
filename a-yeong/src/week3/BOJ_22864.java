package src.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22864 {
    public static int a, b, c, m;
    public static int fatigue = 0;
    public static int hour = 0;
    public static int result = 0;

    public static void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        while(hour < 24){
            if(a + fatigue <= m){
                fatigue += a;
                result += b;
            }
            else {
                fatigue -= c;
                if(fatigue < 0)
                    fatigue = 0;
            }
            hour++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        work();
    }

}
