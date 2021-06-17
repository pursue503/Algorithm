package level01;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers67256 {

    public static void main(String[] args) {

        String[][] phoneArr = {
                {"1","2","3"},
                {"4","5","6"},
                {"7","8","9"},
                {"*","0","#"}
        };

        for(int i=0; i<phoneArr.length; i++){
            for(int j=0; j<phoneArr[i].length; j++) {
                System.out.print(phoneArr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }


    }

    public static String solution(int[] numbers, String hand) {

        String[][] phoneArr = {
                {"1","2","3"},
                {"4","5","6"},
                {"7","8","9"},
                {"*","0","#"}
        };


        StringBuilder builder = new StringBuilder();

        String left = "*";

        String right = "#";

        for(int i=0; i<numbers.length; i++) {
            // 1 4 7 은 왼손으로만 누른다

            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                builder.append("L");
                left = String.valueOf(numbers[i]);
                continue;
            } else if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                builder.append("R");
                right = String.valueOf(numbers[i]);
                continue;
            }

            // 나머지 2 5 8 0



        }

        return null;
    }

}
