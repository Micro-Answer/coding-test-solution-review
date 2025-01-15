package org.example.codingtest;

import java.util.ArrayDeque;

/**
 * 1. 핵심 알고리즘
 *
 * 2. 자료구조
 *
 * 3. 시간 복잡도
 *
 * 4. 공간 복잡도
 */
public class Main {
    public static void solution(String[] commands) {
        var stack = new ArrayDeque<Integer>();

        for (String command: commands) {
            char commandType = command.charAt(0);
            if (commandType == '1') {
                stack.addLast(Integer.parseInt(command.split(" ")[1]));
            } else if (commandType == '2') {
                System.out.println(stack.isEmpty() ? -1 : stack.removeLast());
            } else if (commandType == '3') {
                System.out.println(stack.size());
            } else if (commandType == '4') {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else {
                System.out.println(stack.isEmpty() ? -1 : stack.getLast());
            }
        }
    }

    public static void main(String[] args) {

        String[][] commandsSet = {
                {
                        "4",
                        "1 3",
                        "1 5",
                        "3",
                        "2",
                        "5",
                        "2",
                        "2",
                        "5"
                }
        };

        for (String[] commands: commandsSet) {
            solution(commands);
        }
    }
}