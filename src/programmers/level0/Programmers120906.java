package programmers.level0;

public class Programmers120906 {
    public int solution(int n) {
        return (int) String.valueOf(n)
                .chars()
                .mapToLong(value -> value - 48)
                .sum();
    }
}
