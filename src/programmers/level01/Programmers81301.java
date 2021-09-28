package level01;

/**
 *
 * 숫자 문자열과 영단어
 *
 */

public class Programmers81301 {

    public static void main(String[] args) {
        Programmers81301 programmers81301 = new Programmers81301();

        System.out.println(programmers81301.solution("2three45sixsevenseven"));

    }

    public int solution(String s) {


        String[] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for (int i=0; i<numbers.length; i++) {
            s = s.replace(numbers[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }

}
