import java.util.*;

class Solution {
    public String solution(String s) {
        String[] temp = s.split("");
        temp[0] = temp[0].toUpperCase();

        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i].toLowerCase();

            if (temp[i - 1].equals(" ")) {
                temp[i] = temp[i].toUpperCase();
            }
        }
        return String.join("", temp);
    }
}
