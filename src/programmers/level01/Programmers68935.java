package level01;

/**
 *
 * 3진법 뒤집기
 *
 */

public class Programmers68935 {

    public static void main(String[] args) {
        System.out.println(solution(45));
    }

    public static int solution(int n) {
        int answer = 0;
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int num = n %3;
            n = n / 3;
            builder.append(num);
        }
        builder.reverse();
        for(int i=0; i<builder.length(); i++) {
            answer = (int) (answer + (Integer.parseInt(String.valueOf(builder.charAt(i)))  *  (3 * i == 0 ? 1 : Math.pow(3, i)) ));
        }
        return answer;
    }

}
