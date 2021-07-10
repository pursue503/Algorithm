package level01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 실패율
 *
 */


public class Programmers42889 {

    public int[] solution(int N, int[] stages) {
        //단계
        //스테이지
        int maxStage = N +1;

        Map<Integer, Double> resultMap = new HashMap<>();

        for(int i=1; i<maxStage; i++) {

            int human = 0;
            int total = 0;

            for(int j=0; j<stages.length; j++) {
                if(stages[j] == i) {
                    human++;
                }
                if(stages[j] >= i) {
                    total++;
                }
            }

            resultMap.put(i, (double) human / (double) total);

        }

        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Double> entry : resultMap.entrySet()) {
            int num = entry.getKey();
            double value = entry.getValue();
            for(Map.Entry<Integer, Double> entry1 : resultMap.entrySet()) {

                if(entry1.getKey() == num) {
                    continue;
                }
                if(list.contains(num)) {
                    num = entry1.getKey();
                    value = entry1.getValue();
                    continue;
                }

                if(list.contains(entry1.getKey())) {
                    continue;
                }

                if(entry1.getValue() > value) {
                    num = entry1.getKey();
                    value = entry1.getValue();
                    continue;
                }

                if(entry1.getValue() == value) {
                    if(entry1.getKey() < num) {
                        num = entry1.getKey();
                        value = entry1.getValue();
                        continue;
                    }
                }
            }

            list.add(num);

        }

        int[] answer = new int[list.size()];

        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
