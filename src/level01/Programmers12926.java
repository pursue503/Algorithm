package level01;

/**
 *
 * 시저암호
 *
 */

public class Programmers12926 {

    public static void main(String[] args) {
        System.out.println(solution("AaZz", 25));
    }

    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        n = n % 26; // 26가 한바퀴 루프 나머지가 진짜이동.

        for (int i=0; i<s.length(); i++) {
            //공백도 처리해 줘야 한다.
            int ac = s.charAt(i);

            if(ac >= 65 && ac <= 90) { // 대문자
                ac += n;
                if(ac > 90) { // 대문자 최대 범위 90
                    ac = ac - 90 + 64;
                }

            } else if(ac >= 97 && ac <= 122) { // 소문자

                ac += n;
                if(ac > 122) {//소문자
                    ac = ac - 122 + 96;
                }

            }

            answer.append((char) ac);

        }
        return answer.toString();
    }

}
