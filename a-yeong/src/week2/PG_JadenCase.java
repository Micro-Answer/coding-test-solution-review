package src.week2;

public class PG_JadenCase {
    public static String solution(String s) {
        String answer = "";
        answer = answer + Character.toUpperCase(s.charAt(0));
        for(int i = 1 ; i < s.length(); i++){
            if(s.charAt(i - 1) == ' ')
                answer = answer + Character.toUpperCase(s.charAt(i));
            else
                answer = answer + Character.toLowerCase(s.charAt(i));
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("3people unFollowed me");
        solution("for the last week");
    }
}
