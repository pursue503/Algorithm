package level01;

/**
 *
 *
 *
 */

public class Programmers12948 {

    public String solution(String phone_number) {
        return phone_number.replaceAll(phone_number.substring(0, phone_number.length() -4), star(phone_number.length()));
    }

    private String star(int length) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<length -4; i++) {
            builder.append("*");
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

}
