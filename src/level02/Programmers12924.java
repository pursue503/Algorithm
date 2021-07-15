package level02;

/**
 * 
 * 숫자의 표현
 * 
 */
public class Programmers12924 {

    public static void main(String[] args) {
        Programmers12924 programmers12924 = new Programmers12924();
        System.out.println(programmers12924.solution(15));

    }

    public int solution(int n) {
        int answer = 0;

        int target = n / 2;

        int count = 1;
        while (count <= target) {
            int sum = 0;
            for(int i=count; i<=n; i++) {
                sum += i;
                if(sum == n) {
                    answer++;
                }
                if(sum > n) {
                    break;
                }
            }
            count++;
        }
        return answer + 1;
    }

}
