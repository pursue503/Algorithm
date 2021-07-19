package level02;


/**
 *
 * 다음 큰 숫자
 *
 */
public class Programmers12911 {

    public static void main(String[] args) {
        Programmers12911 programmers12911 = new Programmers12911();
        System.out.println(programmers12911.solution(78));
    }

    public int solution(int n) {

        int start = n + 1;

        int count = 0;
        while (n >= 1) {
            if(n % 2 == 1) {
                count++;
            }
            n = n / 2;
        }

        while (true) {
            int target = start;
            int targetCount = 0;

            while (target >= 1) {
                if(target % 2 == 1) {
                    targetCount++;
                }

                target = target / 2;
            }

            if(count == targetCount) {
                break;
            }
            start++;
        }

        return start;
    }

}
