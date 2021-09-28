package level02;

import java.util.Arrays;

/**
 * 전화번호 목록
 */

public class Programmers42577 {

    public static void main(String[] args) {
        System.out.println(solution2(new String[]{"12", "567",  "1235","123", "88"}));
    }

    public static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        int index = 0;

        while (true) {
            if (index == phone_book.length - 1) break;

            for (int i = index + 1; i < phone_book.length; i++) {
                if (phone_book[index].length() == phone_book[i].length()) {
                    break;
                }
                if (phone_book[i].startsWith(phone_book[index])) {
                    return false;
                }
            }
            index++;

        }

        return true;
    }

    public static boolean solution2(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            if (phone_book[i +1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }


}
