package src.week3;

import java.util.Arrays;

public class PG_repeat_binary {
    public static int[] Solution(String s) {
        int[] answer = {};
        int zeroCount = 0;
        int repeatCount = 0;

        while(!s.equals("1"))
        {
            String noZero = "";
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == '0')
                    zeroCount++;
                else
                    noZero += "1";
            }
            s = Integer.toBinaryString(noZero.length());
            repeatCount++;
        }
        answer = new int[]{repeatCount, zeroCount};
        return answer;
    }

    public static void main(String[] args) {
        Solution("110010101001");
        Solution("01110");
        Solution("1111111");
    }
}
