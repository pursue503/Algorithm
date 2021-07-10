package level01;

/**
 *
 * 문자열 다루기 기본
 *
 */

public class Programmers12918 {

    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) {
            return false;
        }

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            try {
                int num = Integer.parseInt(String.valueOf(c));
            } catch (NumberFormatException e) {
                return false;
            }

        }

        return true;
    }

}
