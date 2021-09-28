package level01;

//정수 제곱근 판결

import java.util.stream.LongStream;

public class Programmers12934 {

    public long solution(long n) {
        return LongStream.of(n).map(s ->
                {
                    int count = 1;
                    double num = (double) s / 2;
                    while (true) {
                        if(num - count < 0) {
                            if(num * 2 == count) {
                                return (long) (count + 1) * (count + 1);
                            } else {
                                return -1;
                            }
                        }
                        num = num - count;
                        count++;

                    }
                }
        ).max().orElse(-1);
    }

}
