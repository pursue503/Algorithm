package programmers.level01;

import java.time.LocalDate;

/**
 * 2016년
 */

public class Programmers12901 {

    public String solution(int a, int b) {

        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};

        int count = 0;

        if(a != 1) {
            for(int i=0; i<a -1; i++) {
                count += month[i];
            }
            count += b;

            if(count % 7 == 0) {
                return day[6];
            } else {
                count = count % 7;
                return day[count -1];
            }

        } else {

            if(b % 7 == 0 ) {
                return day[6];
            } else {
                b = b % 7;
                return day[b - 1];
            }

        }


    }

    public String solution2(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }

}
