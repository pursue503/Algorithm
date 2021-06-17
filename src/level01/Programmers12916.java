package level01;

import java.util.Arrays;

public class Programmers12916 {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }

    public static boolean solution(String s) {
        return Arrays.stream(s.split("")).map(String::toUpperCase).filter(str -> str.equals("P")).count() == Arrays.stream(s.split("")).map(String::toUpperCase).filter(str -> str.equals("Y")).count();
    }
}
