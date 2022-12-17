package programmers.level0;

import java.util.HashMap;
import java.util.Map;

public class Programmers120875 {
    // 기울기 y 축 / x 축
    public int solution(int[][] dots) {
        Map<Double, Double> map = new HashMap<>();
        for (int i=0; i<dots.length; i++) {
            for (int j= i + 1; j<dots.length; j++) {
                // y 값 증가량 - x 값 증가량 = 기울기
                double slope = (double) ( dots[i][1] - dots[j][1] ) / ( dots[i][0] - dots[j][0]);
                if (map.containsKey(slope)) {
                    return 1;
                }
                map.put(slope, slope);
            }
        }
        return 0;
    }
}
