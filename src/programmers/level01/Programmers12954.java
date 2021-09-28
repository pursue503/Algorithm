package level01;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Programmers12954 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2,5)));
    }

    public static long[] solution(int x, int n) {
        long[] arr = new long[n];
        LongStream.range(0,n).map( i -> arr[(int) i] = x * (i + 1)).toArray();
        return arr;
    }

    public static long[] solution2(int x, int n) {
        long[] arr = new long[n];

        for(int i=0; i<n; i++) {
            arr[i] = (long) x * (i + 1);
        }

        return arr;
    }

}
