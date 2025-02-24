import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        final int COUNT = friends.length;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < COUNT; i++) {
            map.put(friends[i], i);
        }

        int[][] current = new int[COUNT][COUNT];
        for (String gift: gifts) {
            String[] token = gift.split(" ");
            current[map.get(token[0])][map.get(token[1])]++;
        }

        int[] point = new int[COUNT];
        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < COUNT; j++) {
                point[i] += current[i][j];
                point[i] -= current[j][i];
            }
        }

        int[] next = new int[COUNT];
        for (int i = 0; i < COUNT; i++) {
            for (int j = i + 1; j < COUNT; j++) {
                if (current[i][j] > current[j][i]) {
                    next[i]++;
                } else if (current[i][j] < current[j][i]) {
                    next[j]++;
                } else if (point[i] > point[j]) {
                    next[i]++;
                } else if (point[i] < point[j]) {
                    next[j]++;
                }
            }
        }

        int max = 0;

        for (int e: next) {
            max = Math.max(max, e);
        }
        return max;
    }
}