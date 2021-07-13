package level02;

/**
 *
 * 124 나라의 숫자
 *
 */

public class Programmers12899 {


    /*
        1 -> 1
        2 -> 2
        3 -> 4
        4 -> 11 -> 1 1 -> 11
        5 -> 12 -> 1 2 -> 12
        6 -> 14 -> 2 ->
        7 -> 21 -> 2 1 -> 21
        8 -> 22 -> 2 2 -> 22
        9 -> 24 -> 3
        10 -> 41 -> 3 1 -> 41
        11 -> 42 -> 3 2 -> 42
        12 -> 44 -> 4
        13 -> 111 -> 4 1 -> 1 1 1 -> 1 1 1
        14 -> 112 -> 4 2 -> 3 1 2 -> 1 1 2
        15 -> 114 -> 5
        16 -> 121 -> 5 1 -> 3 2 1 ->1 2 1
        17 -> 122
        18 -> 124
        19 -> 141
        20 -> 142
        21 -> 144
        22 -> 211 -> 7 1 -> 2 1 1 -> 211
        23 -> 212
        24 -> 214
        25 -> 221
        26 -> 222
        27 -> 224
        28 -> 241
     */

    StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        Programmers12899 programmers12899 = new Programmers12899();
        for (int i=1; i<=10000; i++) {
            System.out.print(programmers12899.solution(i));

            System.out.println("   :   " + i);
            programmers12899.builder =  new StringBuilder();
        }

    }

    public String solution(int n) {

        if(n == 0) {
            return  builder.toString();
        }

        if(n == 3) {
            builder.insert(0, 4);
            return builder.toString();
        }

        if(n < 3) {
            builder.insert(0, n);
            return builder.toString();
        }

        if(n % 3 == 0) {
            builder.insert(0, 4);
            return solution(n / 3 - 1);
        } else {
            int num = n % 3;
            builder.insert(0,num);
            n = n / 3;
            return  solution(n);
        }

    }

}


