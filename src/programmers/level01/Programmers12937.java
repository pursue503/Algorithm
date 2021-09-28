package level01;

/**
 *
 * 짝수와 홀수
 *
 */
public class Programmers12937 {

    public String solution(int num) {
        return num == 0 ? "Even" : num % 2 == 0 ? "Even" : "Odd";
    }

}
