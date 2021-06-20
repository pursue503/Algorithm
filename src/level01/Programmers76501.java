package level01;

import java.util.Arrays;

public class Programmers76501 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solution(new int[]{4,7,12}, new boolean[]{true,false,true} ));
        long end = System.currentTimeMillis();

        System.out.println("time : " + (end - start));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] :  absolutes[i] * -1;
        }

        return answer;
    }


    //람다
    public static int solution2(int[] absolutes, boolean[] signs) {
        for(int i=0; i<absolutes.length; i++) {
            if(!signs[i]) {
                absolutes[i] *= -1;
            }
        }
        return Arrays.stream(absolutes).sum();
    }

}
