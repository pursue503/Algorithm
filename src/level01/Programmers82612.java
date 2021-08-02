package level01;

import java.util.stream.LongStream;

/**
 *
 * 1주차
 *
 */
public class Programmers82612 {


    //람다 , 스트림
    public long solution2(int price, int money, int count) {
        return LongStream.range(1, count + 1).map(s -> s * price).sum() - money <= 0 ? 0 :  LongStream.range(1, count + 1).map(s -> s * price).sum() - money;
    }
    
    //일반 풀이
    public long solution(int price, int money, int count) {
        long answer = 0;
        for(int i=1; i<=count; i++) {
            answer = answer + ( (long) i * price);
        }
        return answer - money <= 0 ? 0 : answer - money;
    }
    
}
