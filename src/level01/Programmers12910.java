package level01;

import java.util.Arrays;

public class Programmers12910 {


    public int[] solution(int[] arr, int divisor) {
        return Arrays.stream(arr).filter( num -> num % divisor == 0).toArray().length == 0 ? new int[]{-1} : Arrays.stream(arr).filter( num -> num % divisor == 0).sorted().toArray();
    }

}
