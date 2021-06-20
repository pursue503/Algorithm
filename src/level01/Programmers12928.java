package level01;


import java.util.stream.IntStream;

public class Programmers12928 {

    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n) {

         return n != 0 ? IntStream.range(1,n + 1).filter( s -> n % s == 0).sum() : 0;
    }

    public static int solution2(int n) {
        int answer = 0;
        if(n == 0) {
            return answer;
        } else {
            for(int i=1; i<=n; i++) {
                if(n % i == 0) {
                    answer += i;
                }
            }
            return answer;
        }
    }

}
