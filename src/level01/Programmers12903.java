package level01;

/**
 *
 * 가운데 글자 가져오기
 *
 */

public class Programmers12903 {

    public String solution(String s) {
        return s.length() % 2 == 0 ? s.substring(s.length() / 2 -1, s.length() / 2 +1) : String.valueOf(s.charAt(s.length() / 2));
    }

}
