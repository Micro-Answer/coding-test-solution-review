import java.util.*;

class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int binaryCount = 0;

        while (!s.equals("1")) {
            int originalLength = s.length();

            s = s.replaceAll("0", "");

            int newLength = s.length();
            zeroCount += (originalLength - newLength);

            s = Integer.toBinaryString(newLength);
            binaryCount++;
        }
        return new int[] {binaryCount, zeroCount};
    }
}
